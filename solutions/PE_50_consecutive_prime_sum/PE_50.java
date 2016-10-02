package consecutive_prime_sum;

import java.util.Arrays;

public class PE_50 {

	public final static int LIMIT = 1_000_000;

	public static void main(String[] args) {

		boolean[] isPrime = PE_50.generatePrimesBelow(LIMIT);
		long[] primes = PE_50.convertSieveArray(isPrime);

		PE_50 pe_50 = new PE_50();
		pe_50.cumulativeSumArraySearch(primes);
		System.out.println();
		pe_50.bruteforce(primes);
	}

	public void cumulativeSumArraySearch(long[] primes) {
		System.out.println("*** Cumulative Sum Array Search ***");
		/* with this method we no longer do the summations all the time */
		long startTime = System.currentTimeMillis();

		long[] cumulativePrimes = PE_50.CumulativeSumArray(primes);

		int length = primes.length;

		long maxPrime = 0;
		int maxTerms = 0;

		int terms = 0;

		for (int i = length - 1; i > 0; i--) {
			if (Arrays.binarySearch(primes, cumulativePrimes[i]) >= 0) {
				terms = i + 1;
				if (terms > maxTerms) {
					maxTerms = terms;
					maxPrime = cumulativePrimes[i];
				}
			}
			for (int j = i - 2; j >= 0; j--) {
				if (cumulativePrimes[i] - cumulativePrimes[j] > LIMIT)
					break;
				
				if (Arrays.binarySearch(primes, cumulativePrimes[i] - cumulativePrimes[j]) >= 0) {
					terms = i - j;
					if (terms > maxTerms) {
						maxTerms = terms;
						maxPrime = cumulativePrimes[i] - cumulativePrimes[j];
					}
				}
			}
		}
		System.out.println(
				"Max prime under " + LIMIT + " that can be written as the sum of the most consecutive primes is: "
						+ maxPrime + " (" + maxTerms + " terms)");
		System.out.println("Cumulative Sum Search Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	public void bruteforce(long[] primes) {

		System.out.println("*** Bruteforce ***");
		/*
		 * this is not a good method as we do a lot of identical summations a
		 * lot of times
		 */
		long startTime = System.currentTimeMillis();

		int length = primes.length;

		long maxPrime = 0;
		int maxTerms = 0;

		for (int index = 2; index < length; index++) {

			int start = 0;
			int j;
			int sum;
			int terms;
			while (start < index) {
				sum = 0;
				terms = 0;
				j = start;
				while (sum < primes[index]) {
					sum += primes[j++];
					terms++;
				}
				if (sum == primes[index]) {
					if (terms > maxTerms) {
						maxTerms = terms;
						maxPrime = primes[index];
					}
					start = index;
				}
				start++;
			}
		}

		System.out.println(
				"Max prime under " + LIMIT + " that can be written as the sum of the most consecutive primes is: "
						+ maxPrime + " (" + maxTerms + " terms)");
		System.out.println("Bruteforce Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	public static long[] convertSieveArray(boolean[] prime) {
		int nmbPrimes = 0;

		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				nmbPrimes++;

		int primeArrayindex = 0;
		long[] primesInt = new long[nmbPrimes];

		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				primesInt[primeArrayindex++] = i;

		return primesInt;
	}

	public static boolean[] generatePrimesBelow(int N) {

		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int limit = (int) Math.sqrt(N);

		for (int i = 2; i <= limit; i++) {
			if (prime[i]) {
				for (int k = i * i; k <= N; k += i) {
					prime[k] = false;
				}
			}
		}
		return prime;
	}

	public static long[] CumulativeSumArray(long[] array) {
		int length = array.length;
		long[] cumulativeSums = new long[length];

		cumulativeSums[0] = array[0];

		for (int i = 1; i < length; i++)
			cumulativeSums[i] += cumulativeSums[i - 1] + array[i];

		return cumulativeSums;
	}

}
