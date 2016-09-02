package digit_cancelling_fractions;

public class PE_33 {

	private static final int CANNOTBENAIVELYSIMPLIFIED = 0;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int numerator = 1;
		int denominator = 1;
		for (int i = 10; i <= 98; i++) {
			for (int j = i; j <= 99; j++) {
				if (i != j && PE_33.canBeNaivelySimplified(i, j) != 0) {
					int digit = PE_33.canBeNaivelySimplified(i, j);
					int numSimplified = PE_33.NaivelySimplify(i, digit);
					int denomSimplified = PE_33.NaivelySimplify(j, digit);
					
					if (denomSimplified != numSimplified && denomSimplified != 0 && numSimplified != 0) {
						//System.out.println(i + "/" + j + "\t" + numSimplified + "/" + denomSimplified);
						if (i * denomSimplified == j * numSimplified) {
							System.out.println(i + "/" + j + " == " + numSimplified + "/" + denomSimplified);
							numerator *= numSimplified;
							denominator *= denomSimplified;
						}
					}
				}
			}
		}
		System.out.println("lowest common terms for product's denominator : " + denominator/numerator);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	private static int canBeNaivelySimplified(int num, int denom) {
		int canBeNaivelySimplified = CANNOTBENAIVELYSIMPLIFIED;
		int index = 1;
		String numStr = null;
		String denomStr = null;
		while(index <= 9) {
			numStr = String.valueOf(num);
			denomStr = String.valueOf(denom);
			if(numStr.contains(String.valueOf(index)) && denomStr.contains(String.valueOf(index))) {
				return index;
			}
			index++;
		}
		
		return canBeNaivelySimplified;
	}
	
	private static int NaivelySimplify(int value, int digit) {
		String valueStr = String.valueOf(value);
		if (valueStr.startsWith(String.valueOf(digit)))
			return Integer.parseInt(valueStr.substring(1));
		else
			return Integer.parseInt(valueStr.substring(0,1));
	}
}
