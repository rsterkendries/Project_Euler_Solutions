package integer_right_triangles;

public class PE_39 {

	public static void main(String[] args) {
		
		PE_39 pe_39 = new PE_39();
		PE_39.arithmeticmethod(pe_39);
		PE_39.bruteforce(pe_39);
	}
	
	public static void arithmeticmethod(PE_39 pe_39) {
		
		long startTime = System.currentTimeMillis();
		
		int numberOfCombinations = 0;
		int maxNumberOfCombinations = 0;
		int maxPerimeter = 0;
		
		for (int perimeter = 3; perimeter <= 1000; perimeter++) {
			
			numberOfCombinations = pe_39.numberOfCombinationsArithmetic(perimeter);
			
			if (numberOfCombinations > maxNumberOfCombinations) {
				
				maxNumberOfCombinations = numberOfCombinations;
				maxPerimeter = perimeter;
			}
		}
		
		System.out.println("Arithmetic : maximum number of combinations with perimeter p = " + maxPerimeter);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public static void bruteforce(PE_39 pe_39) {
		
		long startTime = System.currentTimeMillis();
		
		int numberOfCombinations = 0;
		int maxNumberOfCombinations = 0;
		int maxPerimeter = 0;
		
		for (int perimeter = 3; perimeter <= 1000; perimeter++) {
			
			numberOfCombinations = pe_39.numberOfCombinationsBruteForce(perimeter);
			
			if (numberOfCombinations > maxNumberOfCombinations) {
				
				maxNumberOfCombinations = numberOfCombinations;
				maxPerimeter = perimeter;
			}
		}
		
		System.out.println("Bruteforce : maximum number of combinations with perimeter p = " + maxPerimeter);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public int numberOfCombinationsBruteForce(int perimeter) {
		
		int numberOfCombinations = 0;
		
		for (int a = 1; a <= perimeter; a++) {
			for (int b = perimeter - a; b > 0; b--) {
				for (int c = perimeter - a - b; c > b; c--) {

					if (PE_39.checkIfRectangleTriangle(a, b, c, perimeter)) {
						numberOfCombinations++;
					}
				}
			}
		}
		
		return numberOfCombinations;
	}
	
	public int numberOfCombinationsArithmetic(int perimeter) {
		
		int numberOfCombinations = 0;
		
		for (int a = 1; a < perimeter/2; a++) {
			if (PE_39.checkArithmetic(a, perimeter)) {
				numberOfCombinations++;
			}
		}
		
		return numberOfCombinations;
	}
	
	private static boolean checkArithmetic(int a, int perimeter) {
		//because arithmetic expression of b only needs to be integer (a,perimeter already are integers)
		return (perimeter*(perimeter-2*a) % (2*(perimeter-a)) == 0);
	}
	
	private static boolean checkIfRectangleTriangle(int a, int b, int c, int perimeter) {
		if (a + b + c != perimeter)
			return false;
		
		return (a*a == b*b + c*c);
	}

}
