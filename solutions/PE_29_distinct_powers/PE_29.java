package distinct_powers;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class PE_29 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Set<BigInteger> distinctpowers = new HashSet<BigInteger>();

		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {

				distinctpowers.add(new BigInteger(new Integer(a).toString()).pow(b));
			}
		}
		
		System.out.println(distinctpowers.size());
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
