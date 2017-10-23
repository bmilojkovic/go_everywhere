package servers.abstraction.user;

import java.sql.Date;

public abstract class User extends AbstractUserAccount {

	public User(String id, String username, Date registrationDate, String accessToken, String refreshToken,
			String serverKey) {
		super(id, username, registrationDate, accessToken, refreshToken, serverKey);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getServerKey() {
		return "go-everywhere";
	}
	
	
	
}
