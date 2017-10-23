package servers.ogs.user;

import java.sql.Date;

import servers.abstraction.user.AbstractUserAccount;

public class OgsUserAccount extends AbstractUserAccount {

	public OgsUserAccount(String id, String username, Date registrationDate, String accessToken, String refreshToken,
			String serverKey) {
		super(id, username, registrationDate, accessToken, refreshToken, serverKey);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getServerKey() {
		return "ogs";
	}

	
	
}
