package com.pd.core.montyhall.prize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pd.core.montyhall.util.MontyHallUtil;

@RunWith(PowerMockRunner.class)
public class BoxesHandlerTest {

	BoxesHandler objectUnderTest = BoxesHandler.getInstance();

	private void commonPartInitMethod(final int value) {
		PowerMockito.mockStatic(MontyHallUtil.class);
		PowerMockito.when(MontyHallUtil.generateRandomNumberBetweenRange()).thenReturn(value);
		objectUnderTest.initPrizeBoxesForTheGame();
		Assert.assertEquals(value, objectUnderTest.findWhichBoxContainsPrize());
	}

	@PrepareForTest({ MontyHallUtil.class })
	@Test
	public void testInitSetsCorrectBoxAsWinner() {
		commonPartInitMethod(0);
		commonPartInitMethod(1);
		commonPartInitMethod(2);
	}

	@Test(expected = NullPointerException.class)
	public void test_setContestantNewSelection_WhenNotInit() {
		objectUnderTest.setContestantNewSelection(0);
	}

}
