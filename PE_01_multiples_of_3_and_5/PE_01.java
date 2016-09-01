package multiples_of_3_and_5;

public class PE_01 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sum = 0;		
		for(int i = 1; i < 1000; i++) {			
			if(isMultipleOfq(i,3) || isMultipleOfq(i,5)) {
				sum += i;
			}
		}
		System.out.println("SUM of 3-or-5 multiples below 1000 : " + sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static boolean isMultipleOfq(int number, int q) {
		boolean isMultipleOfq = false;		
		if(number%q == 0) {			
			isMultipleOfq = true;
		}		
		return isMultipleOfq;
	}

}
