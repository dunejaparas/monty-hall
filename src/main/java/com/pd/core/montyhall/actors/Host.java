package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.MontyHallUtil.findWhichBoxIsEmptyBox;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_HOST;
import static com.pd.core.montyhall.util.StringBundle.PROGRESS_MESSAGE;

import com.pd.core.montyhall.prize.BoxesHandler;

public class Host implements IActor {

	int chosenEmptyBoxNumber;
	BoxesHandler prizeGenerator;

	public Host() {
		prizeGenerator = BoxesHandler.getInstance();
	}

	public Host(final BoxesHandler prizeGenerator) {
		this.prizeGenerator = prizeGenerator;
	}

	@Override
	public int getSelection() {
		return chosenEmptyBoxNumber;
	}

	@Override
	public int selectOneBoxFromGame(final int... alreadySelectedBox) {
		final int prizeBox = prizeGenerator.findWhichBoxContainsPrize();
		final int emptyBox = findWhichBoxIsEmptyBox(prizeBox, alreadySelectedBox[0]);
		System.out.print(String.format(PROGRESS_MESSAGE, ACTOR_TYPE_HOST, emptyBox));
		return emptyBox;

	}
}
