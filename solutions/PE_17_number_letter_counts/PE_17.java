package number_letter_counts;

public class PE_17 {

	private static final String[] numNames = {
		    "",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    " seven",
		    " eight",
		    " nine",
		    " ten",
		    " eleven",
		    " twelve",
		    " thirteen",
		    " fourteen",
		    " fifteen",
		    " sixteen",
		    " seventeen",
		    " eighteen",
		    " nineteen"
			  };
		
		private static final String[] tensNames = {
		    "",
		    " ten",
		    " twenty",
		    " thirty",
		    " forty",
		    " fifty",
		    " sixty",
		    " seventy",
		    " eighty",
		    " ninety"
		  };

		public static void main(String[] args) {
			long startTime = System.currentTimeMillis();
			int limit = 1000;
			String [] words = new String[limit];
			
			int sum = 0;
			
			for(Integer index = 1; index < limit; index++) {
				
				words[index] = PE_17.convertIntToWord(index.toString()).trim();
				System.out.println(words[index] + " [" + PE_17.countLetters(words[index]) + "]");
				sum += PE_17.countLetters(words[index]);
			}
			
			// add "one thousand" which has not been processed
			words[0] = new String("one thousand");
			sum += PE_17.countLetters(words[0]);
			
			System.out.println(sum);
			System.out.println("Time = " + (System.currentTimeMillis() - startTime) +" ms");
		}
		
		public static int countLetters(String word) {
			int count = 0;
			
			if(word != null && !word.isEmpty()) {
				
				char [] letters = word.toCharArray();
				int length = letters.length;
				
				for(int index = 0; index < length; index++) {
					
					if(letters[index] != '-' && letters[index] != ' ') {
						count += 1;
					}
				}
			}
			
			return count;
		}
		
		public static String convertIntToWord(String index) {
			
			StringBuffer sb = new StringBuffer();
			
			switch(index.length()) {
			
			case 1:
				sb.append(convertUnitstoWord(index));
				break;
				
			case 2:
				sb.append(convertTenstoWord(index));
				break;
				
			case 3:
				sb.append(convertHundredstoWord(index));
				break;
				
			default:
				System.out.println("should never happen");
			}
			
			return sb.toString();
		}
		
		private static String convertUnitstoWord(String index) {
			
			String numberWord = null;		
			Integer units = Integer.parseInt(index);
			numberWord = PE_17.numNames[units];
			
			return numberWord;
		}
		
		private static String convertTenstoWord(String index) {
			
			String numberWord = null;
			StringBuffer sb = new StringBuffer();
			Integer tens = Integer.parseInt(index);
			
			if(tens < 20)
				numberWord = PE_17.numNames[tens];
			
			else {
				tens = Integer.parseInt(index.substring(0,1));
				sb.append(PE_17.tensNames[tens]);
				
				Integer units = Integer.parseInt(index.substring(1,2));
				
				if (units != 0) {
					sb.append("-");
					sb.append(PE_17.convertUnitstoWord(units.toString()).trim());
				}
				
				numberWord = sb.toString();
			}
			
			return numberWord;
		}
		
		private static String convertHundredstoWord(String index) {
			
			String numberWord = null;
			StringBuffer sb = new StringBuffer();
			Integer hundreds = Integer.parseInt(index.substring(0,1));
			sb.append(PE_17.numNames[hundreds]);
			sb.append(" hundred");
			
			if (!index.substring(1,2).equals("0")) {
				sb.append(" and");
				sb.append(PE_17.convertTenstoWord(index.substring(1,3)));
				
			}
			
			else if (!index.substring(2,3).equals("0")) {
				sb.append(" and");
				sb.append(PE_17.convertTenstoWord(index.substring(2,3)));
			}
			
			numberWord = sb.toString();
			return numberWord;
		}
}
