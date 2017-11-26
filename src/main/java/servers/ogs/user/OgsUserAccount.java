package main.java.servers.ogs.user;

import java.sql.Date;

import main.java.servers.abstraction.user.AbstractUserAccount;


public class OgsUserAccount extends AbstractUserAccount {
	
	private String userId;
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OgsUserAccount() {
		
	}

	public OgsUserAccount(String id, String username, Date registrationDate, String accessToken, String refreshToken,
			String serverKey, String userId) {
		super(id, username, registrationDate, accessToken, refreshToken, serverKey);
		// TODO Auto-generated constructor stub
		this.userId = userId;
	}

	@Override
	public String getServerKey() {
		return "ogs";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}
