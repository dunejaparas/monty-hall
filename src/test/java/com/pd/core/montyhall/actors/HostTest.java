package com.pd.core.montyhall.actors;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.pd.core.montyhall.prize.BoxesHandler;
import com.pd.core.montyhall.util.StringBundle;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ BoxesHandler.class })
public class HostTest {

	Host objectUnderTest;

	@Mock
	BoxesHandler mockBoxesHandler;

	@Before
	public void initTestingSetup() {
		MockitoAnnotations.initMocks(this);
		mockBoxesHandler = Mockito.mock(BoxesHandler.class);
		objectUnderTest = (Host) ActorFactory.INSTANCE.createActor(StringBundle.ACTOR_TYPE_HOST);
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
		// execute
		final int[] values = { alreadySelectedBox, prizeContainingBox };
		final int emptyBox = objectUnderTest.selectOneBoxFromGame(values);
		// verify
		Assert.assertEquals(expected, emptyBox);
	}

}
