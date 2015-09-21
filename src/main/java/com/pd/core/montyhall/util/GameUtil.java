package com.pd.core.montyhall.util;

import java.util.Random;

public class GameUtil {
	final static int[] boxNumbers = { 0, 1, 2 };

	/*
	 * Create random number between '0, 1, 2' for the prize
	 */
	public static int selectOneOfThreeBox() {
		final int index = new Random().nextInt(boxNumbers.length);
		return boxNumbers[index];
	}

	public static int getEmptyBox(final int prizeBox, final int guestSelectedBox) {
		int result = -1;
		for (final int currBox : boxNumbers) {
			if (currBox != guestSelectedBox && currBox != prizeBox) {
				result = currBox;
				break;
			}
		}
		return result;
	}

	public static int getChangedBoxOfContestant(final int emptyBox, final int guestSelectedBox) {
		int result = -1;
		for (int currBoxNumber = 0; currBoxNumber < 3; currBoxNumber++) {
			if (emptyBox != currBoxNumber && currBoxNumber != guestSelectedBox) {
				System.out.print(String.format(StringBundle.PROGRESS_MESSAGE, "SwappedBox", currBoxNumber));
				result = currBoxNumber;
				break;
			}
		}
		return result;
	}
}