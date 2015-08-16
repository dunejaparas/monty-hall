package com.pd.core.montyhall;

import static com.pd.core.montyhall.util.StringBundle.*;

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

import com.pd.core.montyhall.game.PlayGame;

public class MontyHall {
	public static void main(final String[] args) {
		new MontyHall().beginSimulation();
	}

	private void beginSimulation() {
		int changedResultWon = 0;
		int changedResultLost = 0;
		for (int count = 0; count < 10000; count++) {
			final boolean isPrizeWonAfterChangeMind = playCurrentRound();
			System.out.print(String.format(PROGRESS_MESSAGE, "IsPrizeWon", isPrizeWonAfterChangeMind));
			if (isPrizeWonAfterChangeMind) {
				changedResultWon++;
			} else {
				changedResultLost++;
			}
			System.out.println();
		}
		System.out.println(GAME_END_TOTAL_WINS + changedResultWon);
		System.out.println(GAME_END_TOTAL_LOST + changedResultLost);
	}

	private boolean playCurrentRound() {
		final PlayGame game = new PlayGame();
		return game.processCurrentRound();
	}
}
