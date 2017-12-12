package model;

import java.util.List;import main.java.controllers.GameController;
import model.game.Game;

public class Room {
	
	private String id;
	private List<Chat> chats;
	private List<Game> active_games; //Games that you can spectate OGS(games that are displayed if you are not logged in)
	private List<Game> open_games; //Games that you can join OGS(challenges)
	
	
	public Room(String id, List<Chat> chats, List<Game> active_games, List<Game> open_games) {
		super();
		this.id = id;
		this.chats = chats;
		this.active_games = active_games;
		this.open_games = open_games;
	}
	public Room() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	public List<Game> getActive_games() {
		return active_games;
	}
	public void setActive_games(List<Game> active_games) {
		this.active_games = active_games;
	}
	public List<Game> getOpen_games() {
		return open_games;
	}
	public void setOpen_games(List<Game> open_games) {
		this.open_games = open_games;
	}
	
	
	

}
