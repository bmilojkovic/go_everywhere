package servers.abstraction.authentification;

import java.util.concurrent.CompletableFuture;

import servers.abstraction.user.AbstractUserAccount;

public interface IAuthProvider<AbstractUserAccount> {
	  public CompletableFuture<String> asyncAuthorize(String username, String password); 
	  public CompletableFuture<String> asyncRefreshToken(AbstractUserAccount account); 
}
