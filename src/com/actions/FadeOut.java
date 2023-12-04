package com.actions;

public class FadeOut implements IAction{
	
	@Override
	public String getName() {
		return "FadeOut";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s()", getName());
	}

}
