package quadratic_primes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PE_27 {

	public static void main(String [] args) {
		long startTime = System.currentTimeMillis();
		Set<Integer> primes = generateSievePrimes(1000000);
		int aMax = 0;
		int bMax = 0;
		int lengthMax = 0;
		int values = 1000;
		
		for (int a = -values+1; a < values; a++) {
			for (int b = -values+1; b < values; b++) {
				
				int n = 0;
				int length = 0;
				boolean isPrime = isPrime(quadraticFormula(a, b, n), primes);
				while(isPrime) {
					length++;
					n++;
					isPrime = isPrime(quadraticFormula(a, b, n), primes);
				}
				if (length > lengthMax) {
					lengthMax = length;
					aMax = a;
					bMax = b;
				}
			}
		}
		
		System.out.printf("a = %d, b = %d, consecutive primes : %d" + System.lineSeparator(),aMax,bMax,lengthMax);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static int quadraticFormula(int a, int b, int n) {
		if (Math.abs(a) < 1000 && Math.abs(b) < 1000)
			return n * n + a * n + b;
		else
			return -1;
	}
	
	public static boolean isPrime(int n, Set<Integer> primes) {
		return primes.contains(new Integer(n));
	}
	
	public static Set<Integer> generateSievePrimes(int n) {
		boolean [] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int sqroot = (int)Math.sqrt(n);
		
		for (int i = 0; i < sqroot; i++) {
			if (prime[i]) {
				for (int k = i*i; k < n; k+=i) {
					prime[k] = false;
				}
			}
		}
		Set<Integer> primes = new HashSet<Integer>();
		for (int i = 0; i < n + 1; i++) {
			if (prime[i]) {
				primes.add(new Integer(i));
			}
		}
		return primes;
	}
}
