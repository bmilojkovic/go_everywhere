package controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utils.ServerResponse;

@Path("auth")
public class AuthController {

	@POST
	@Path("/fb-auth")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public ServerResponse fbAuthorize(@FormParam("code") String code) {
		//check fb code - if valid auth
		
		//for now code represents user_id
		
		// Exchanging Code for an Access Token
		//GET https://graph.facebook.com/v2.10/oauth/access_token?
		//   client_id={app-id}
		//   &redirect_uri={redirect-uri}
		//   &client_secret={app-secret}
		//   &code={code-parameter}
		return new ServerResponse().addData("test", "daf");
	}
	
}
