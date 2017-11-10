package servers.abstraction.user;

import java.sql.SQLException;
import java.util.Collection;

import servers.abstraction.utils.IRepository;

public interface IUserRepository extends IRepository<User, String> {
	/*
	 * Search by username
	 */
	Collection<User> search(String s) throws SQLException;
	
	Collection<AbstractUserAccount> getUserAccounts(String id) throws SQLException;
	
	void addUserAccount(String userId , AbstractUserAccount userAccount) throws SQLException;
	
	void deleteUserAccount(String userId, String accountId, String serverId) throws SQLException;
}