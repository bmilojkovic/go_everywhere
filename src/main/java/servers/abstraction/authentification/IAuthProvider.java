package main.java.servers.abstraction.authentification;

import java.util.concurrent.CompletableFuture;


public interface IAuthProvider<AbstractUserAccount> {
	  public CompletableFuture<Token> asyncAuthorize(String username, String password); 
	  public CompletableFuture<Token> asyncRefreshToken(AbstractUserAccount account); 
}
