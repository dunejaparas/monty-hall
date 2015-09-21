package com.pd.core.montyhall.game;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pd.core.montyhall.actors.Contestant;
import com.pd.core.montyhall.actors.Host;
import com.pd.core.montyhall.prize.BoxesHandler;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ BoxesHandler.class })
public class PlayGameTest {

	CurrentGame objectUnderTest;

	@Mock
	BoxesHandler mockedPrizeHandler;

	@Mock
	Contestant mockContestant;

	@Mock
	Host mockTvHost;

	@Before
	public void initTestingSetup() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new CurrentGame(mockContestant, mockTvHost, mockedPrizeHandler);
	}

	@Test
	public void test() {
		// prepare
		final int[] selection = { 0, 1, 2 };
		when(mockedPrizeHandler.initPrizeBoxesForTheGame()).thenReturn(selection[2]);
		when(mockContestant.selectOneBoxFromGame()).thenReturn(selection[0]);
		final int[] hostSelection = { 0 };
		when(mockTvHost.selectOneBoxFromGame(hostSelection)).thenReturn(selection[1]);

		// execute
		objectUnderTest.playRoundAndChangeSelection();

		// verify test conditions
		verify(mockedPrizeHandler, times(1)).initPrizeBoxesForTheGame();
		verify(mockContestant, times(1)).selectOneBoxFromGame();
		verify(mockTvHost, times(1)).selectOneBoxFromGame(2, 0);
	}
}
