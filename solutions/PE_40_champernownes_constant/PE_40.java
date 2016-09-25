package champernownes_constant;

public class PE_40 {
	
	public static final int LIMIT = 200000;

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
	
		StringBuilder champernownes_constant = new StringBuilder();
		
		for (int i = 1; i <= LIMIT; i++) 			
			champernownes_constant.append(i);
		
		int d_1 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(0)));
		int d_10 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(9)));
		int d_100 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(99)));
		int d_1000 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(999)));
		int d_10000 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(9999)));
		int d_100000 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(99999)));
		int d_1000000 = Integer.parseInt(String.valueOf(champernownes_constant.charAt(999999)));
		
		int value = d_1 * d_10 * d_100 * d_1000 * d_10000 * d_100000 * d_1000000;
		
		System.out.println("Expression value is :" + value);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}

}
