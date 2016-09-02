package non_abundant_sums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PE_23 {

private List<Integer> primesList = new ArrayList<Integer>();
	
	{
		primesList.add(new Integer(2));
		primesList.add(new Integer(3));
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		PE_23 tc = new PE_23();
		int limit = 28124;
		tc.generatePrimesBelowN(limit);
		
		Integer [] primedivisors = null;
		Integer [] exponents = null;
		Integer [] properdivisors = null;

		StringBuilder sb = new StringBuilder();
		
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		
		for(int index = 4; index <= limit; index++) {
			if (!tc.primesList.contains(new Integer(index))) {

				sb.append(index + " [ ");
				primedivisors = tc.getPrimeDivisors(index);
				for (Integer itg : primedivisors) {

					sb.append(itg + " ");
				}

				sb.append("]");
				

				sb.append(" [ ");
				exponents = tc.getDivisorExponents(index, primedivisors);
				for (Integer itg : exponents) {

					sb.append(itg + " ");
				}

				sb.append("]");
				
				sb.append(" [ ");
				properdivisors = tc.getProperDivisors(primedivisors, exponents);
				int properdivisorSum = 0;
				for (Integer itg : properdivisors) {
					properdivisorSum += itg;
					sb.append(itg + " ");
				}

				sb.append("]");
				
				sb.append(" [ ");
				sb.append(properdivisorSum);
				sb.append(" ]");
				
				if (properdivisorSum > index) {
					abundantNumbers.add(index);
				}
				//System.out.println(sb.toString());
				sb.delete(0, sb.length());
			}
		}
		
		List<Integer> sumOfTwoAbundantNumbers = new ArrayList<Integer>();
		Integer sum = 0;
		for (Integer abundant1 : abundantNumbers) {
			for (Integer abundant2 : abundantNumbers) {
				sum = abundant1 + abundant2;
				sumOfTwoAbundantNumbers.add(sum);
			}
		}
		Set<Integer> sumOfTwoAbundantNumbersAsSet = new HashSet<Integer>(sumOfTwoAbundantNumbers);
		int totalSum = 0;
		for (int i = 0; i < limit; i++) {
			if (!sumOfTwoAbundantNumbersAsSet.contains(new Integer(i)))
				totalSum += i;
		}
		System.out.println(totalSum);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
	
	public Integer [] getPrimeDivisors(int number) {
		List<Integer> primedivisorsList = new ArrayList<Integer>();
		
		if (number > 0) {
			int index = 0;
			int prime = this.primesList.get(index);
			while (prime < number / 2 + 1) {
				if (number % prime == 0) {
					primedivisorsList.add(prime);
				}
				prime = this.primesList.get(++index);
			}
		}
		
		return primedivisorsList.toArray(new Integer[primedivisorsList.size()]);
	}
	
	public Integer [] getDivisorExponents(Integer number, Integer [] primedivisors) {
		Integer [] exponents = new Integer[primedivisors.length];		
		for(int index = 0; index < exponents.length; index++)
			exponents[index] = 0;
		
		if (number > 0 && primedivisors != null) {
			
			int integerToDivide = number;
			int index = 0;
			while (integerToDivide != 1) {
				
				if (integerToDivide % primedivisors[index] == 0) {
					integerToDivide /= primedivisors[index];
					exponents[index]++;
				}
				else {
					index++;
				}
			}
		}
		
		return exponents;
	}
	
	public Integer [] getProperDivisors(Integer [] primedivisors, Integer [] exponents) {
		List<Integer> properdivisorsList = new ArrayList<Integer>();
		List<Integer> elements = new ArrayList<Integer>();
		
		if (primedivisors != null && exponents != null) {
			int size = primedivisors.length;
			
			for (int i = 0; i < size; i++) {
				for (int j = 1; j <= exponents[i]; j++) {
					
					elements.add(primedivisors[i]);
				}
			}
			
			Integer [] array = elements.toArray(new Integer[elements.size()]);
			properdivisorsList = PE_23.computeAllCombinations(array);
		}
		
		return properdivisorsList.toArray(new Integer[properdivisorsList.size()]);
	}
	
	public void generatePrimesBelowN(int number) {
		if (number > 5) {			
			for (int index = 5; index < number; index++) {
				if (isPrime(index))
					this.primesList.add(index);
			}
		}		
	}
	
	private boolean isPrime(int number) {
		boolean isPrime = true;
		int index = 0;
		while(isPrime == true && index < this.primesList.size()) {
			if (((((double)number/this.primesList.get(index)) % 1) == 0)) {
				isPrime = false;
			}
			index ++;
		}
		
		return isPrime;
	}
	
	private static List<Integer> computeAllCombinations(Integer [] array) {
    	List<Integer> properdivisors = new ArrayList<Integer>();
    	
    	for (int k = 0; k < array.length; k++) {
    		properdivisors.addAll(PE_23.computeAllCombinationsOfSizek(array, k));
    	}
    	
    	return properdivisors;
    }
    
    private static List<Integer> computeAllCombinationsOfSizek(Integer [] array, int k) {
    	List<Integer> kdivisors = new ArrayList<Integer>();
    	Integer [] combo = new Integer [k];
    	int n = array.length;
    	
    	PE_23.CombinationUtility(array, combo, kdivisors, n, k, 0, 0);
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
    	PE_23.CombinationUtility(array, combo, properdivisorsList, n, k, index + 1, i + 1);
    	PE_23.CombinationUtility(array, combo, properdivisorsList, n, k, index, i + 1);
    	//System.out.println("OUT - bottom normal - index = " + index + ", i = " + i);
    }
}
