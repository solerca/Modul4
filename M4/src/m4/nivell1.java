package m4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class nivell1 {
	public static void main(String[] args) {

//		FASE 1
//		L’exercici consisteix a mostrar per consola una carta d’un restaurant on afegirem diferents
//		plats i després escollirem que volem per menjar. Un cop fet això s’haurà de calcular el preu
//		del menjar el programa ens dirà amb quins bitllets hem de pagar. 
//		Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€, haureu de crear
//		un altre variable per guardar el preu total del menjar.  
//		Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat.  

		String plats[] = new String[3];
		double preus[] = new double[3];

//		FASE 2
//		Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat
//		i després el preu. Pots fer us de diccionaris de dades(Java HasMap).
//		Un cop plens els dos arrays haurem de mostrar-los i preguntar que es vol per menjar, guardarem
//		la informació en una List fent servir un bucle while. 
//		Haurem de preguntar si es vol seguir demanant menjar. Podeu fer servir el sistema (1:Si / 0:No),
//		per tant haureu de crear un altre variable int per guardar la informació. 

		HashMap<String, Double> menu = new HashMap<String, Double>();
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		for (int i = 0; i < plats.length; i++) {

			System.out.println("introdueix el nom del plat " + (i + 1));
			plats[i] = scan.next();
			while (preus[i] == 0) {
				System.out.println("introdueix el preu del plat " + (i + 1));
				try {
					preus[i] = Double.parseDouble(scan2.nextLine());
					menu.put(plats[i], preus[i]);
				} catch (NullPointerException | NumberFormatException e) {
					System.out.println("format incorrecte");
				}
			}

		}

		boolean haAcabat = false;
		ArrayList<String> comanda = new ArrayList<String>();
		int index = 1;
		for (String i : menu.keySet()) {
			System.out.println(index + ". " + i + "     " + menu.get(i) + "€");
			index++;
		}
		while (haAcabat == false) {

			System.out.println("Què desitja menjar?");
			String opcio = scan.next();
			comanda.add(opcio);
			System.out.println("Vol demanar més menjar? (Si/No)");
			String opcio2 = scan.next();
			if (opcio2.equals("No")) {
				haAcabat = true;
			}
		}

//		FASE 3
//		Un cop hem acabat de demanar el menjar, haurem de comparar la llista amb l’array que hem fet
//		al principi. En el cas que la informació que hem introduït a la List coincideixi amb la del array,
//		haurem de sumar el preu del producte demanat; en el cas contrari haurem de mostrar un missatge que
//		digui que el producte que hem demanat no existeix. 

		double preuCompte = 0;
		boolean coincideix = true;
		for (int i = 0; i < comanda.size(); i++) {
			for (int j = 0; j < plats.length; j++) {
				if (comanda.get(i).equals(plats[j])) {
					preuCompte += menu.get(plats[j]);
					break;
				} else if (j == 2 && comanda.get(i) != plats[j]) {
					System.out.println("el plat " + comanda.get(i) + " no existeix.");
					coincideix = false;
				}
			}
		}
		if (coincideix == true) {
			System.out.println("el preu total del compte és de " + preuCompte + "€");
		}

		int bitllet5 = 5;
		int bitllet10 = 10;
		int bitllet20 = 20;
		int bitllet50 = 50;
		int bitllet100 = 100;
		int bitllet200 = 200;
		int bitllet500 = 500;

		int[] bitllets = { bitllet500, bitllet200, bitllet100, bitllet50, bitllet20, bitllet10, bitllet5 };

		HashMap<Integer, Integer> quantitatBitllets = new HashMap<Integer, Integer>();

		for (int i = 0; i < bitllets.length; i++) {
			quantitatBitllets.put(bitllets[i], 0);
			if (bitllets[i] <= preuCompte) {
				int numBitllets = (int) (preuCompte / bitllets[i]);
				quantitatBitllets.put(bitllets[i], numBitllets);
				preuCompte -= numBitllets * bitllets[i];

			}
		}
		if (preuCompte != 0) {
			quantitatBitllets.put(5, quantitatBitllets.get(5) + 1);
		}
		for (int i = bitllets.length - 1; i > 0; i--) {
			if (quantitatBitllets.get(bitllets[i]) == 2 && bitllets[i - 1] == bitllets[i] * 2) {
				quantitatBitllets.put(bitllets[i], 0);
				quantitatBitllets.put(bitllets[i - 1], quantitatBitllets.get(bitllets[i - 1]) + 1);
			}
		}
		System.out.println("Pots pagar amb:");
		for (int i = 0; i < bitllets.length; i++) {
			if (quantitatBitllets.get(bitllets[i]) != 0) {
				System.out.println(quantitatBitllets.get(bitllets[i]) + " de " + bitllets[i] + "€");
			}
		}
		scan.close();
		scan2.close();
	}

}
