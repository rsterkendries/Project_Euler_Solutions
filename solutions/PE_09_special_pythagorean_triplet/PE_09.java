package special_pythagorean_triplet;

public class PE_09 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int limit = 500;
		
		for(int a = 1; a < limit; a++) {
			
			for(int b = 1; b < limit; b++) {
				
				for(int c = 1; c < limit; c++) {
					
					if((a + b + c == 1000) && (a*a + b*b == c*c)) {
						System.out.println("a = " + a + ", b = " + b + ", c = " + c);
						System.out.println("a * b * c = " + a * b * c);
					}
				}
			}
		}
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
