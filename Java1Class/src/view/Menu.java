package view;

public abstract class Menu {
	public void displayMenu(){
		prompt = Prompt.SELECT_OPTION;
		moreInputNeeded = true;
	}
	public abstract void parseInput(String input);
	
	private Prompt prompt;
	protected void setPrompt(Prompt prompt){
		this.prompt = prompt;		
	}
	public void displayPrompt(){
		System.out.println(prompt);
	}
	private boolean moreInputNeeded;
	protected void setInputNeeded(boolean moreInputNeeded){
		this.moreInputNeeded = moreInputNeeded;
	}
	public boolean moreInputNeeded(){
		return moreInputNeeded;
	}
	private Menu nextMenu;
	protected void setNextMenu(Menu nextMenu){
		this.nextMenu = nextMenu;
	}
	public Menu getNextMenu(){
		return nextMenu;
	}
	/**
	 * Prompt and inputNeeded already set if method returns true.
	 * @param input
	 * @return true if input is null or empty
	 */
	public boolean nullOrEmpty(String input){
		
		if (input == null || input.length() < 1){
			prompt = Prompt.INVALID_INPUT;
			moreInputNeeded = true;
			return true;
		}
		else
			return false;
	}
}
