package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.GameUtil.getChangedBoxOfContestant;
import static com.pd.core.montyhall.util.GameUtil.selectOneOfThreeBox;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_CONTESTANT;
import static com.pd.core.montyhall.util.StringBundle.PROGRESS_MESSAGE;

public class Contestant extends AbstractActor {

	@Override
	public int selectOneBoxFromGame(final int... options) {
		chosenBoxNumber = selectOneOfThreeBox();
		System.out.print(String.format(PROGRESS_MESSAGE, ACTOR_TYPE_CONTESTANT, chosenBoxNumber));
		return chosenBoxNumber;
	}

	public int getNewBoxNumber(final int openedBox) {
		return getChangedBoxOfContestant(openedBox, chosenBoxNumber);
	}
}