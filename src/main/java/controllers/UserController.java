package main.java.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.models.Lobby;
import main.java.servers.ogs.user.OgsUserAccount;

@Path("user/server/{serverID}")
public class UserController {
	
	@PathParam("serverID")
	private String serverID;
	
	@POST
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> test(HashMap<String,Object> pera){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("error","OGS account already exists for this user profile. Please use modify URL: acc/modify");
		return map;
	}
	
	// Here is used user info, later if there is system which will provide logging only with account ID, 
	// this method should be changed, and connected tests.
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response login(HashMap<String,String> userInfo){
		HashMap<String, Object> map = new HashMap<String,Object>();
		return Response.status(Response.Status.OK).entity(map).build();
	}
	
	@GET
	@Path("/friends")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getFriends(){
		return null;

	}
	
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> getAccounts(){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("error","OGS account already exists for this user profile. Please use modify URL: acc/modify");
		ArrayList<OgsUserAccount> accs = new ArrayList<OgsUserAccount>();
		OgsUserAccount acc = new OgsUserAccount();
		acc.setId("5");
		//accs.add(acc);
		map.put("accounts",accs);
		return map;
	}
	
	@POST
	@Path("/create-acc")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> createAcc(HashMap<String,String> userInfo){
		return null;
	}
	
	@POST
	@Path("/add-acc")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAcc(HashMap<String,String> userInfo){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("error","OGS account already exists for this user profile. Please use modify URL: acc/modify");
		return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
	}
	
	@POST
	@Path("/modify-acc")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyAcc(HashMap<String,String> userInfo){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("error","OGS account already exists for this user profile. Please use modify URL: acc/modify");
		return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
	}
	
	@GET
	@Path("/remove-acc/{accID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeAcc(@PathParam("accID")String accID){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("error","OGS account already exists for this user profile. Please use modify URL: acc/modify");
		return Response.status(Response.Status.BAD_REQUEST).entity(map).build();
	}
}
