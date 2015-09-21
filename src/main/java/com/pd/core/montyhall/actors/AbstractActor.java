package com.pd.core.montyhall.actors;

public abstract class AbstractActor implements IActor {

	protected int chosenBoxNumber;

	@Override
	public int getSelection() {
		return chosenBoxNumber;
	}

}
