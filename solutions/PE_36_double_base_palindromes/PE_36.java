package double_base_palindromes;

public class PE_36 {
	
	public final static int LIMIT = 1_000_000;

	public static void main (String [] args) {
		
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		
		for (int i = 1; i < LIMIT; i++) {
			
			if(PE_36.isPalindrome(Integer.toString(i, 2)) && PE_36.isPalindrome(Integer.toString(i, 10))) {
				sum += i;
			}
		}
		
		System.out.println("Sum of all double-base (2-10) palindromes under " + LIMIT + " is : " + sum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static boolean isPalindrome (String number) {

		int size = number.length();
		int index = 0;
		boolean isPalindrome = true;
		
		while(index < size/2 && isPalindrome) {
			
			isPalindrome = isPalindrome && (number.charAt(index) == number.charAt(size-index-1));
			index++;
		}
		
		return isPalindrome;
	}
}
