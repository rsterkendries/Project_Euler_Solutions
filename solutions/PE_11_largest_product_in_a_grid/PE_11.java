package largest_product_in_a_grid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PE_11 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int grid_size = 20;
		int num_elements = 4;
		
		Integer [] numbers = PE_11.getGridArrayFromFile(new File("array.txt"));
		int [][] grid_array = PE_11.getArrayFromList(numbers, grid_size);
		
		for(int i = 0; i < grid_size; i++) {
			for(int j = 0; j < grid_size; j++) {
				System.out.printf("%4d", grid_array[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("horizontal maxproduct (" + num_elements + "): "
				+ PE_11.compute_largest_horizontal_product(grid_array, grid_size, num_elements));
		
		System.out.println("vertical maxproduct (" + num_elements + "): "
				+ PE_11.compute_largest_vertical_product(grid_array, grid_size, num_elements));
		
		System.out.println("diagonal maxproduct (" + num_elements + "): "
				+ PE_11.compute_largest_diagonal_product(grid_array, grid_size, num_elements));
		
		grid_array = PE_11.reverseGrid(grid_array, grid_size);
		System.out.println();
		
		for(int i = 0; i < grid_size; i++) {
			for(int j = 0; j < grid_size; j++) {
				System.out.printf("%4d", grid_array[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("diagonal maxproduct (" + num_elements + "): "
				+ PE_11.compute_largest_diagonal_product(grid_array, grid_size, num_elements));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static Integer [] getGridArrayFromFile(File f) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		if(f.exists()) {			
			try (
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					) {
				
				String line = null;
				line = br.readLine();				
				while(line != null) {					
					String [] values = line.split(" ");
					
					PE_11.transform(values, numbers);
					
					line = br.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		   
		return numbers.toArray(new Integer[numbers.size()]);
		
	}
	
	public static int [][] getArrayFromList(Integer [] numbers, int grid_size) {
		
		int [][] grid_array = new int[grid_size][grid_size];
		
		for(int i = 0; i < grid_size; i++) {
			
			for(int j = 0; j < grid_size; j++) {
				
				grid_array[i][j] = numbers[i * grid_size + j];
			}

		}
		
		return grid_array;
	}
	
	public static List<Integer> transform(String[] line, List<Integer> numbers) {
		
		if(line != null && line.length > 0) {
			for(String s : line) {
				numbers.add(Integer.parseInt(s));
			}
		}
		
		return numbers;
	}
	
	public static int compute_largest_horizontal_product(int [][] array, int grid_size, int num_elements) {
		
		int product = 1;
		int maxproduct = 1;
		
		for(int i = 0; i < grid_size; i++) {
			
			for(int j = 0; j < grid_size - num_elements + 1; j++) {
				
				for(int index = 0; index < num_elements; index++) {
					
					//product *= array[i * grid_size + j + index];
					product *= array[i][j + index];
					
				}
				
				if (product > maxproduct) {
					maxproduct = product;
				}
				product = 1;
			}
		}
		
		return maxproduct;
	}
	
	public static int compute_largest_vertical_product(int [][] array, int grid_size, int num_elements) {
		
		int product = 1;
		int maxproduct = 1;
		
		for(int i = 0; i < grid_size - num_elements + 1; i++) {
			
			for(int j = 0; j < grid_size; j++) {
				
				for(int index = 0; index < num_elements; index++) {
					
					//product *= array[(i + index) * grid_size + j];
					product *= array[i + index][j];
					
				}
				
				if (product > maxproduct) {
					maxproduct = product;
				}
				product = 1;
			}
		}
		
		return maxproduct;
	}
	
	public static int compute_largest_diagonal_product(int [][] array, int grid_size, int num_elements) {
		
		int product = 1;
		int maxproduct = 1;
		
		//x x x
		//. x x
		//. . x
		for (int i = 0; i < grid_size - num_elements + 1; i++) {
			
			for (int j = 0; j < grid_size - num_elements + 1 - i; j++) {

				for (int index = 0; index < num_elements; index++) {

					//product *= array[(j + index) * grid_size + j + i + index];
					product *= array[j + index][i + j + index];
				}

				if (product > maxproduct) {
					maxproduct = product;
				}
				product = 1;
			} 
		}
		
		//. . .
		//x . .
		//x x .
		for(int i = 1; i < grid_size - num_elements + 1; i++) {
			
			for(int j = 0; j < i; j++) {
				
				for (int index = 0; index < num_elements; index++) {

					//product *= array[(i + index) * grid_size + j + index];
					product *= array[i + index][j + index];
				}

				if (product > maxproduct) {
					maxproduct = product;
				}
				product = 1;
			}
		}
		
		return maxproduct;
	}
	
	public static int [][] reverseGrid(int [][] array, int grid_size) {
		
		int [][] reversedArray = new int [grid_size][grid_size];
		
		for(int i = 0; i < grid_size; i++) {
			
			for(int j = 0; j < grid_size; j++) {
				
				reversedArray[i][j] = array[i][grid_size - j - 1];
			}
		}
		
		return reversedArray;
		
	}
}
