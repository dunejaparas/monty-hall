package com.pd.core.montyhall.actors;

import org.junit.Assert;
import org.junit.Test;

import com.pd.core.montyhall.util.StringBundle;

public class ActorFactoryTest {

	ActorFactory objectUnderTest = ActorFactory.getInstance();

	@Test
	public void testHostRequestCreatesHostObject() {
		final IActor createActor = objectUnderTest.createActor(StringBundle.ACTOR_TYPE_HOST);
		Assert.assertTrue(createActor instanceof Host);
	}

	@Test
	public void testHostRequestCreatesContestantObject() {
		final IActor createActor = objectUnderTest.createActor(StringBundle.ACTOR_TYPE_CONTESTANT);
		Assert.assertTrue(createActor instanceof Contestant);
	}

}
