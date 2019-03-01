package Elements;

import FunctionLibrary.GetTheXpath;

public enum Elements implements GetTheXpath {
	LOGIN("login", "//button[.='Sign in']"), 
	SINGUP("signup","//button[.='Sign up']"), 
	EMAIL("email", "//input[@name='email']"), 
	PASSWORD("password", "//input[@name='password']"),
	CPASSWORD("cpassword","//input[@name='confirm']"), 
	CHECKBOX("checkbox","//input[@type='checkbox']"), 
	HAVEANACCOUNT("haveaccount","//button[.='Have an account?']"),
	FB("fb","//*[.='Sign in using social network']//*[@width='13px' and @height='22px']"),
	PROFILEICON("profic", "//div[@class='l-header-profile']//span[@class='ui-avatar__img default']"),
			//"//*[contains(concat(' ', @class, ' '), ' l-header-profile ')]"
			//+ "//*[contains(concat(' ', @class, ' '), ' bi-icon bi-avatar__icon ')]/*"),
	//PROFILEICON("profic","//*[contains(concat(' ', @class, ' '), ' bi-avatar bi-avatar--size-sm is-round ')]//*[@viewBox = '0 0 102 116']"),
	SINGOUT("singout", "//nav[@class='l-header-profile__nav']//span[.='Sign out']"),
	FBEMIAL("FBemail","//input[@id='email']"),
	FBPASSWORD("FBpassword","//input[@id='pass']"), 
	LOGINFB("loginFB","//input[@name='login']"),
	MATCHESPAGE("matchesPage","//a[text()='Matches' and @class='l-header-menu__link']"),
	LOGO("logo","//*[@alt='Betting Insider']"),
	CHAT("chat","//*[@class='bi-textarea']"),
	CHATBUTTON("chatBut","//*[@class='ui-icon w-chat-send__icon']");
	
	
	
	private final String name;
	private final String xpath;

	private Elements(String name, String xpath) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.xpath = xpath;
	}

	public String getXpath() {
		return xpath;
	}

	public static Elements getEntryForElementName(String fieldNameToFind) {
		for (Elements element : values()) {
			if (element.name.equals(fieldNameToFind)) {
				return element;
			}
		}
		throw new RuntimeException("Cannot find entry for fieldName: '"
				+ fieldNameToFind + "'");
	}
}
