package com.pd.core.montyhall.prize;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pd.core.montyhall.util.GameUtil;

@RunWith(PowerMockRunner.class)
public class BoxesHandlerTest {

	BoxesHandler objectUnderTest = BoxesHandler.INSTANCE;

	private void commonPartInitMethod(final int value) {
		PowerMockito.mockStatic(GameUtil.class);
		PowerMockito.when(GameUtil.selectOneOfThreeBox()).thenReturn(value);
		final int prizeBoxNum = objectUnderTest.initPrizeBoxesForTheGame();
		Assert.assertEquals(value, prizeBoxNum);
	}

	@PrepareForTest({ GameUtil.class })
	@Test
	public void testInitSetsCorrectBoxAsWinner() {
		commonPartInitMethod(0);
		commonPartInitMethod(1);
		commonPartInitMethod(2);
	}
}
