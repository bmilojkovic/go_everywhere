package model;

import java.util.List;

public class Lobby {

	private String id;
	private List<Room> rooms;
	
	
	
	public Lobby() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
