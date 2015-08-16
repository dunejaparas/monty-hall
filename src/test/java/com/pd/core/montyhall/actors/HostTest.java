package com.pd.core.montyhall.actors;

import static org.mockito.Mockito.when;

import org.junit.*;
import org.mockito.*;

import com.pd.core.montyhall.prize.BoxesHandler;

public class HostTest {

	Host objectUnderTest;

	@Mock
	BoxesHandler mockBoxesHandler = Mockito.mock(BoxesHandler.class);

	@Before
	public void initTestingSetup() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new Host(mockBoxesHandler);
	}

	@Test
	public void selectOneBoxFromGameOptionOne() {
		// prepare
		final int alreadySelectedBox = 0;
		final int prizeContainingBox = 1;
		final int expected = 2;
		commonTestPart(alreadySelectedBox, prizeContainingBox, expected);
	}

	@Test
	public void selectOneBoxFromGameOptionTwo() {
		// prepare
		final int alreadySelectedBox = 2;
		final int prizeContainingBox = 1;
		final int expected = 0;
		commonTestPart(alreadySelectedBox, prizeContainingBox, expected);
	}

	private void commonTestPart(final int alreadySelectedBox, final int prizeContainingBox, final int expected) {
		// prepare
		when(mockBoxesHandler.findWhichBoxContainsPrize()).thenReturn(prizeContainingBox);
		// execute
		final int emptyBox = objectUnderTest.selectOneBoxFromGame(alreadySelectedBox);
		// verify
		Assert.assertEquals(expected, emptyBox);
	}

}
