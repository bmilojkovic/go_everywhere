package main.java.controllers;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.java.core.GoEverywhereApp;
import main.java.servers.abstraction.user.User;
import main.java.servers.go_everywhere.UserRepository;
import main.java.utils.ServerResponse;

@Path("auth")
public class AuthController {
	
	private UserRepository userRepository = new UserRepository();

	@POST
	@Path("/fb-auth")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public ServerResponse fbAuthorize(@FormParam("code") String code) throws JsonProcessingException {
		//check fb code - if valid auth
		
		//for now code represents user_id
		
		// Exchanging Code for an Access Token
		//GET https://graph.facebook.com/v2.10/oauth/access_token?
		//   client_id={app-id}
		//   &redirect_uri={redirect-uri}
		//   &client_secret={app-secret}
		//   &code={code-parameter}
		try {
			User user = userRepository.read(code);
			String accessToken = issueToken(user);
			return new ServerResponse()
					.addData("accessToken", accessToken)
					.addData("user", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ServerResponse().addError("output", "User does not exists!");
		}
	}
	
	private String issueToken(User user) throws JsonProcessingException {
        String jwtToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer("goeverywhere.com")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 10800000))
                .signWith(SignatureAlgorithm.HS256, Base64.getDecoder().decode(GoEverywhereApp.secretKey))
                .compact();
        return jwtToken;
    }
	
}
