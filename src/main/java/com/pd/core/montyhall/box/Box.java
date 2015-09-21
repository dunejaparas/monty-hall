package com.pd.core.montyhall.box;

public final class Box {
	private boolean isPrizeWinningBox;

	public Box(final boolean prize) {
		this.isPrizeWinningBox = prize;
	}

	public boolean isPrizeWinningBox() {
		return isPrizeWinningBox;
	}

	public void setPrizeWinningBox(final boolean isPrize) {
		this.isPrizeWinningBox = isPrize;
	}
}
