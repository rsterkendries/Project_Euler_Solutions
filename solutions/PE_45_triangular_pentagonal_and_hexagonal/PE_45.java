package triangular_pentagonal_and_hexagonal;

public class PE_45 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		PE_45 pe_45 = new PE_45();
		long index = 144L;
		long number = pe_45.computeHexagonal(index);
		
		// brute force: check isPentagonal && isHexagonal && isTriangular
		// notice that all hexagonal numbers are odd index for triangular numbers
		// so that divides computationTime by ~2 already
		// next thing is to generate hex numbers (which are already triangular) and
		// then check only if isPentagonal

		while (!pe_45.isPentagonal(number)) {
			number = pe_45.computeHexagonal(++index);
		}
		
		System.out.println("next hexagonal and triangular and pentagonal number is : " + number);
		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	
	public boolean isPentagonal(long number) {
		return ((1 + Math.sqrt(1 + 24 * number)) % 6) == 0;
	}
	
	public long computeHexagonal(long n) {
		return (long) (n * (2 * n - 1));
	}

}
