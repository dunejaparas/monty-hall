package com.pd.core.montyhall.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontyHallUtilTest {
	String JUNIT_FAILED_ITERATION_MESSAGE = "Failed for value: %s in iteration %s";

	@Test
	public void testGenerateRandomNumberAreBetweenRange() {
		final int TOTAL_RE_RUN = 100;
		for (int index = 0; index < TOTAL_RE_RUN; index++) {
			final int value = GameUtil.selectOneOfThreeBox();
			if (value < StringBundle.GAME_BOX_NUMBERS[0] || StringBundle.GAME_BOX_NUMBERS[2] < value) {
				// just to enure the String.format is called only when we have
				// fail
				assertTrue(String.format(JUNIT_FAILED_ITERATION_MESSAGE, value, index), false);
			}
		}
	}

	@Test
	public void testFindWhichBoxIsEmptyBox() {
		int value = GameUtil.getEmptyBox(0, 1);
		assertTrue(value == 2);
		value = GameUtil.getEmptyBox(2, 1);
		assertTrue(value == 0);
		value = GameUtil.getEmptyBox(0, 2);
		assertTrue(value == 1);
	}

	@Test
	public void testChangedBoxOfContestant() {
		int value = GameUtil.getChangedBoxOfContestant(0, 1);
		assertTrue(value == 2);
		value = GameUtil.getChangedBoxOfContestant(2, 1);
		assertTrue(value == 0);
		value = GameUtil.getChangedBoxOfContestant(0, 2);
		assertTrue(value == 1);
	}
}
