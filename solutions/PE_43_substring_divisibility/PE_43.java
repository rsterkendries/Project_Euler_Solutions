package substring_divisibility;

import java.math.BigInteger;

public class PE_43 {
	
	BigInteger sum;

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		PE_43 pe_43 = new PE_43();
		
		String numberStr = "0123456789";
		pe_43.sum = new BigInteger("0");
		pe_43.permutation(numberStr);
		
		System.out.println("Sum of all 0-9 pangdigitals with special property is: " + pe_43.sum.toString());
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	private boolean hasProperty(String numberStr) {
		boolean d234, d345, d456, d567, d678, d789, d8910;

		d234 = Integer.parseInt(numberStr.substring(1, 4)) % 2 == 0;
		d345 = Integer.parseInt(numberStr.substring(2, 5)) % 3 == 0;
		d456 = Integer.parseInt(numberStr.substring(3, 6)) % 5 == 0;
		d567 = Integer.parseInt(numberStr.substring(4, 7)) % 7 == 0;
		d678 = Integer.parseInt(numberStr.substring(5, 8)) % 11 == 0;
		d789 = Integer.parseInt(numberStr.substring(6, 9)) % 13 == 0;
		d8910 = Integer.parseInt(numberStr.substring(7, 10)) % 17 == 0;

		return d234 && d345 && d456 && d567 && d678 && d789 && d8910;
	}

	public void permutation(String str) {
	    permutation("", str); 
	}

	private void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	if (hasProperty(prefix)) {
	    		this.sum = this.sum.add(new BigInteger(prefix));
	    	}
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
