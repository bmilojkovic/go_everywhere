package controllers;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Path("/lobby/{id}")
public class Lobby {

	@Context
	HttpServletRequest request;
	
	@Context 
	HttpHeaders headers;
	
	@Path("/games/open")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOpenGames(@PathParam("id") int lobbyId) throws UnirestException {
		String gamesUrl = "https://online-go.com/api/v1/megames";
		String authHeader = headers.getHeaderString("Authorization");
		
		HttpResponse<String> jsonResponse = Unirest.post(gamesUrl)
									               .header("Authorization", authHeader)
									               .field("client_id", "eEMzUcZLmQmfjfoNO4bEJZOqC2K85eivXiL1u9kl")
									               .field("client_secret", "yv6PY85TyGbCQJ6a8mL0eQwCZhPDrMgbpCVlbAIFSFGTK0FgEASiaRkKaxYKBToOlYO3TZi7w5Kc6EbTH8kvONsqgc7SuZdfOSoqfBnLCfVEppiSyyYXsCkVKCxfvXXj")
									               .field("username", "mytestusername")
									               .field("password", "dusan4323")
									               .field("grant_type", "password")
									               .asString();
		
		return Response.ok(jsonResponse.getBody()).build();
	}

}
