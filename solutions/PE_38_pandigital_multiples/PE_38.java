package pandigital_multiples;

public class PE_38 {
	
	private static final int LIMIT = 10000;

	public static void main (String [] args) {
		
		long startTime = System.currentTimeMillis();
		
		PE_38 pe_38 = new PE_38();
		int concatenation = 0;
		int max_pandigital = 0;
		
		for (int i = 1; i < LIMIT; i++) {
			
			concatenation = pe_38.computeConcatenation(i);

			if(concatenation != -1)
				if (pe_38.isPandigital(concatenation)) 
					if (concatenation > max_pandigital) 
						max_pandigital = concatenation;
		}
		
		System.out.println("Largest 9-pandigital concatenated is : " + max_pandigital);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	private int computeConcatenation(int number) {
		
		final int multiplicant = number;
		int multiplier = 2;
		
		String numberStr = String.valueOf(number);
		
		while(numberStr.length() < 9) {
			
			number = multiplicant * multiplier;
			numberStr = numberStr + String.valueOf(number);
			multiplier++;
		}

		if (numberStr.length() == 9)
			return Integer.parseInt(numberStr);
		else
			return -1;
	}
	
	private boolean isPandigital(int n) {
		
		int digits = 0;
		int shift = 0;
		int count = 0;
		int previousStep = 0;
		
		while (n > 0) {
			previousStep = digits;
			shift = 1 << (n % 10) - 1;
			digits = digits | shift;
			
			if (previousStep == digits) {
				return false;
			}
			
			count++;
			n /= 10;
		}
		
		return digits == (1 << count) - 1;
	}
}
