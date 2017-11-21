package main.java.servers.abstraction.user;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractUserAccount {

	private String id;
	private String username;
	private Date registrationDate;
	
	private String accessToken;
	private String refreshToken;
	
	private String serverKey;
	
	public AbstractUserAccount() {
	}

	public AbstractUserAccount(String id, String username, Date registrationDate, String accessToken,
			String refreshToken, String serverKey) {
		this.id = id;
		this.username = username;
		this.registrationDate = registrationDate;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.serverKey = serverKey;
	}

	public String getServerKey() {
		return serverKey;
	}

	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@JsonIgnore
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@JsonIgnore
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
}
