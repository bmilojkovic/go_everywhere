package main.java.servers.abstraction.user;

import java.util.List;

public class UserAccounts {
	private User user;
	private List<AbstractUserAccount> userAccounts;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<AbstractUserAccount> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(List<AbstractUserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}
}
