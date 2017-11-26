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

import main.java.models.Board;
import main.java.models.Game;
import main.java.models.GameChat;
import main.java.models.Lobby;

@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/rooms/{roomID}")
public class GameController {
	
	@PathParam("serverID")
	private String serverID;

	@PathParam("accID")
	private String accID;
	
	@PathParam("roomID")
	private String roomID;

	
	@GET
	@Path("/open-games")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> openGames(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Game> games = new ArrayList<Game>();
		Game game = new Game();
		game.setId("1");
		games.add(game);
		map.put("games", games);
		return map;
	}
	
	@GET
	@Path("/games-in-progress")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> gamesInProgress(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Game> games = new ArrayList<Game>();
		Game game = new Game();
		game.setId("1");
		games.add(game);
		map.put("games", games);
		return map;
	}
	
	@GET
	@Path("/my-active-games")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> myActiveGames(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Game> games = new ArrayList<Game>();
		Game game = new Game();
		game.setId("1");
		games.add(game);
		map.put("games", games);
		return map;
	}
	
	@GET
	@Path("/game-history")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> gameHistory(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<Game> games = new ArrayList<Game>();
		Game game = new Game();
		game.setId("1");
		games.add(game);
		map.put("games", games);
		return map;
	}
	
	@POST
	@Path("/post-game")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postGame(Game game){
		return "11";
	}
	
	@POST
	@Path("/game/{gameID}/start-review")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String startReview(@PathParam("gameID") String gameID){
		return "1";
	}
	
	@GET
	@Path("/game/{gameID}/game-chats")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> gameChats(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<GameChat> chats = new ArrayList<GameChat>();
		GameChat chat = new GameChat();
		chat.setId("1");
		chats.add(chat);
		map.put("chats", chats);
		return map;
	}
	
	@GET
	@Path("/game/{gameID}/game-info")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Game gameInfo(){
		Game game = new Game();
		game.setId("1");
		return game;
	}
	
	@GET
	@Path("/game/{gameID}/game-estimated-score")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board getEstimatedScore(){
		Board board = new Board();
		board.setId("1");
		return board;
	}
}
