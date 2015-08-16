package com.pd.core.montyhall.box;

public class Box {
	private boolean isPrizeWinningBox;

	public Box(boolean prize) {
		this.isPrizeWinningBox = prize;
	}

	public boolean isPrizeWinningBox() {
		return isPrizeWinningBox;
	}

	public void setPrizeWinningBox(boolean isPrize) {
		this.isPrizeWinningBox = isPrize;
	}
}
