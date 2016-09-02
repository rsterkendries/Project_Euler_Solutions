package number_spiral_diagonals;

import java.util.Arrays;

public class PE_28 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int size = 1001;
		int [][] integerArray = generateSpriral(size);
		
		/*for (int i = 0; i < size; i++) {			
			for (int j = 0; j < size; j++) {				
				System.out.printf("%4d",integerArray[i][j]);
			}
			System.out.println(); 
		}*/
		
		System.out.println(computeSumOfColumns(integerArray));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static int computeSumOfColumns(int [][] integerArray) {
		int sum = 0;
		int size = integerArray.length;
		for(int i = 0; i < size; i++) {
			sum += integerArray[i][i];
			sum += integerArray[i][size - 1 - i];
		}
		return sum - integerArray[size/2][size/2];
	}
	
	public static int [][] generateSpriral(int size) {

		if (size %2 != 0) {
			int [][] integerArray = new int [size][size];
			for (int i = 0; i < size; i++)
				Arrays.fill(integerArray[i], 0);
			int steps = 1;
			int index = 1;
			int i = size/2;
			int j = size/2;
			
			integerArray[i][j] = index;
			
			while (steps <= size) {
				
				try {
				
					if (steps % 2 == 0) {
						
						for (int k = 0; k < steps; k++) {
							j++;
							integerArray[i][j] = ++index;
						}
						for (int k = 0; k < steps; k++) {
							i++;
							integerArray[i][j] = ++index;
						}
					}
					
					else {
						
						for (int k = 0; k < steps; k++) {
							j--;
							integerArray[i][j] = ++index;
						}
						for (int k = 0; k < steps; k++) {
							i--;
							integerArray[i][j] = ++index;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// ignore
				}
				
				steps++;
			} 
			
			return integerArray;
		}
		else
			return new int [0][0];
	}
}
