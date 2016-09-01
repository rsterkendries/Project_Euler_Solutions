package lattice_paths;

import java.math.BigInteger;

public class PE_15 {
	
	private BigInteger one = new BigInteger("1");

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(new PE_15().binomialCoefficient(40,20));
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
	
	public BigInteger binomialCoefficient(int n, int k) {
		
		BigInteger nBig = new BigInteger(Integer.toString(n));
		BigInteger kBig = new BigInteger(Integer.toString(k));
		
		return factorial(nBig).divide((factorial(kBig).multiply(factorial(nBig.subtract(kBig)))));
	}

}
