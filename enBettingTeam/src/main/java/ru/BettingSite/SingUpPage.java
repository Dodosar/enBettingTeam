package ru.BettingSite;

public interface SingUpPage {
	public Page isSelectedCheckbox(String element);
	
	public PageSingUp typeInThefield(String element,String textforlements);
	
	public boolean CheckPopUpMessage(String element);
}
