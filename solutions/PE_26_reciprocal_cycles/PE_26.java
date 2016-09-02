package reciprocal_cycles;

import java.util.HashSet;
import java.util.Set;

public class PE_26 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int maxperiod = 0;
		int period;
		int maxdivisorvalue = 0;
		for (int divisor = 2; divisor <= 1000; divisor++) {
			
			period = getPeriodicityFromString(divisor);
			if (period > maxperiod) {
				maxperiod = period;
				maxdivisorvalue = divisor;
			}
		}
		System.out.println(maxdivisorvalue);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static int getPeriodicityFromString(int divisor) {
		
		int periodicity = -1;
		Set<Integer> remainderList = new HashSet<Integer>();
		
		if (divisor > 0) {		
			if (divisor % 2 != 0 && divisor % 5 != 0) {
				
				int remainder = 1;
				boolean periodnotfound = true;
				while(periodnotfound) {
					periodicity++;
					remainder *= 10;
					remainder %= divisor;
					periodnotfound = remainderList.add(remainder);
				}
				return periodicity;
			}
			else {
				return 0;
			}
		}
		return periodicity;
	}
}
