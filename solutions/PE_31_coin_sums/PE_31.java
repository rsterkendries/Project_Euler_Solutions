package coin_sums;

import java.util.Arrays;

public class PE_31 {

	private final static Integer TOTAL = 200;
	private final static Integer [] COINS = new Integer [] {1,2,5,10,20,50,100,200};

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("dynamic programming : " + PE_31.dynamicprogramming(COINS, TOTAL) + " ways.");
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
		startTime = System.currentTimeMillis();
		System.out.println("bruteforce : " + PE_31.bruteforce(COINS) + " ways.");
		System.out.println("Time = " + (System.currentTimeMillis() - startTime)/1000 +" s");

	}
	
	public static int dynamicprogramming(Integer [] coins, Integer total) {
		
		Integer [] array = new Integer [total + 1];
		Arrays.fill(array, 0);

		array[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= total; j++) {
				array[j] += array[j - coins[i]];
			}
			/*for (Integer itg : array)
				System.out.print(itg + " ");
			System.out.println();*/
		}
		
		return array[total];
	}
	
	public static int bruteforce(Integer [] coins) {
		
		int total = 0;
		int numWays = 0;
		
		for (int i1 = 0; i1 <= 200; i1++) {
			for (int i2 = 0; i2 <= 100; i2++) {
				for (int i3 = 0; i3 <= 40; i3++) {
					for (int i4 = 0; i4 <= 20; i4++) {
						for (int i5 = 0; i5 <= 10; i5++) {
							for (int i6 = 0; i6 <= 4; i6++) {
								for (int i7 = 0; i7 <= 2; i7++) {
									for (int i8 = 0; i8 <= 1; i8++) {
										
										total = i1 * coins[0] + 
												i2 * coins[1] + 
												i3 * coins[2] + 
												i4 * coins[3] + 
												i5 * coins[4] + 
												i6 * coins[5] + 
												i7 * coins[6] + 
												i8 * coins[7];
										
										if (total == TOTAL)
											numWays++;
									}
								}
							}
						}
					}
				}
			}
		}
		return numWays;
	}
}
