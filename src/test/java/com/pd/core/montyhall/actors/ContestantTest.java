package com.pd.core.montyhall.actors;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import com.pd.core.montyhall.prize.BoxesHandler;
import com.pd.core.montyhall.util.MontyHallUtil;
import com.pd.core.montyhall.util.StringBundle;

public class ContestantTest {

	Contestant objectUnderTest;

	@Mock
	BoxesHandler prizeGenerator;

	@Before
	public void executeBeforeEach() {
		objectUnderTest = (Contestant) ActorFactory.getInstance().createActor(StringBundle.ACTOR_TYPE_CONTESTANT);
	}

	@Test
	public void testSelectOneBoxFromGame() {
		for (int index = 0; index < 100; index++) {
			final int value = objectUnderTest.selectOneBoxFromGame();
			assertTrue(String.format(StringBundle.JUNIT_FAILED_ITERATION_MESSAGE, value, index),
					MontyHallUtil.MIN_VALUE <= value && value <= MontyHallUtil.MAX_VALUE);
		}
	}

	@Test
	public void testChangeCurrentBoxForAnotherOne() {
		MockitoAnnotations.initMocks(this);
		Whitebox.setInternalState(objectUnderTest, "prizeGenerator", prizeGenerator);
		objectUnderTest.changeCurrentBoxForAnotherOne(1);
		verify(prizeGenerator, times(1)).setContestantNewSelection(2);
	}

	@Test
	public void testChangeCurrentBoxForAnotherOne_SecondTest() {
		MockitoAnnotations.initMocks(this);
		Whitebox.setInternalState(objectUnderTest, "prizeGenerator", prizeGenerator);
		objectUnderTest.changeCurrentBoxForAnotherOne(2);
		verify(prizeGenerator, times(1)).setContestantNewSelection(1);
	}

}
