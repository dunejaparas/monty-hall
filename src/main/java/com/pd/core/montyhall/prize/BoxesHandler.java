package com.pd.core.montyhall.prize;

import static com.pd.core.montyhall.util.GameUtil.selectOneOfThreeBox;
import static com.pd.core.montyhall.util.StringBundle.PRIZE;

import com.pd.core.montyhall.util.StringBundle;

public enum BoxesHandler {
	INSTANCE;

	public int initPrizeBoxesForTheGame() {
		int prizeWinningBoxNo = -1;
		final int prizeBoxNumber = selectOneOfThreeBox();
		for (int index = 0; index < 3; index++) {
			if (index == prizeBoxNumber) {
				System.out.print(String.format(StringBundle.PROGRESS_MESSAGE, PRIZE, index));
				prizeWinningBoxNo = index;
			}
		}
		return prizeWinningBoxNo;
	}
}
