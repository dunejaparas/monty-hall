package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.GameUtil.getEmptyBox;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_HOST;
import static com.pd.core.montyhall.util.StringBundle.PROGRESS_MESSAGE;

public class Host extends AbstractActor {

	@Override
	public int selectOneBoxFromGame(final int... alreadySelectedBox) {
		final int emptyBox = getEmptyBox(alreadySelectedBox[0], alreadySelectedBox[1]);
		System.out.print(String.format(PROGRESS_MESSAGE, ACTOR_TYPE_HOST, emptyBox));
		return emptyBox;

	}
}
