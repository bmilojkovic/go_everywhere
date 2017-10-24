package servers.ogs.user;

import java.sql.Date;

import servers.abstraction.user.AbstractUserAccount;

public class UserAccountFactory {
	
	public AbstractUserAccount getUserAccount(String server, String id, String username, Date registrationDate, String accessToken, String refreshToken) {
		
		if (server.equals("ogs")) {
			return new OgsUserAccount(id, username, registrationDate, accessToken, refreshToken, server);
		}
		
		return null;
		
	}

}
