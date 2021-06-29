package testdata.LoginPage;

public class LoginTestData {
	
	private String username;
	private String password;

	
	public LoginTestData(String username, String password)
	{
		this.username = username;
		this.password = password;
		
	}
	
	/**
	 * Retrieve username
	 * @return
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * Retrieve password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	



}
