package even_fibonacci_sequence;

public class PE_02 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int fib1 = 1;
		int fib2 = 2;
		int sum = fib2;
		int max = 4000000;
		
		do {
			fib2 = fib2 + fib1;
			fib1 = fib2 - fib1;
			if(fib2 % 2 == 0 && fib2 < max)
				sum += fib2;
		} while(fib2 < max);
		
		System.out.println("Sum of even-terms from fibonacci sequence (<" + max + ") : " + sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
