package circular_primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PE_35 {

	private boolean [] isPrime;
	private final static int BOUND = 1000000;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		PE_35 tc = new PE_35();
		List<Integer> primes = tc.computePrimesUnderN(BOUND);
		int count = 0;
		for (int i : primes) {
			if (tc.isCircularPrime(i)) {
				count++;
			}
		}
		System.out.println("number of circular primes below " + BOUND + " is : " + count);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public boolean isCircularPrime(int number) {
		int digits = String.valueOf(number).length();
		boolean isCircularPrime = isPrime(number);
		while(isCircularPrime && digits > 1) {
			number = PE_35.ComputeCircularNumber(number);
			isCircularPrime = isCircularPrime && isPrime(number);
			digits--;
		}
		return isCircularPrime;
	}
	
	public static int ComputeCircularNumber(int number) {
		String numberStr = String.valueOf(number);
		String circulated_numberStr = PE_35.circulateString(numberStr);
		return Integer.parseInt(circulated_numberStr);
	}
	
	public boolean isPrime(int number) {
		return this.isPrime[number];
	}
	
	private static String circulateString(String str) {
		char [] charArray = str.toCharArray();
		int length = str.length();
		char tmp = charArray[length - 1];
		for (int i = length - 1; i > 0; i--) {
			charArray[i] = charArray[i-1];
		}
		charArray[0] = tmp;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}
	
	public List<Integer> computePrimesUnderN(int N) {
		/* fillSieveArray */
		this.isPrime = new boolean [N + 1];
		Arrays.fill(isPrime, true);
		this.isPrime[0] = false;
		this.isPrime[1] = false;
		int limit = (int)Math.sqrt(N);
		
		for (int i = 2; i <= limit; i++) {
			if (this.isPrime[i]) {
				
				for (int j = i*i; j <= N; j+=i) {
					this.isPrime[j] = false;
				}
			}
		}
		/* compute primes */
		int size = this.isPrime.length;
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (this.isPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}
