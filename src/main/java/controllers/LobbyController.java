package main.java.controllers;

import java.util.ArrayList;
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

@Path("server/{serverID}/acc/{accID}/lobby")
public class LobbyController {
	
	@PathParam("serverID")
	private String serverID;

	@PathParam("accID")
	private String accID;

	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> allLobies(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Lobby> lobbies = new ArrayList<Lobby>();
		Lobby lobby = new Lobby();
		lobby.setId("1");
		lobbies.add(lobby);
		map.put("lobbies", lobbies);
		return map;
	}
	
	@GET
	@Path("/{lobbyID}/rooms-to-join")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> RoomsToJoin(@PathParam("lobbyID") String lobbyID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Lobby> lobbies = new ArrayList<Lobby>();
		Lobby lobby = new Lobby();
		lobby.setId("1");
		lobbies.add(lobby);
		map.put("lobbies", lobbies);
		return map;
	}
	
	@GET
	@Path("/{lobbyID}/joined-rooms")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> JoinedRooms(@PathParam("lobbyID") String lobbyID){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Lobby> lobbies = new ArrayList<Lobby>();
		Lobby lobby = new Lobby();
		lobby.setId("1");
		lobbies.add(lobby);
		map.put("lobbies", lobbies);
		return map;
	}
}
