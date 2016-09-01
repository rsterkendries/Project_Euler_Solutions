package highly_divisible_triangular_number;

import java.util.ArrayList;
import java.util.List;

public class PE_12 {

	final static int LIMIT = 500;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int numDivisors = 0;
		int N = 1;
		do {
			numDivisors = PE_12.getDivisors(PE_12.compute_Nth_trianglenumber(++N));
		} while (numDivisors < LIMIT);
		
		System.out.println(N + " whose trianglenumber is " + PE_12.compute_Nth_trianglenumber(N) + " and has " + numDivisors + " divisors.");
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}

	public static int getDivisors(int trianglenumber) {
		List<Integer> primedivisors = new ArrayList<Integer>();
		
		int number = trianglenumber;
		int div = 2;
		while(number != 1) {
			if (number % div == 0) {
				number /= div;
				primedivisors.add(new Integer(div));
			}
			else {
				div++;
			}
		}
		
		List<Integer> alldivisors = PE_12.computeAllCombinations(primedivisors.toArray(new Integer [primedivisors.size()]));
		/*for (Integer i : alldivisors) {
			System.out.print(i + " ");
		}
		System.out.println();*/
		
		return alldivisors.size();
	}
	
	private static List<Integer> computeAllCombinations(Integer [] array) {
    	List<Integer> properdivisors = new ArrayList<Integer>();
    	
    	for (int k = 0; k < array.length; k++) {
    		properdivisors.addAll(PE_12.computeAllCombinationsOfSizek(array, k));
    	}
    	int product = 1;
    	for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}
    	properdivisors.add(product);
    	return properdivisors;
    }
	
	private static List<Integer> computeAllCombinationsOfSizek(Integer [] array, int k) {
    	List<Integer> kdivisors = new ArrayList<Integer>();
    	Integer [] combo = new Integer [k];
    	int n = array.length;
    	
    	PE_12.CombinationUtility(array, combo, kdivisors, n, k, 0, 0);
    	return kdivisors;
    }
    
    private static void CombinationUtility(Integer [] array, Integer [] combo, List<Integer> properdivisorsList, int n, int k, int index, int i) {
    	
    	//System.out.println("IN - index = " + index + ", i = " + i);
    	
    	if (index == k) {
    		int product = 1;
    		for (int j = 0; j < k; j++) {
    			product *= combo[j];
    		}
    		Integer value = new Integer(product);
    		if (!properdivisorsList.contains(value))
    			properdivisorsList.add(value);
    		//System.out.println("OUT - print - index = " + index + ", i = " + i);
    		return;
    	}
    	
    	if (i >= n) {
    		//System.out.println("OUT - i >= n (" + i + " >= " + n + ")");
    		return;
    	}
    	
    	combo[index] = array[i];
    	PE_12.CombinationUtility(array, combo, properdivisorsList, n, k, index + 1, i + 1);
    	PE_12.CombinationUtility(array, combo, properdivisorsList, n, k, index, i + 1);
    	//System.out.println("OUT - bottom normal - index = " + index + ", i = " + i);
    }
	
	public static int compute_Nth_trianglenumber(int N) {		
		int trianglenumber = 0;		
		for(int i = 1; i < N + 1; i++) {
			trianglenumber += i;
		}
		
		return trianglenumber;
	}
}
