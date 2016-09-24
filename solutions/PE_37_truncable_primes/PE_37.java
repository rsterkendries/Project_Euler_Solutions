package truncatable_primes;

import java.util.Arrays;

public class PE_37 {
	
	private static int max = Integer.MAX_VALUE/1000;

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		int sum = 0;
		PE_37 pe_37 = new PE_37();
		boolean [] primes = pe_37.generatePrimes();
		
		for (int i = 10; i < max; i++) {
			if (pe_37.isTruncatablePrimeRight(i, primes)
					&& pe_37.isTruncatablePrimeLeft(i, primes)) {
				
				sum += i;
			}
		}
		
		System.out.println("Sum of eleven truncatable primes is : " + sum);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public boolean isTruncatablePrimeRight(int number, boolean [] prime) {

		if (!prime[number])
			return false;
				
		String numberStr = String.valueOf(number);
		int truncatedInteger = 0;
		while (numberStr.length() > 1) {
			truncatedInteger = Integer.parseInt(numberStr.substring(1));
			if (prime[truncatedInteger])
				numberStr = String.valueOf(truncatedInteger);
			else
				return false;
		}
		
		return true;
	}
	
	public boolean isTruncatablePrimeLeft(int number, boolean [] prime) {
		
		if (!prime[number])
			return false;
		
		String numberStr = String.valueOf(number);
		int truncatedInteger = 0;
		while (numberStr.length() > 1) {
			truncatedInteger = Integer.parseInt(numberStr.substring(0,numberStr.length() - 1));
			if (prime[truncatedInteger])
				numberStr = String.valueOf(truncatedInteger);
			else
				return false;
		}
		
		return true;
	}
	
	public boolean [] generatePrimes() {
		
		boolean [] prime = new boolean [max];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int limit = (int)Math.sqrt(max);
		
		for (int i = 0; i < limit; i++) {
			if (prime[i]) {
				for (int k = i*i; k < max; k+=i) {
					prime [k] = false;
				}
			}
		}
		
		return prime;
	}

}
