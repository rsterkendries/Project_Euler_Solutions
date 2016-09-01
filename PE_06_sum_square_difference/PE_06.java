package sum_square_difference;

public class PE_06 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sum_squares = 0;
		int squared_sum = 0;
		
		int limit = 100;
		
		for(int i = 1; i <= limit; i++) {
			sum_squares += i*i;
			squared_sum += i;
		}
		
		System.out.println("1² + 2² + ... + " + limit + "² = " + sum_squares);
		System.out.println("(1 + 2 + ... + "+ limit + ")² = " + squared_sum * squared_sum);
		System.out.println("... and difference is " + (squared_sum * squared_sum - sum_squares));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
