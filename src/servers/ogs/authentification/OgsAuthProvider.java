package servers.ogs.authentification;

import java.util.concurrent.CompletableFuture;

import servers.abstraction.authentification.IAuthProvider;
import servers.ogs.user.OgsUserAccount;

public class OgsAuthProvider implements IAuthProvider<OgsUserAccount> { 
	 
	  @Override 
	  public CompletableFuture<String> asyncAuthorize(String username, String password) { 
	    return CompletableFuture.supplyAsync(() -> { 
	      return ""; 
	    }); 
	  } 
	 
	  @Override 
	  public CompletableFuture<String> asyncRefreshToken(OgsUserAccount account) { 
	    return CompletableFuture.supplyAsync(() -> { 
	      return ""; 
	    }); 
	  } 
	 
	} 
