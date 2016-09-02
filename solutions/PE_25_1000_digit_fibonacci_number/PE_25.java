package _1000_digit_fibonacci_number;

import java.math.BigInteger;

public class PE_25 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		BigInteger fib1 = new BigInteger("1");
		BigInteger fib2 = new BigInteger("2");
		long max = 1000L;
		long index = 3L;
		do {
			fib2 = fib2.add(fib1);
			fib1 = fib2.subtract(fib1);
			index++;
			
			if (fib2.toString().length() == max)
				System.out.printf("index : %5d number : %s" + System.lineSeparator(),index,fib2.toString());
		} while(fib2.toString().length() < max);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
