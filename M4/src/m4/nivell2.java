package m4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class nivell2 {
	
	public static void comptarBitllets(double preuCompte) {
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
	}
	/**
	 * afegeix un plat a la llista però llença una excepció si no el troba.
	 */
	public static void addDish(String opcio, ArrayList<String> comanda, String plats[]) throws Exception {
		for (int i = 0; i < plats.length; i++) {
			if (opcio.equals(plats[i])) {
				comanda.add(opcio);
				return;
			}
		}
		throw new Exception();
	}

	public static void checkAnswer(String opcio2) throws Exception {
		if (opcio2.equals("si") || opcio2.equals("no")) {
			return;
		} else {
			throw new Exception();
		}
	}

	public static void main(String[] args) {
//		Revisaràs l'exercici anterior modificant-lo per afegir noves excepcions més adients.
//		Modifica la revisió de la comanda, si un usuari introdueix un plat que no existeix, inmediatament
//		executa una excepció per avisar que el producte no existeix y no l’afageixis a la llista.  
//		Crea una Excepció per la pregunta Si/No al seguir demanant e implementala.  

		String plats[] = new String[3];
		double preus[] = new double[3];

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
			try {
				addDish(opcio, comanda, plats);
			} catch (Exception e) {
				System.out.println("El plat " + opcio + " no existeix");
			} finally {
				boolean respostaValida = false;
				while (respostaValida == false) {

					System.out.println("Vol demanar més menjar? (Si/No)");
					String opcio2 = scan.next().toLowerCase();
					try {
						checkAnswer(opcio2);
						respostaValida = true;
					} catch (Exception e) {
						System.out.println("la resposta no és vàlida");
					}
					if (opcio2.equals("no")) {
						haAcabat = true;
					}
				}
			}
		}
		double preuCompte = 0;
		for (int i = 0; i < comanda.size(); i++) {
			for (int j = 0; j < plats.length; j++) {
				if (comanda.get(i).equals(plats[j])) {
					preuCompte += menu.get(plats[j]);
					break;
				}
			}
		}

		System.out.println("el preu total del compte és de " + preuCompte + "€");
		comptarBitllets(preuCompte);
		scan.close();
		scan2.close();
	}

}
