package _10001st_prime;

import java.util.ArrayList;
import java.util.List;

public class PE_07 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<Integer> primes = new ArrayList<Integer>();
		int index = 5;
		
		primes.add(1);
		primes.add(2);
		primes.add(3);
		
		while(primes.size() <= 10001) {
			
			if(isPrime(index)) {
				primes.add(index);
			}
			index+=2;
		}
		System.out.println("10001st prime is " + (index - 1));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	private static boolean isPrime(int number) {
		boolean isPrime = true;
		int index = 5;
		while(isPrime == true && index < (number / 2) + 1) {
			if (((((double)number/index)%1)==0)) {
				isPrime = false;
			}
			index+=2;
		}
		
		return isPrime;
	}
}
