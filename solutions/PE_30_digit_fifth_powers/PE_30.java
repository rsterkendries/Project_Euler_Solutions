package digit_fifth_powers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PE_30 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<Integer> powers = new ArrayList<Integer>();

		for (int i = 2; i < 1000000; i++) {
			BigInteger sum = BigInteger.ZERO;
			Integer itg_i = new Integer(i);
			String numStr = itg_i.toString();
			for (int j = 1; j <= numStr.length(); j++) {
				Integer digit = Integer.parseInt(numStr.substring(j-1, j));
				sum = sum.add(new BigInteger(digit.toString()).pow(5));
			}
			if (sum.equals(new BigInteger(itg_i.toString()))) {
				powers.add(itg_i);
			}
		}
		Integer totalSum = 0;
		for(Integer itg : powers) {
			totalSum += itg;
		}
		System.out.println("total : " + totalSum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
