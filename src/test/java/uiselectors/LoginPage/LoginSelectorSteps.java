package uiselectors.LoginPage;

public class LoginSelectorSteps {
	
	private String addbtn;
	private String submit;

	
	public LoginSelectorSteps(String addbtn, String submit)
	{
		this.addbtn = addbtn;
		this.submit = submit;
		
	}
	
	/**
	 * Retrieve open settings button
	 * @return
	 */

	public String getAddButton() {
		return addbtn;
	}

	/**
	 * Retrieve MockButton
	 * @return
	 */
	public String getSubmitButton() {
		return submit;
	}

	



}
