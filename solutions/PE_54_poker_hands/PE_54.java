package poker_hands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PE_54 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		File file = new File("p054_poker.txt");
		int winsCounter = 0;
		
		if (file.exists()) {
			
			try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
					) {
				
				String line = br.readLine();
				String hand_1 = null;
				String hand_2 = null;
				
				PokerHand ph_1 = null;
				PokerHand ph_2 = null;
				
				while(line != null) {
					
					hand_1 = line.substring(0, line.length()/2).trim();
					hand_2 = line.substring(line.length()/2, line.length()).trim();
					ph_1 = new PokerHand(hand_1);
					ph_2 = new PokerHand(hand_2);
					
					if (PE_54.isPlayer1Winner(ph_1, ph_2)) {
						winsCounter++;
					}
					
					line = br.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("# of player1 winning hands is : " + winsCounter);
		System.out.println("Time : " + (System.currentTimeMillis() - startTime) + " ms.");
		
	}
	
	public static boolean isPlayer1Winner(PokerHand ph_1, PokerHand ph_2) {
		
		if (ph_1.getHandRank() > ph_2.getHandRank())
			return true;
		else if (ph_1.getHandRank() < ph_2.getHandRank())
			return false;
		else {
			switch (ph_1.getHandRank()) {
			
			case PokerHand.HIGHCARD:
			case PokerHand.FLUSH:
				if (ph_1.getHighCard() > ph_2.getHighCard())
					return true;
				else if (ph_1.getHighCard() < ph_2.getHighCard())
					return false;
				else if (ph_1.getSecondHigherCard() > ph_2.getSecondHigherCard())
					return true;
				else if (ph_1.getSecondHigherCard() < ph_2.getSecondHigherCard())
					return false;
				else if (ph_1.getThirdHigherCard() > ph_2.getThirdHigherCard())
					return true;
				else if (ph_1.getThirdHigherCard() < ph_2.getThirdHigherCard())
					return false;
				else if (ph_1.getFourthHigherCard() > ph_2.getFourthHigherCard())
					return true;
				else if (ph_1.getFourthHigherCard() < ph_2.getFourthHigherCard())
					return false;
				else if (ph_1.getFifthHigherCard() > ph_2.getFifthHigherCard())
					return true;
				else if (ph_1.getFifthHigherCard() < ph_2.getFifthHigherCard())
					return false;
				else
					return false;
					
			case PokerHand.STRAIGHT:
			case PokerHand.STRAIGHT_FLUSH:
				return ph_1.getHighCard() > ph_2.getHighCard();

			case PokerHand.ONE_PAIR:
				if (ph_1.getHighestPair() > ph_2.getHighestPair())
					return true;
				else if (ph_1.getHighestPair() < ph_2.getHighestPair())
					return false;
				else if (ph_1.getHighCard() > ph_2.getHighCard())
					return true;
				else if (ph_1.getHighCard() < ph_2.getHighCard())
					return false;
				else if (ph_1.getSecondHigherCard() > ph_2.getSecondHigherCard())
					return true;
				else if (ph_1.getSecondHigherCard() < ph_2.getSecondHigherCard())
					return false;
				else if (ph_1.getThirdHigherCard() > ph_2.getThirdHigherCard())
					return true;
				else if (ph_1.getThirdHigherCard() < ph_2.getThirdHigherCard())
					return false;
				else
					return false;
				
			case PokerHand.TWO_PAIRS:
				if (ph_1.getHighestPair() > ph_2.getHighestPair())
					return true;
				else if (ph_1.getHighestPair() < ph_2.getHighestPair())
					return false;
				else if (ph_1.getLowestPair() > ph_2.getLowestPair())
					return true;
				else if (ph_1.getLowestPair() < ph_2.getLowestPair())
					return false;
				else if (ph_1.getHighCard() > ph_2.getHighCard())
					return true;
				else if (ph_1.getHighCard() < ph_2.getHighCard())
					return false;
				else
					return false;
					
			case PokerHand.THREE_OF_A_KIND:
				if (ph_1.getThreeOfAKind() > ph_2.getThreeOfAKind())
					return true;
				else if (ph_1.getThreeOfAKind() < ph_2.getThreeOfAKind())
					return false;
				else if (ph_1.getHighCard() > ph_2.getHighCard())
					return true;
				else if (ph_1.getHighCard() < ph_2.getHighCard())
					return false;
				else if (ph_1.getSecondHigherCard() > ph_2.getSecondHigherCard())
					return true;
				else if (ph_1.getSecondHigherCard() < ph_2.getSecondHigherCard())
					return false;
				else
					return false;
				
			case PokerHand.FULL_HOUSE:
				if (ph_1.getThreeOfAKind() > ph_2.getThreeOfAKind())
					return true;
				else if (ph_1.getThreeOfAKind() < ph_2.getThreeOfAKind())
					return false;
				else
					return ph_1.getHighestPair() > ph_2.getHighestPair();
				
			case PokerHand.FOUR_OF_A_KIND:
				if (ph_1.getFourOfAKind() > ph_2.getFourOfAKind())
					return true;
				else if (ph_1.getFourOfAKind() < ph_2.getFourOfAKind())
					return false;
				else if (ph_1.getHighCard() > ph_2.getHighCard())
					return true;
				else if (ph_1.getHighCard() < ph_2.getHighCard())
					return false;
				else
					return false;
				
			case PokerHand.ROYAL_FLUSH:
				return false;
			default:
				return false;
			}
		}
	}

}

class PokerHand {
	
	public final static int HIGHCARD = 0;
	public final static int ONE_PAIR = 1;
	public final static int TWO_PAIRS = 2;
	public final static int THREE_OF_A_KIND = 3;
	public final static int STRAIGHT = 4;
	public final static int FLUSH = 5;
	public final static int FULL_HOUSE = 6;
	public final static int FOUR_OF_A_KIND = 7;
	public final static int STRAIGHT_FLUSH = 8;
	public final static int ROYAL_FLUSH = 9;
	
	public final static char DIAMONDS = 'D';
	public final static char HEARTS = 'H';
	public final static char CLUBS = 'C';
	public final static char SPADES = 'S';
	
	public final static int CARDVALUES = 13;
	
	private int [] cardValues = null;
	private char [] cardTypes = null;
	
	private int handRank = 0;
	
	public PokerHand(String pokerhand) {
		
		cardValues = new int [CARDVALUES];
		cardTypes = new char [CARDVALUES];
		
		Arrays.fill(cardValues, 0);	
		Arrays.fill(cardTypes, '\u0000');
		
		String [] cardArray = pokerhand.split(" ");
		int length = cardArray.length;
		String cardValue = null;
		char cardType = '\u0000';
		
		for (int i = 0; i < length; i++) {
			
			cardValue = cardArray[i].substring(0, cardArray[i].length() - 1);
			cardType = cardArray[i].charAt(cardArray[i].length() - 1);
			
			switch (cardValue) {
			
			case "2":
				cardValues[0]++;
				cardTypes[0] = cardType;
				break;
			case "3":	
				cardValues[1]++;
				cardTypes[1] = cardType;
				break;
			case "4":	
				cardValues[2]++;
				cardTypes[2] = cardType;
				break;
			case "5":	
				cardValues[3]++;
				cardTypes[3] = cardType;
				break;
			case "6":	
				cardValues[4]++;
				cardTypes[4] = cardType;
				break;
			case "7":	
				cardValues[5]++;
				cardTypes[5] = cardType;
				break;
			case "8":
				cardValues[6]++;
				cardTypes[6] = cardType;
				break;
			case "9":	
				cardValues[7]++;
				cardTypes[7] = cardType;
				break;
			case "T":	
				cardValues[8]++;
				cardTypes[8] = cardType;
				break;
			case "J":	
				cardValues[9]++;
				cardTypes[9] = cardType;
				break;
			case "Q":	
				cardValues[10]++;
				cardTypes[10] = cardType;
				break;
			case "K":	
				cardValues[11]++;
				cardTypes[11] = cardType;
				break;
			case "A":	
				cardValues[12]++;
				cardTypes[12] = cardType;
				break;
			default :	
				break;
			}
		}
		computeHandRank();
	}
	
	public int getHandRank() {
		return handRank;
	}
	
	private void computeHandRank() {
		
		if (allDifferentcards())
			highCardStraightsOrFlushs();
		else
			pairTwoPairThreeFullOrFour();
	}
	
	private boolean allDifferentcards() {
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] > 1)
				return false;
		
		return true;
	}
	
	private void highCardStraightsOrFlushs() {
		if (allSameType())
			FlushStraightFlushOrRoyalStraightFlush();
		else
			highCardOrStraight();
	}
	
	private void pairTwoPairThreeFullOrFour() {
		if (hasFourOfAKind())
			handRank = FOUR_OF_A_KIND;
		else if (hasThreeOfAKind())
			threeOrFull();
		else
			pairOrTwoPair();
	}
	
	private boolean allSameType() {
		int sumOfTypes = 0;
		for (int i = 0; i < CARDVALUES; i++)
			if (cardTypes[i] != '\u0000')
				sumOfTypes += cardTypes[i];
		
		if (sumOfTypes == 5 * DIAMONDS
				|| sumOfTypes == 5 * HEARTS
				|| sumOfTypes == 5 * SPADES
				|| sumOfTypes == 5 * CLUBS)
			return true;
		else
			return false;
	}
	
	private void FlushStraightFlushOrRoyalStraightFlush() {
		if (computeLongestStreak() == 5)
			straightFlushOrRoyalStraightFlush();
		else
			handRank = FLUSH;
	}
	
	private void highCardOrStraight() {
		if (computeLongestStreak() == 5)
			handRank = STRAIGHT;
		else
			handRank = HIGHCARD;
	}
	
	private boolean hasFourOfAKind() {
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] == 4)
				return true;
		
		return false;
	}
	
	private boolean hasThreeOfAKind() {
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] == 3)
				return true;
		
		return false;
	}
	
	private void threeOrFull() {
		int pairs = 0;
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] == 2)
				pairs++;
		
		if (pairs != 0)
			handRank = FULL_HOUSE;
		else
			handRank = THREE_OF_A_KIND;
	}
	
	private void pairOrTwoPair() {
		int pairs = 0;
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] == 2)
				pairs++;
		
		if (pairs == 2)
			handRank = TWO_PAIRS;
		else
			handRank = ONE_PAIR;
	}
	
	private int computeLongestStreak() {
		
		int currentStreak = 0;
		int maxStreak = 0;
		for (int i = 0; i < CARDVALUES; i++) {
			if (cardValues[i] == 1) {
				currentStreak++;
			} else {
				currentStreak = 0;
			}
			if (currentStreak > maxStreak) {
				maxStreak = currentStreak;
			}
		}
		return maxStreak;
	}
	
	private void straightFlushOrRoyalStraightFlush() {
		boolean isRoyal = true;
		
		for (int i = CARDVALUES - 1; i < CARDVALUES - 5; i--) {
			isRoyal = isRoyal && (cardValues[i] == 1);
		}
		if (isRoyal)
			handRank = ROYAL_FLUSH;
		else
			handRank = STRAIGHT_FLUSH;
	}
	
	public int getHighCard() {
		
		for (int i = CARDVALUES - 1; i >= 0; i--)
			if (cardValues[i] == 1)
				return i;
		return -1;
	}
	
	public int getHighestPair() {
		for (int i = CARDVALUES - 1; i >= 0; i--)
			if (cardValues[i] == 2)
				return i;
		return -1;
	}
	
	public int getLowestPair() {
		for (int i = 0; i < CARDVALUES; i++)
			if (cardValues[i] == 2)
				return i;
		return -1;
	}
	
	public int getThreeOfAKind() {
		for (int i = CARDVALUES - 1; i >= 0; i--)
			if (cardValues[i] == 3)
				return i;
		return -1;
	}
	
	public int getFourOfAKind() {
		for (int i = CARDVALUES - 1; i >= 0; i--)
			if (cardValues[i] == 4)
				return i;
		return -1;
	}
	
	public int getSecondHigherCard() {
		int index = 0;
		for (int i = CARDVALUES - 1; i >= 0; i--) {
			if (cardValues[i] == 1)
				index++;
			if (index == 2)
				return cardValues[i];
		}
		return -1;
	}
	
	public int getThirdHigherCard() {
		int index = 0;
		for (int i = CARDVALUES - 1; i >= 0; i--) {
			if (cardValues[i] == 1)
				index++;
			if (index == 3)
				return cardValues[i];
		}
		return -1;
	}
	
	public int getFourthHigherCard() {
		int index = 0;
		for (int i = CARDVALUES - 1; i >= 0; i--) {
			if (cardValues[i] == 1)
				index++;
			if (index == 4)
				return cardValues[i];
		}
		return -1;
	}
	
	public int getFifthHigherCard() {
		int index = 0;
		for (int i = CARDVALUES - 1; i >= 0; i--) {
			if (cardValues[i] == 1)
				index++;
			if (index == 5)
				return cardValues[i];
		}
		return -1;
	}
}
