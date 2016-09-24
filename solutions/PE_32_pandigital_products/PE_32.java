package pandigital_products;

import java.util.HashSet;
import java.util.Set;

public class PE_32 {
	
	public static void method_bitshift() {
		long startTime = System.currentTimeMillis();
		int sumProducts = 0;
		Set<Integer> products = new HashSet<Integer>();
		for (int i = 1; i < 10000; i++) {
			for (int j = i; j < 10000; j++) {
				String multiplicant = String.valueOf(i);
				String multiplier = String.valueOf(j);
				String product = String.valueOf(i * j);
				String concatnum = multiplicant + multiplier + product;
				if (concatnum.length() == 9 && PE_32.isPandigital_withbitshifts(Integer.parseInt(concatnum))) {
					products.add(Integer.parseInt(product));
				}
			}
		}
		for (Integer prod : products) {
			sumProducts += prod;
		}
		System.out.println("Bitshift method : " + sumProducts);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static void method_string() {
		long startTime = System.currentTimeMillis();
		int sumProducts = 0;
		Set<Integer> products = new HashSet<Integer>();
		for (int i = 1; i < 10000; i++) {
			for (int j = i; j < 10000; j++) {
				String multiplicant = String.valueOf(i);
				String multiplier = String.valueOf(j);
				String product = String.valueOf(i * j);
				String concatnum = multiplicant + multiplier + product;
				if (concatnum.length() == 9 && PE_32.isPandigital(concatnum)) {
					products.add(Integer.parseInt(product));
				}
			}
		}
		for (Integer prod : products) {
			sumProducts += prod;
		}
		System.out.println("String method : " + sumProducts);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}

	public static void main(String[] args) {
		PE_32.method_bitshift();
		PE_32.method_string();
	}
	
	private static boolean isPandigital(String concatnumber) {
		boolean isPandigital = true;
		
		for (int i = 1; i < 10; i++) {
			isPandigital = isPandigital && concatnumber.contains(String.valueOf(i));
		}
		
		return isPandigital;
	}
	
	private static boolean isPandigital_withbitshifts(int n) {
		
		int digits = 0;
		int shift = 0;
		int count = 0;
		int previousStep = 0;
		
		while (n > 0) {
			previousStep = digits;
			shift = 1 << (n % 10) - 1;
			digits = digits | shift;
			
			if (previousStep == digits) {
				return false;
			}
			
			count++;
			n /= 10;
		}
		
		return digits == (1 << count) - 1;
	}
}
