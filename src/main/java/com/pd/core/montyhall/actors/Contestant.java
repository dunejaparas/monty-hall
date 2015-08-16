package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.MontyHallUtil.generateRandomNumberBetweenRange;
import static com.pd.core.montyhall.util.MontyHallUtil.getChangedBoxOfContestant;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_CONTESTANT;
import static com.pd.core.montyhall.util.StringBundle.PROGRESS_MESSAGE;

import com.pd.core.montyhall.prize.BoxesHandler;

public class Contestant implements IActor {

	private int chosenBoxNumber;
	private boolean isWinner;
	BoxesHandler prizeGenerator;

	public Contestant() {
		prizeGenerator = BoxesHandler.getInstance();
	}

	@Override
	public int getSelection() {
		return chosenBoxNumber;
	}

	@Override
	public int selectOneBoxFromGame(final int... options) {
		chosenBoxNumber = generateRandomNumberBetweenRange();
		System.out.print(String.format(PROGRESS_MESSAGE, ACTOR_TYPE_CONTESTANT, chosenBoxNumber));

		return chosenBoxNumber;
	}

	public boolean changeCurrentBoxForAnotherOne(final int openedBox) {
		final int lastBoxRemaining = getChangedBoxOfContestant(openedBox, chosenBoxNumber);
		this.isWinner = prizeGenerator.setContestantNewSelection(lastBoxRemaining);
		return this.isWinner;
	}

	public boolean isWinner() {
		return this.isWinner;
	}

}