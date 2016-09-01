package summation_of_primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PE_10 {

	public static void main(String [] args) {
		long startTime = System.currentTimeMillis();
		int N = 2_000_000;
		List<Integer> primes = PE_10.generateSievePrimesBelowN(N);
		long sum = 0L;
		
		for (Integer prime : primes) {
			sum += prime;
		}
		
		System.out.println("sum of all primes below " + N + " is " + sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static List<Integer> generateSievePrimesBelowN(int N) {
		
		boolean [] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int limit = (int)Math.sqrt(N);
		
		for (int i = 2; i < limit; i++) {
			if (prime[i]) {
				for (int k = i*i; k <= N; k += i) {
					prime[k] = false;
				}
			}
		}
		
		List<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 0; i <= N; i++) {
			if (prime[i]) {
				primes.add(new Integer(i));
			}
		}
		
		return primes;
	}
}
