package servers.abstraction.user;

import java.sql.Date;

public class User extends AbstractUserAccount {
	
	private String pictureUrl;
	private String firstName;
	private String lastName;

	public User(String id, String username, Date registrationDate, String accessToken, String refreshToken,
			String serverKey, String pictureUrl, String firstName, String lastName) {
		super(id, username, registrationDate, accessToken, refreshToken, serverKey);
		// TODO Auto-generated constructor stub
		this.pictureUrl = pictureUrl;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String getServerKey() {
		return "go-everywhere";
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	
	
}
