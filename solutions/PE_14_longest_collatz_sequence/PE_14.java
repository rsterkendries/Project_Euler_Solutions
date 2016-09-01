package longest_collatz_sequence;

public class PE_14 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long maxLength = 0;
		int maxStartingIndex = 0;
		int number = 1000000;
		long result = 0;
		
		long [] lengths = new long[number]; // keep track of already calculated sequences
		
		for(int index = 1; index < number; index++) {
			
			result = PE_14.generateCollatzChain(index, lengths);
			if (result > maxLength) {
				maxLength = result;
				maxStartingIndex = index;
			}
		}
		
		System.out.printf("maxLength: %2d for number: %2d" + System.lineSeparator(), maxLength, maxStartingIndex);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static long generateCollatzChain(int number, long [] lengths) {
		
		long index = 0;
		long value = number;		
		if(number > 0) {
			
			while(value != 1) {				
				
				if (value % 2 == 0) {
					value /= 2;
					index++;
				}
				else {
					value = 3 * value + 1;
					index++;
				}
				
				if(value < number) {
					//check if sequence already calculated
					if(lengths[(int)value] != 0) {
						index += lengths[(int)value];
						value = 1;
					}
				}
			}
		}
		return index;
	}
}
