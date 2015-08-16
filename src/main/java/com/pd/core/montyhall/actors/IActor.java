package com.pd.core.montyhall.actors;

public interface IActor {
	public int getSelection();

	public int selectOneBoxFromGame(int... options);
}
