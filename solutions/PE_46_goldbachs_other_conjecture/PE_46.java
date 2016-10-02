package goldbachs_other_conjecture;

import java.util.Arrays;

public class PE_46 {

	public static final int LIMIT = 10000;
	private final boolean[] isPrime;

	public PE_46() {
		isPrime = PE_46.generatePrimesBelow(LIMIT);
	}

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();

		PE_46 pe_46 = new PE_46();
		
		for (int i = 2; i < LIMIT; i++) {
			if (i % 2 != 0 && !pe_46.isPrime[i])
				if (!pe_46.hasGoldbachDecomposition(i))
					System.out.println(i);
		}
		
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	public boolean hasGoldbachDecomposition(int number) {
		
		int index = 1;
		int ithPrime = getIthPrimeNumberBelow(number, index);
		double square = 0;
		
		while (ithPrime >= 0) {
			if ((number - ithPrime) % 2 == 0) {
				square = Math.sqrt((number - ithPrime) / 2);
				
				if (Math.floor(square) == square) {
					// then square is an integer
					return true;
				}
			}
			
			ithPrime = getIthPrimeNumberBelow(number, ++index);
		}
		return false;
	}

	public int getIthPrimeNumberBelow(int number, int ith) {
		int index = number;
		int count = 0;
		try {
			while (count < ith) {
				index--;
				if (isPrime[index])
					count++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}

		return index;
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

}
