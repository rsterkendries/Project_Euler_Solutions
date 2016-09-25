package coded_triangle_numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PE_42 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		File file = new File("p042_words.txt");
		int trianglewordCounter = 0;
		
		if (file.exists()) {
			try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
					) {
				
				String [] wordArray = br.readLine().split(",");
				int wordvalue = 0;
				String word = null;
				
				for (String str : wordArray) {
				
					word = str.substring(1, str.length() - 1);
					wordvalue = PE_42.convertWordToNumber(word);
					
					if (PE_42.isTriangleNumber(wordvalue))
						trianglewordCounter++;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Total number of triangle words : " + trianglewordCounter);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	public static int computeNthTriangleNumber(int n) {
		return n * (n + 1)/2;
	}
	
	public static boolean isTriangleNumber(int P) {
		return (-1 + Math.sqrt(1 + 8 * P) % 2 == 0);
	}
	
	public static int convertWordToNumber(String word) {
		
		int length = word.length();
		int number = 0;
		
		for (int i = 0; i < length; i++)
			number += (word.charAt(i) - 64);
		
		return number;
	}

}
