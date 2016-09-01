package large_sum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PE_13 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String[] numbers = PE_13.getGridArrayFromFile(new File("numbers.txt"));
		
		BigInteger bigitg = new BigInteger("0");
		
		for(String s : numbers) {

			bigitg = bigitg.add(new BigInteger(s));
		}
		
		System.out.println(bigitg);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static String [] getGridArrayFromFile(File f) {
		List<String> numbers = new ArrayList<String>();
		
		if(f.exists()) {			
			try (
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					) {
				
				String line = null;
				line = br.readLine();				
				while(line != null) {
					numbers.add(line);
					line = br.readLine();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		   
		return numbers.toArray(new String[numbers.size()]);		
	}
}
