package com.pd.core.montyhall.game;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pd.core.montyhall.actors.Contestant;
import com.pd.core.montyhall.actors.Host;
import com.pd.core.montyhall.prize.BoxesHandler;

public class PlayGameTest {

	PlayGame objectUnderTest;

	@Mock
	BoxesHandler mockedPrizeHandler;

	@Mock
	Contestant mockContestant;

	@Mock
	Host mockTvHost;

	@Before
	public void initTestingSetup() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new PlayGame(mockContestant, mockTvHost, mockedPrizeHandler);
	}

	@Test
	public void test() {
		// prepare
		final int[] selection = { 0, 1, 2 };
		stubVoid(mockedPrizeHandler).toReturn().on().initPrizeBoxesForTheGame();
		when(mockContestant.selectOneBoxFromGame()).thenReturn(selection[0]);
		final int[] hostSelection = { 0 };
		when(mockTvHost.selectOneBoxFromGame(hostSelection)).thenReturn(selection[1]);
		when(mockContestant.changeCurrentBoxForAnotherOne(selection[1])).thenReturn(false);

		// execute
		objectUnderTest.processCurrentRound();

		// verify test conditions
		verify(mockedPrizeHandler, times(1)).initPrizeBoxesForTheGame();
		verify(mockContestant, times(1)).selectOneBoxFromGame();
		verify(mockTvHost, times(1)).selectOneBoxFromGame(0);
		verify(mockContestant, times(1)).changeCurrentBoxForAnotherOne(selection[1]);
	}
}
