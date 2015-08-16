package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_CONTESTANT;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_HOST;

public class ActorFactory {

	private static ActorFactory instance = null;
	private static Object lockObject = new Object();

	public static ActorFactory getInstance() {
		if (instance == null) {
			synchronized (lockObject) {
				if (instance == null) {
					instance = new ActorFactory();
				}
			}
		}
		return instance;
	}

	public IActor createActor(final String userType) {
		IActor actor = null;
		switch (userType) {
		case ACTOR_TYPE_HOST:
			actor = new Host();
			break;
		case ACTOR_TYPE_CONTESTANT:
			actor = new Contestant();
			break;
		}
		return actor;
	}
}
