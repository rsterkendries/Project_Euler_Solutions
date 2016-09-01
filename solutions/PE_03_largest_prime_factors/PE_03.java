package largest_prime_factors;

import java.util.ArrayList;
import java.util.List;

public class PE_03 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();       
		long bignumber = 600851475143L;
		System.out.println("largest prime number of " + bignumber + " is " + getLargestPrime(bignumber));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static List<Integer> generatePrimesUnderN(int N) {
		List<Integer> primes = new ArrayList<Integer>();		
		primes.add(1);
		primes.add(2);
		primes.add(3);		
		if(N > 5) {			
			for(int i = 5; i < N; i++) {
				if(isPrime(i))
					primes.add(i);
			}
		}		
		return primes;
	}
	
	private static boolean isPrime(int number) {
		boolean isPrime = true;
		int index = 2;
		while(isPrime == true && index < (number / 2) + 1) {
			if (((((double)number/index)%1)==0)) {
				isPrime = false;
			}
			index += 2;
		}
		
		return isPrime;
	}
	
	public static int getLargestPrime(long number) {
		int largestPrime = 0;
		
		List<Integer> primes = generatePrimesUnderN(10000);
		
		for(Integer i : primes) {
			
			if(((((double)number/i)%1)==0)) {
				largestPrime = i;
			}
		}
		
		return largestPrime;
	}
}
