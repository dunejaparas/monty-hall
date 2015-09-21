package com.pd.core.montyhall;

import static com.pd.core.montyhall.util.StringBundle.*;

import com.pd.core.montyhall.actors.*;

/*
	Month Hall Problem
	The problem is a well-known puzzle that you can read more about at
		http://en.wikipedia.org/wiki/Monty_Hall_problem .

	Save reading the link if you do not want to know the answer until you have solved the problem.

	Problem description:
			Assume that you are attending a TV show where you can win money by picking the right box.
			The game show host shows you three boxes explaining that the money is in one of the boxes.
			He asks you to pick one of them without opening it.

			After you have picked one of the boxes he opens one of the other two boxes which is empty.
			Now he turns to you and asks, do you want to change your mind, picking the remaining box?

	Your task:
			Write a program in Java randomly simulating this event over and over again in the quest of
			answering following question. Do I stand a better chance to win if I change my mind?

	Maven should be used. Send me your code in a zipped but renamed file removing the �.zip� suffix.
	Else the spam filters may catch the e-mail.

 */

import com.pd.core.montyhall.game.CurrentGame;
import com.pd.core.montyhall.prize.BoxesHandler;

public class MontyHallSimulationDemo {

	private final ActorFactory actorFactory = ActorFactory.INSTANCE;

	public static void main(final String[] args) {
		new MontyHallSimulationDemo().beginSimulation();
	}

	private void beginSimulation() {
		int countChangedWon = 0;
		int countChangedLost = 0;
		for (int count = 0; count < TOTAL_SIMULATIONS; count++) {
			final boolean isPrizeWonAfterChangeMind = playNextRound();
			System.out.print(String.format(PROGRESS_MESSAGE, IS_PRIZE_WON, isPrizeWonAfterChangeMind));
			if (isPrizeWonAfterChangeMind) {
				countChangedWon++;
			} else {
				countChangedLost++;
			}
			System.out.println();
		}
		System.out.println(GAME_END_TOTAL_WINS + countChangedWon);
		System.out.println(GAME_END_TOTAL_LOST + countChangedLost);
		if (countChangedLost < countChangedWon) {
			System.out.println(String.format(GAME_END_RESULT, WINS));
		} else {
			System.out.println(String.format(GAME_END_RESULT, LOSSES));
		}
	}

	private boolean playNextRound() {
		final Contestant contestant = (Contestant) actorFactory.createActor(ACTOR_TYPE_CONTESTANT);
		final Host tvHost = (Host) actorFactory.createActor(ACTOR_TYPE_HOST);

		final CurrentGame game = new CurrentGame(contestant, tvHost, BoxesHandler.INSTANCE);
		return game.playRoundAndChangeSelection();
	}
}
