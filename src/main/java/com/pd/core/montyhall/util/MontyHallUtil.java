package com.pd.core.montyhall.util;

public class MontyHallUtil {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 2;

	/*
	 * Create random number between '0, 1, 2' for the prize
	 */
	public static int generateRandomNumberBetweenRange() {
		return (MIN_VALUE + (int) (Math.random() * ((MAX_VALUE - MIN_VALUE) + 1)));
	}

	public static int findWhichBoxIsEmptyBox(final int prizeBox, final int guestSelectedBox) {
		int result = -1;
		while (true) {
			final int emptyBox = generateRandomNumberBetweenRange();
			if (emptyBox != guestSelectedBox && emptyBox != prizeBox) {
				result = emptyBox;
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