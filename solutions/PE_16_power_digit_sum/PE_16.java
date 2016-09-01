package power_digit_sum;

import java.math.BigInteger;

public class PE_16 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		BigInteger bigInt = new BigInteger("2").pow(1000);
		String strValue = bigInt.toString();
		int length = strValue.length();
		
		int sum = 0;
		
		for(int index = 0; index < length; index++) {
			
			sum += Integer.parseInt(strValue.substring(index, index + 1));
		}
		
		System.out.println(sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}

}
