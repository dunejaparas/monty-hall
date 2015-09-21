package com.pd.core.montyhall.prize;

import static com.pd.core.montyhall.util.GameUtil.selectOneOfThreeBox;
import static com.pd.core.montyhall.util.StringBundle.PRIZE;

import java.util.ArrayList;

import com.pd.core.montyhall.box.Box;
import com.pd.core.montyhall.util.StringBundle;

public enum BoxesHandler {
	INSTANCE;

	// private ArrayList<Box> allBoxesInGame;

	public int initPrizeBoxesForTheGame() {
		int prizeWinningBoxNo = -1;
		final ArrayList<Box> populatedBoxes = new ArrayList<Box>(3);
		final int prizeBoxNumber = selectOneOfThreeBox();
		for (int index = 0; index < 3; index++) {
			final Box currBox = new Box(false);
			if (index == prizeBoxNumber) {
				currBox.setPrizeWinningBox(true);
				System.out.print(String.format(StringBundle.PROGRESS_MESSAGE, PRIZE, index));

				prizeWinningBoxNo = index;
			}
			populatedBoxes.add(currBox);
		}
		// allBoxesInGame = populatedBoxes;
		return prizeWinningBoxNo;
	}

	// public boolean setContestantNewSelection(final int lastBoxRemaining) {
	// if (allBoxesInGame == null) {
	// throw new IllegalArgumentException(ERROR_MSG_GAME_NOT_INITIALZED);
	// }
	// final Box box = allBoxesInGame.get(lastBoxRemaining);
	// return box.isPrizeWinningBox();
	// }
}
