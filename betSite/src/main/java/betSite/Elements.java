package betSite;


public enum Elements implements GetTheXpath{
	LOGIN("login","//button[.='Sign in']"),
	SINGUP("signup", "//button[.='Sign up']"),
	EMAIL("email","//input[@name='email']"),
	PASSWORD("password","//input[@name='password']"),
	CPASSWORD("cpassword","//input[@name='confirm']"),
	CHECKBOX("checkbox","//input[@type='checkbox']"),
	POPUPMESSAGE("popup","/html/body/div[4]/div[1]/div/div/div/div/form/div[1]");
	
	
	private final String name;
	private final String xpath;
	
	private Elements(String name,String xpath) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.xpath = xpath;
	}
	
	public String getXpath(){
		return xpath;
	}
	
	public static Elements getEntryForElementName(String fieldNameToFind) {
        for (Elements element : values()) {
            if (element.name.equals(fieldNameToFind)) {
                return element;
            }
        }
        throw new RuntimeException("Cannot find entry for fieldName: '" + fieldNameToFind + "'");
    }
}
	

