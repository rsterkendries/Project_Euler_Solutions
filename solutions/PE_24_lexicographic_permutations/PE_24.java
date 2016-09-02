package lexicographic_permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PE_24 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String str = "0123456789";
		List<String> permutations = new ArrayList<String>();
		PE_24.permutation("", str, permutations);
		
		Collections.sort(permutations);
		
		System.out.printf("%s" + System.lineSeparator(), permutations.get(1000000 - 1));
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	private static void permutation(String prefix, String str, List<String> perms) {
	    int n = str.length();
	    if (n == 0) {
	    	//System.out.println(prefix);
	    	perms.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++) {
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), perms);
	        }
	    }
	}
}
