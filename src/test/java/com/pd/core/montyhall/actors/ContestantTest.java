package com.pd.core.montyhall.actors;

import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.pd.core.montyhall.util.GameUtil;
import com.pd.core.montyhall.util.StringBundle;

@SuppressWarnings("static-access")

public class ContestantTest {

	Contestant objectUnderTest;

	@Mock
	GameUtil helper;

	@Before
	public void executeBeforeEach() {
		objectUnderTest = (Contestant) ActorFactory.INSTANCE.createActor(StringBundle.ACTOR_TYPE_CONTESTANT);
	}

	@Test
	public void testChangeCurrentBoxForAnotherOne() {
		MockitoAnnotations.initMocks(this);

		objectUnderTest.getNewBoxNumber(1);
		Mockito.verify(helper, times(1)).getChangedBoxOfContestant(1, 0);

	}
}
