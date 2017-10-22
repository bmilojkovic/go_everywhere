package servers.abstraction.user;

import java.util.Collection;

public interface IUserService {
	
	IUserRepository getUserRepository();
	Collection<AbstractUserAccount> getFriends(User user);
	Collection<AbstractUserAccount> getFavouriteFriends(User user);
	Collection<AbstractUserAccount> getFriendsFromAccount(AbstractUserAccount account);
	
	Collection<AbstractUserAccount> getAccounts(User user);
	void addAccount(User user, AbstractUserAccount account);
}
