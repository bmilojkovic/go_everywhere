package controllers;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



@Path("/test")
public class TestController {

	@Context
	HttpServletRequest request;
	@Context
	ServletContext ctx;
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() throws URISyntaxException {
		
		return "Hello";
	}
}
