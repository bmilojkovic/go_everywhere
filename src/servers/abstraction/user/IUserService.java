package servers.abstraction.user;

import java.util.Collection;

public interface IUserService {
	
	IUserRepository getUserRepository();
	Collection<UserAccounts> getFriends(User user);
	Collection<UserAccounts> getFavouriteFriends(User user);
	Collection<UserAccounts> getFriendsFromAccount(AbstractUserAccount account);
	
	Collection<AbstractUserAccount> getAccounts(User user);
	void addAccount(User user, AbstractUserAccount account);
}
