package digit_factorials;

public class PE_34 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sumOfFactorialEqualities = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						for (int m = 0; m < 10; m++) {
								if (PE_34.checkEquality(i,j,k,l,m)) {
									sumOfFactorialEqualities += PE_34.computeNumber(i,j,k,l,m);
							}
						}
					}
				}
			}
		}
		System.out.printf("sum : %5d" + System.lineSeparator(), sumOfFactorialEqualities - 3); /* withdraw (1+2) because of factorial() design */
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	public static int computeNumber(int... numbers) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			sb.append(String.valueOf(numbers[i]));
		}
		
		return Integer.parseInt(sb.toString());
	}
	
	public static boolean checkEquality(int... numbers) {
		String numberStr = String.valueOf(PE_34.computeNumber(numbers));
		int sumfactorials = 0;
		for (int i = 0; i < numberStr.length(); i++) {
			sumfactorials += PE_34.factorial(Integer.parseInt(numberStr.substring(i, i+1)));
		}
		return (PE_34.computeNumber(numbers) == sumfactorials);
	}
}
