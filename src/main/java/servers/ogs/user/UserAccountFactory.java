package main.java.servers.ogs.user;

import java.sql.Date;

import main.java.servers.abstraction.user.AbstractUserAccount;


public class UserAccountFactory {
	
	public AbstractUserAccount getUserAccount(String server, String id, String username, Date registrationDate, String accessToken, String refreshToken, String userId) {
		
		if (server.equals("ogs")) {
			return new OgsUserAccount(id, username, registrationDate, accessToken, refreshToken, server, userId);
		}
		
		return null;
		
	}

}
