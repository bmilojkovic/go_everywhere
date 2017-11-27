package main.java.controllers;

import java.util.HashMap;
import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.models.Lobby;

@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}")
public class RTInfoController {
	
	@PathParam("serverID")
	private String serverID;

	@PathParam("accID")
	private String accID;
	
	@PathParam("roomID")
	private String roomID;

	
	@POST
	@Path("/game/{gameID}/join-game-chat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> joinGameChat(@PathParam("gameID") String gameID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("error","Invalid parameter");
		return map;
	}
	
	@POST
	@Path("/roomChat/{roomChatID}/join-room-chat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> joinRoomChat(@PathParam("roomChatID") String roomChatID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("error","Invalid parameter");
		return map;
	}
	
	@POST
	@Path("/game/{gameID}/join-game")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> joinGame(@PathParam("gameID") String gameID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("error","Invalid parameter");
		return map;
	}
}
