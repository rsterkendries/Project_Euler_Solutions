package pandigital_products;

import java.util.HashSet;
import java.util.Set;

public class PE_32 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sumProducts = 0;
		Set<Integer> products = new HashSet<Integer>();
		for (int i = 1; i < 10000; i++) {
			for (int j = i; j < 10000; j++) {
				Integer multiplicant = i;
				Integer multiplier = j;
				Integer product = i * j;
				String concatnum = String.valueOf(multiplicant)
						+ String.valueOf(multiplier)
						+ String.valueOf(product);
				if (concatnum.length() == 9 && PE_32.isPandigital(concatnum)) {
					products.add(product);
				}
			}
		}
		for (Integer prod : products) {
			sumProducts += prod;
		}
		System.out.println(sumProducts);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	private static boolean isPandigital(String concatnumber) {
		boolean isPandigital = true;
		
		for (int i = 1; i < 10; i++) {
			isPandigital = isPandigital && concatnumber.contains(String.valueOf(i));
		}
		
		return isPandigital;
	}
}
