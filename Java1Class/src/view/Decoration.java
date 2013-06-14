package view;

public enum Decoration {
	DIVIDER("*********************************"),
	SEPARATOR("--------------------------------"),
	INDENT("    ");
	
	private String decoration;
	
	Decoration(String decoration){
		this.decoration = decoration;
	}
	@Override
	public String toString(){
		return decoration;
	}

}
