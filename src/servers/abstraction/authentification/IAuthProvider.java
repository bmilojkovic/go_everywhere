package servers.abstraction.authentification;

import java.util.concurrent.CompletableFuture;

import servers.abstraction.user.AbstractUserAccount;

public interface IAuthProvider<AbstractUserAccount> {
	  public CompletableFuture<Token> asyncAuthorize(String username, String password); 
	  public CompletableFuture<Token> asyncRefreshToken(AbstractUserAccount account); 
}
