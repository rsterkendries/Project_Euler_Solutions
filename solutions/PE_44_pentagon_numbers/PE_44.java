package pentagon_numbers;

public class PE_44 {

	public static final int LIMIT = 10000;
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int [] pentagonal = new int [LIMIT];
		int minAbsValue = Integer.MAX_VALUE;
		
		for (int i = 1; i < LIMIT; i++)
			pentagonal [i] = PE_44.computePentagonalNumber(i);
		
		int sum = 0;
		int diff = 0;
		int absdiff = 0;
		
		for (int i = 1; i < LIMIT; i++) {
			for (int j = 1; j < LIMIT; j++) {
				
				sum = pentagonal[i] + pentagonal[j];
				diff = pentagonal[i] - pentagonal[j];
				
				if (PE_44.isPentagonalNumber(sum) && PE_44.isPentagonalNumber(diff)) {
					
					absdiff = Math.abs(pentagonal[i] - pentagonal[j]);
					if (absdiff < minAbsValue)
						minAbsValue = absdiff;
				}
			}
		}
		
		System.out.println("minimized value of D is : " + minAbsValue);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public static boolean isPentagonalNumber(int P) {
		return ((1 + Math.sqrt(1 + 24 * P)) % 6) == 0;
	}
	
	public static int computePentagonalNumber(int n) {
		return n * (3 * n - 1)/2;
	}

}
