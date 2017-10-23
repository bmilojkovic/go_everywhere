package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOpenGames(@PathParam("id") int lobbyId) throws UnirestException {
		String authHeader = headers.getHeaderString("Authorization");
		String gamesUrl = "https://online-go.com/api/v1/megames";
		
		HttpResponse<String> response = Unirest.get(gamesUrl)
							  				   .header("Authorization", authHeader)
							  				   .asString();
		return Response.ok(response.getBody()).build();
	}

}
