package servers.abstraction.user;

import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	}
	
	
}
