package com.pd.core.montyhall.actors;

import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_CONTESTANT;
import static com.pd.core.montyhall.util.StringBundle.ACTOR_TYPE_HOST;

public enum ActorFactory {

	INSTANCE;

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
