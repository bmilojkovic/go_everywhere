package servers.ogs.authentification;

import java.util.concurrent.CompletableFuture;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import servers.abstraction.authentification.IAuthProvider;
import servers.abstraction.authentification.Token;
import servers.ogs.OgsConstants;
import servers.ogs.user.OgsUserAccount;

public class OgsAuthProvider implements IAuthProvider<OgsUserAccount> { 
	 
	  @Override 
	  public CompletableFuture<Token> asyncAuthorize(String username, String password) {
	    return CompletableFuture.supplyAsync(() -> {
	    	try {
				HttpResponse<JsonNode> response = Unirest.post("https://online-go.com/oauth2/token/")
				  .header("accept", "application/json")
				  .field("client_id", OgsConstants.CLIENT_ID)
				  .field("client_secret", OgsConstants.CLIENT_SECRET)
				  .field("grant_type", "password")
				  .field("username", username)
				  .field("password", password).asJson();
				
				if (response.getStatus() == 200) {
					String accessToken = response.getBody().getObject().getString("access_token");
					String refreshToken = response.getBody().getObject().getString("refresh_token");
					return new Token(accessToken, refreshToken);
				}
			} catch (UnirestException e) {
				return null;
			}
	    	return null;
	    }); 
	  } 
	 
	  @Override 
	  public CompletableFuture<Token> asyncRefreshToken(OgsUserAccount account) { 
		  return CompletableFuture.supplyAsync(() -> {
		    	try {
					HttpResponse<JsonNode> response = Unirest.post("https://online-go.com/oauth2/token/")
					  .header("accept", "application/json")
					  .field("client_id", OgsConstants.CLIENT_ID)
					  .field("client_secret", OgsConstants.CLIENT_SECRET)
					  .field("grant_type", "refresh_token")
					  .field("refresh_token", account.getRefreshToken()).asJson();
					
					if (response.getStatus() == 200) {
						String accessToken = response.getBody().getObject().getString("access_token");
						String refreshToken = response.getBody().getObject().getString("refresh_token");
						return new Token(accessToken, refreshToken);
					}
				} catch (UnirestException e) {
					return null;
				}
		    	return null;
		    }); 
	  } 
	 
	} 
