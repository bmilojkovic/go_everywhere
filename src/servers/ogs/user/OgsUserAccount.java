package servers.ogs.user;

import java.sql.Date;

import servers.abstraction.user.AbstractUserAccount;

public class OgsUserAccount extends AbstractUserAccount {
	
	private String userId;
	
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
