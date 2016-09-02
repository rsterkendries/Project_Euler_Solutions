package factorial_digit_sum;

import java.math.BigInteger;

public class PE_20 {

	private BigInteger one = new BigInteger("1");

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		PE_20 tc = new PE_20();
		BigInteger factorial = tc.factorial(new BigInteger("100"));
		
		int sum = 0;
		String strValue = factorial.toString();
		for(int index = 0; index < strValue.length(); index++) {
			sum += Integer.parseInt(strValue.substring(index, index + 1));
		}
		System.out.println(sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public BigInteger factorial(BigInteger number) {	
		
		if (number.equals(one)) {
			return this.one;
		}
		else {
			return number.multiply(factorial(number.subtract(one)));
		}
	}
}
