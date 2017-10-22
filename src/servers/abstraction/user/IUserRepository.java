package servers.abstraction.user;

import java.util.Collection;

import servers.abstraction.utils.IRepository;

public interface IUserRepository extends IRepository<User, String> {
	/*
	 * Search by username
	 */
	Collection<User> search(String s);
	
	Collection<UserAccounts> getUserAccounts(String id);
	
	void addUserAccount(String userId , AbstractUserAccount userAccount);
	
	void deleteUserAccoutn(String userId, String accountId);
}