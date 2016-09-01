package largest_palindrome_product;

public class PE_04 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int product = 1;
		String stringproduct = null;
		int largestpalindrome = 0;
		
		for(int leftnum = 100; leftnum < 1000; leftnum++) {
			
			for(int rightnum = 100; rightnum < 1000; rightnum++) {
				
				product = leftnum * rightnum;
				stringproduct = String.format("%d", product);
				if(isPalindrome(stringproduct)) {
					if(product > largestpalindrome) {
						largestpalindrome = product;
					}
				}
			}
		}
		
		System.out.println(largestpalindrome);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static boolean isPalindrome(String product) {
		boolean isPalindrome = false;
		
		if(product != null && !product.isEmpty()) {
			
			if(product.length() % 2 == 0) {
				//even
				isPalindrome = true;
				int halflength = product.length()/2;
				for(int i = 0; i < halflength; i++) {
					isPalindrome = isPalindrome && (product.charAt(halflength + i) == product.charAt(halflength - 1 - i));
				}
			}
			else {
				//odd
				isPalindrome = true;
				int middleposition = product.length()/2;
				for(int i = 1; i <= middleposition; i++) {
					isPalindrome = isPalindrome && (product.charAt(middleposition + i) == product.charAt(middleposition - i));
				}
			}
		}
		
		return isPalindrome;
	}
}
