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

import main.java.models.Chat;
import main.java.models.Lobby;

@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/rooms/{roomID}")
public class RoomController {
	
	@PathParam("serverID")
	private String serverID;

	@PathParam("accID")
	private String accID;
	
	@PathParam("roomID")
	private String roomID;

	
	@GET
	@Path("/joined-chats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> joinedChats(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Chat> chats = new ArrayList<Chat>();
		Chat chat = new Chat();
		chat.setId("1");
		chats.add(chat);
		map.put("chats", chats);
		return map;
	}
	
	@GET
	@Path("/chats-to-join")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> ChatsToJoin(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Chat> chats = new ArrayList<Chat>();
		Chat chat = new Chat();
		chat.setId("1");
		chats.add(chat);
		map.put("chats", chats);
		return map;
	}
	
}
