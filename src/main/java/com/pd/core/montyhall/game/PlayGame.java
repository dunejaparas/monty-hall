package com.pd.core.montyhall.game;

import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_CONTESTANT;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_HOST;

import com.pd.core.montyhall.actors.*;
import com.pd.core.montyhall.prize.BoxesHandler;

public class PlayGame {
	private final Contestant contestant;
	private final Host tvHost;
	private final BoxesHandler prizeHandler;

	public PlayGame() {
		contestant = (Contestant) ActorFactory.getInstance().createActor(ACTOR_TYPE_CONTESTANT);
		tvHost = (Host) ActorFactory.getInstance().createActor(ACTOR_TYPE_HOST);
		prizeHandler = BoxesHandler.getInstance();
	}

	public PlayGame(final Contestant contestant, final Host tvHost, final BoxesHandler prizeHandler) {
		this.contestant = contestant;
		this.tvHost = tvHost;
		this.prizeHandler = prizeHandler;
	}

	public boolean processCurrentRound() {
		prizeHandler.initPrizeBoxesForTheGame();
		final int contestantSelection = contestant.selectOneBoxFromGame();
		final int[] selection = { contestantSelection };
		final int openedBox = tvHost.selectOneBoxFromGame(selection);
		return contestant.changeCurrentBoxForAnotherOne(openedBox);
	}
}
