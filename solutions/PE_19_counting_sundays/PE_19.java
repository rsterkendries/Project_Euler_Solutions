package counting_sundays;

import org.joda.time.DateTime;

public class PE_19 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		DateTime start = new DateTime("1901-01-01");
		DateTime finish = new DateTime("2000-12-31");
		
		int numOfSundays1stOfTheMonth = 0;
		
		while(!start.equals(finish)) {
			if(start.dayOfMonth().get() == 1 && start.dayOfWeek().get() == 7)
				numOfSundays1stOfTheMonth++;
			start = start.plusDays(1);
		}
		
		System.out.println(numOfSundays1stOfTheMonth);
		System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
	}
}
