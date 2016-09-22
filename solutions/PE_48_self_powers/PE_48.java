package self_powers;

import java.math.BigInteger;

public class PE_48 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		BigInteger sum = new BigInteger("0");
		
		for (int i = 1; i <= 1000; i++) {
			
			BigInteger bigint_i = new BigInteger(String.valueOf(i));
			bigint_i = bigint_i.pow(i);
			sum = sum.add(bigint_i);
		}
		
		String sumStr = sum.toString();
		
		System.out.println("10 last digits of the sum are : " + sumStr.substring(sumStr.length()-10, sumStr.length()));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}

}
