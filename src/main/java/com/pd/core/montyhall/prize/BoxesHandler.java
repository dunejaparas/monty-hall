package com.pd.core.montyhall.prize;

import static com.pd.core.montyhall.util.MontyHallUtil.generateRandomNumberBetweenRange;

import java.util.ArrayList;

import com.pd.core.montyhall.box.Box;
import com.pd.core.montyhall.util.StringBundle;

public class BoxesHandler {
	private static BoxesHandler instance = null;
	private static Object lockObject = new Object();

	public static BoxesHandler getInstance() {
		if (instance == null) {
			synchronized (lockObject) {
				if (instance == null) {
					instance = new BoxesHandler();
				}
			}
		}
		return instance;
	}

	private int whichBoxContainsPrize = -1;
	private ArrayList<Box> allBoxesInGame;

	public void initPrizeBoxesForTheGame() {
		whichBoxContainsPrize = -1;
		final ArrayList<Box> populatedBoxes = new ArrayList<Box>(3);
		final int prizeBoxNumber = generateRandomNumberBetweenRange();
		for (int index = 0; index < 3; index++) {
			final Box currBox = new Box(false);
			if (index == prizeBoxNumber) {
				currBox.setPrizeWinningBox(true);
				System.out.print(String.format(StringBundle.PROGRESS_MESSAGE, "Prize", index));

				whichBoxContainsPrize = index;
			}
			populatedBoxes.add(currBox);
		}
		allBoxesInGame = populatedBoxes;
	}

	public int findWhichBoxContainsPrize() {
		return this.whichBoxContainsPrize;
	}

	public boolean setContestantNewSelection(final int lastBoxRemaining) {
		if (allBoxesInGame == null) {
			throw new NullPointerException("Game not initialzed yet");
		}
		final Box box = allBoxesInGame.get(lastBoxRemaining);
		return box.isPrizeWinningBox();
	}
}
