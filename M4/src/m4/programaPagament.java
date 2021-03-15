package m4;

import java.util.HashMap;

public class programaPagament {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bitllet5 = 5;
		int bitllet10 = 10;
		int bitllet20 = 20;
		int bitllet50 = 50;
		int bitllet100 = 100;
		int bitllet200 = 200;
		int bitllet500 = 500;

		double preuCompte = 467;
		
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
			quantitatBitllets.put(5, quantitatBitllets.get(5)+1);	
		}
		for (int i = bitllets.length -1 ; i > 0 ; i--) {
			if (quantitatBitllets.get(bitllets[i]) == 2 && bitllets[i-1] == bitllets[i]*2) {
				quantitatBitllets.put(bitllets[i], 0);
				quantitatBitllets.put(bitllets[i-1], quantitatBitllets.get(bitllets[i-1])+1);
			}
		}
		System.out.println("Pots pagar amb:");
		for (int i = 0; i < bitllets.length; i++) {
			if (quantitatBitllets.get(bitllets[i]) != 0){
				System.out.println(quantitatBitllets.get(bitllets[i]) + " de "+ bitllets[i] + "€");
			}
		}
	}

}
