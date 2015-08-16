package com.pd.core.montyhall.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MontyHallUtilTest {

	@Test
	public void testGenerateRandomNumberAreBetweenRange() {
		for (int index = 0; index < 100; index++) {
			final int value = MontyHallUtil.generateRandomNumberBetweenRange();
			assertTrue(String.format(StringBundle.JUNIT_FAILED_ITERATION_MESSAGE, value, index),
					MontyHallUtil.MIN_VALUE <= value && value <= MontyHallUtil.MAX_VALUE);
		}
	}

	@Test
	public void testFindWhichBoxIsEmptyBox() {
		int value = MontyHallUtil.findWhichBoxIsEmptyBox(0, 1);
		assertTrue(value == 2);
		value = MontyHallUtil.findWhichBoxIsEmptyBox(2, 1);
		assertTrue(value == 0);
		value = MontyHallUtil.findWhichBoxIsEmptyBox(0, 2);
		assertTrue(value == 1);
	}

	@Test
	public void testChangedBoxOfContestant() {
		int value = MontyHallUtil.getChangedBoxOfContestant(0, 1);
		assertTrue(value == 2);
		value = MontyHallUtil.getChangedBoxOfContestant(2, 1);
		assertTrue(value == 0);
		value = MontyHallUtil.getChangedBoxOfContestant(0, 2);
		assertTrue(value == 1);
	}
}
