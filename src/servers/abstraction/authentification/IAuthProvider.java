package servers.abstraction.authorization;

import servers.abstraction.user.AbstractUserAccount;

public interface IAuthProvider<AbstractUserAccount> {
	public String Authorize(String username, String password);
	public String RefreshToken(AbstractUserAccount account);
}
