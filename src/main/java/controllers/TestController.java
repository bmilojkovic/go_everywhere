package main.java.controllers;

import java.util.concurrent.ExecutionException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import main.java.servers.ogs.authentification.OgsAuthProvider;
import main.java.utils.JWTTokenNeeded;
import main.java.utils.ServerResponse;



@Path("/test")
public class TestController {

	@Context
	HttpServletRequest request;
	@Context
	ServletContext ctx;
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		OgsAuthProvider ogsAuthProvider = new OgsAuthProvider();
		try {
			return ogsAuthProvider.asyncAuthorize("go_e_1", "qweqwe").get().getAccessToken();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "greska";
	}
	
	@GET
	@Path("/protected")
	@Produces(MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	public ServerResponse testProtectedRoute() {
		return new ServerResponse();
	}
}
