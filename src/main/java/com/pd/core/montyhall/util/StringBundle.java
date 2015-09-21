package com.pd.core.montyhall.util;

public interface StringBundle {

	int TOTAL_SIMULATIONS = 10000;
	int[] GAME_BOX_NUMBERS = { 0, 1, 2 };

	String ACTOR_TYPE_CONTESTANT = "contestant";
	String ACTOR_TYPE_HOST = "host";
	String LOSSES = "losses";
	String WINS = "wins";
	String IS_PRIZE_WON = "IsPrizeWon";
	String PRIZE = "Prize";

	String GAME_END_TOTAL_WINS = "Total WINS after changing mind =";
	String GAME_END_TOTAL_LOST = "Total LOST after changing mind =";
	String GAME_END_RESULT = "Change of box by contestant results in more %s ";

	String PROGRESS_MESSAGE = "\t %s:  %s ";
	String ERROR_MSG_GAME_NOT_INITIALZED = "Game not initialzed yet, cannot set contestant selection.";
}
