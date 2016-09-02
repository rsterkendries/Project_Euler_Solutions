package maximum_path_sum_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PE_18 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Integer [][] integerArray = PE_18.getGridArrayFromFile(new File("triangle.txt"));
		int size = integerArray.length;
		
		/*for(int i = 0; i < size; i++) {			
			for(int j = 0; j < size; j++) {				
				System.out.printf("%4d", integerArray[i][j]);
			}
			System.out.println();
		}*/
		
		System.out.printf("%5d %8s" + System.lineSeparator(), PE_18.findMaximumPathSumFromTop(integerArray), "top");
		for(int position = 0; position < size; position++) {
			System.out.printf("%5d %8s[%d]" + System.lineSeparator(), PE_18.findMaximumPathFromBottom(integerArray, position), "bottom", position);
		}
		
		System.out.printf("max: %2d" + System.lineSeparator(),findMaximumPathFromTopSummingSmartSolution(integerArray));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static int findMaximumPathFromTopSummingSmartSolution(Integer [][] integerArray) {
		
		int size = integerArray.length;	
		int sum = 0;
		
		for(int i = 1; i < size; i++) {
			
			for(int j = 0; j <= i; j++) {
				
				if (j == 0) {
					integerArray[i][j] += integerArray[i - 1][j];
				}
				
				else if(j == i) {
					integerArray[i][j] += integerArray[i - 1][j - 1];
				}
				
				else {
					if (integerArray[i - 1][j - 1] > integerArray[i - 1][j]) {
						integerArray[i][j] += integerArray[i - 1][j - 1];
					}
					else {
						integerArray[i][j] += integerArray[i - 1][j];
					}
				}
			}
		}
		
		for(int index = 0; index < size; index++) {
			if(integerArray[size - 1][index] > sum) {
				sum = integerArray[size - 1][index];
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {				
				System.out.printf("%7d", integerArray[i][j]);
			}
			System.out.println();
		}
		
		return sum;
	}
	
	public static int findMaximumPathFromBottom(Integer [][] integerArray, int startPosition) {
		
		int size = integerArray.length;		
		int sum = 0;		
		int i = size - 1;
		int j = startPosition;
		
		sum += integerArray[i][j];
		
		System.out.print(integerArray[i][j]);
		
		while(i != 0) {
			
			if (j - i == 0) { //right diagonal : only left-move allowed
				sum += integerArray[i = i - 1][j = j - 1];
			}
			
			else if (j == 0) { // left diagonal : only right-move allowed
				sum += integerArray[i = i - 1][j];
			}
			
			else { // bulk : both moves allowed
				if (integerArray[i - 1][j] > integerArray[i - 1][j - 1]) {
					sum += integerArray[i = i - 1][j];
				}
				
				else {
					sum += integerArray[i = i - 1][j = j - 1];
				}
			}
			System.out.print(" -> " + integerArray[i][j]);
		}
		
		return sum;
	}
	
	public static int findMaximumPathSumFromTop(Integer [][] integerArray) {
		
		int size = integerArray.length;		
		int sum = 0;		
		int i = 0;
		int j = 0;
		
		sum += integerArray[i][j];
		
		System.out.print(integerArray[i][j]);
		
		while(i != size - 1) {
			
			if (integerArray[i + 1][j] > integerArray[i + 1][j + 1]) {
				sum += integerArray[i = i + 1][j];
			}
			
			else {
				sum += integerArray[i = i + 1][j = j + 1];
			}
			System.out.print(" -> " + integerArray[i][j]);
		}
		
		return sum;
	}
	
	private static Integer [][] transformTriangle(List<List<Integer>> triangle) {
		
		int size = triangle.size();
		Integer [][] integerArray = new Integer[size][size];
		
		for(int i = 0; i < size; i++) {			
			for(int j = 0; j < size; j++) {				
				integerArray[i][j] = 0;
			}
		}
		
		for(int i = 0; i < size; i++) {
			
			for(int j = 0; j <= i; j++) {
				
				integerArray[i][j] = triangle.get(i).get(j);
			}
		}
		
		
		return integerArray;
	}
	
	public static Integer [][] getGridArrayFromFile(File f) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		if(f.exists()) {			
			try (
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					) {
				
				String line = null;
				line = br.readLine();				
				while(line != null) {
					
					String [] values = line.trim().split(" ");
					List<Integer> oneLineValues = new ArrayList<Integer>();
					
					for(String s : values)
						oneLineValues.add(Integer.parseInt(s));
					
					triangle.add(oneLineValues);
					line = br.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		   
		return PE_18.transformTriangle(triangle);		
	}
}
