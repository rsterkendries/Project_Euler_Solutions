package names_scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PE_22 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<String> namesList = PE_22.getNamesFromFileAsList(new File("p022_names.txt"));
		Collections.sort(namesList);
		int index = 0;
		long total = 0;
		int namescore = 0;
		for (String name : namesList) {
			int lettersum = 0;
			for (int i = 0; i < name.length(); i++)			
				lettersum += (name.charAt(i) - 96);
			namescore = (index + 1) * lettersum;
			//System.out.printf("%10s %s %5d" + System.lineSeparator(), name, "scores" , namescore);
			lettersum = 0;
			total += namescore;
			index++;
		}
		System.out.printf("total namescore : %d" + System.lineSeparator(), total);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public static List<String> getNamesFromFileAsList(File f) {
		List<String> namesList = new ArrayList<String>();
		
		if (f.exists()) {
			
			try (
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
					) {
				String line = br.readLine();
				String [] names = null;
				
				while(line != null) {
					
					names = line.split(",");
					line = br.readLine();
				}
				
				int numNames = names.length;
				
				for (int index = 0; index < numNames; index++) {
					
					names[index] = names[index].replace("\"", "").toLowerCase();
				}
				
				namesList = Arrays.asList(names);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return namesList;
	}
}
