package smallest_multiple;

public class PE_05 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("ppcm method : " + 2*2*2*2*3*3*5*7*11*13*17*19);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
		
		startTime = System.currentTimeMillis();
		int number = 1;		
		boolean isDivisible = false;
		
		while (!isDivisible) {			
			isDivisible = true;
			int index = 1;
			while (isDivisible && index <= 20) {
				isDivisible = isDivisible && (((double) number / index) % 1 == 0);
				index++;
			}
			
			if(isDivisible) {
				System.out.println("brute force method : " + number);
			}
			number++;
		}
		System.out.println("Time = " + (System.currentTimeMillis() - startTime)/1000 +" s");
	}
}
