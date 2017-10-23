package servers.abstraction.user;

import java.util.Collection;

import servers.abstraction.utils.IRepository;

public interface IUserRepository extends IRepository<User, String> {
	/*
	 * Search by username
	 */
	Collection<User> search(String s);
	
	Collection<AbstractUserAccount> getUserAccounts(String id);
	
	void addUserAccount(String userId , AbstractUserAccount userAccount);
	
	void deleteUserAccount(String userId, String accountId);
}