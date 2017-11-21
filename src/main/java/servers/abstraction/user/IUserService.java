package main.java.servers.abstraction.user;

import java.util.Collection;

public interface IUserService {
	
	Collection<UserAccounts> getFriends(User user);
	Collection<UserAccounts> getFavouriteFriends(User user);
	Collection<UserAccounts> getFriendsFromAccount(AbstractUserAccount account);
	
	Collection<AbstractUserAccount> getAccounts(User user);
	void addAccount(User user, AbstractUserAccount account);
	
}
