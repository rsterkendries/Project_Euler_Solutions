package pandigital_prime;

import java.util.Arrays;

public class PE_41 {
	
	private static int max = 987654321;

	public static void main(String[] args) {
		
		PE_41 pe_41 = new PE_41();
		boolean [] prime = pe_41.generatePrimes();
		
		long startTime = System.currentTimeMillis();
		
		boolean isPandigital = false;
		int index = max;
		while (!isPandigital) {
			if (prime[index]) {
				isPandigital = pe_41.isPandigital(index);
			}
			index--;
		}
		System.out.println("largest n-digit prime pandigital is : " + ++index);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public boolean [] generatePrimes() {
		
		long startTime = System.currentTimeMillis();
		
		boolean [] prime = new boolean [max + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int limit = (int)Math.sqrt(max);
		
		for (int i = 0; i < limit; i++) {
			if (prime[i]) {
				for (int k = i*i; k <= max; k+=i) {
					prime [k] = false;
				}
			}
		}
		System.out.println("Generating primes Time : " + (System.currentTimeMillis() - startTime) + " ms.");
		return prime;
	}
	
	private boolean isPandigital(int n) {
		
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
