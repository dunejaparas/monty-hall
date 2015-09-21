package com.pd.core.montyhall.game;

import com.pd.core.montyhall.actors.Contestant;
import com.pd.core.montyhall.actors.Host;
import com.pd.core.montyhall.prize.BoxesHandler;

public class CurrentGame {
	private final Contestant contestant;
	private final Host tvHost;
	private final BoxesHandler boxesHandler;

	public CurrentGame(final Contestant contestant, final Host tvHost, final BoxesHandler prizeHandler) {
		this.contestant = contestant;
		this.tvHost = tvHost;
		this.boxesHandler = prizeHandler;
	}

	public boolean playRoundAndChangeSelection() {

		final int winningBoxNumber = boxesHandler.initPrizeBoxesForTheGame();
		final int contestantSelection = contestant.selectOneBoxFromGame();
		final int[] alreadySelectedBox = { winningBoxNumber, contestantSelection };
		final int openedBox = tvHost.selectOneBoxFromGame(alreadySelectedBox);
		return winningBoxNumber == contestant.getNewBoxNumber(openedBox);
	}
}
