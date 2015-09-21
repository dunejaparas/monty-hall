package com.pd.core.montyhall.prize;

import static com.pd.core.montyhall.util.GameUtil.selectOneOfThreeBox;
import static com.pd.core.montyhall.util.StringBundle.PRIZE;

import com.pd.core.montyhall.util.StringBundle;

public enum BoxesHandler {
	INSTANCE;

	public int initPrizeBoxesForTheGame() {
		final int prizeWinningBoxNo = selectOneOfThreeBox();
		System.out.print(String.format(StringBundle.PROGRESS_MESSAGE, PRIZE, prizeWinningBoxNo));
		return prizeWinningBoxNo;
	}
}
