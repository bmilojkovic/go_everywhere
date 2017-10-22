package servers.abstraction.user;

import java.util.Collection;

import servers.abstraction.utils.IRepository;

public interface IUserRepository extends IRepository<User, String> {
	Collection<User> usernameStartsWith(String username);
	Collection<AbstractUserAccount> getUserAccounts(String id);
	
	void addUserAccount(String userId , AbstractUserAccount userAccount);
	void deleteUserAccoutn(String userId, String accountId);
}