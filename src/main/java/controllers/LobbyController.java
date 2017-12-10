package main.java.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Chat;
import model.Room;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Path("/lobby")
public class LobbyController {

	
	OkHttpClient httpClient = new OkHttpClient();
	
	public void OgsRoom(List<Room> rooms, String accID){
		//We only have one room
	
		Room room = new Room();
		room.setId("0");
		
		List<Chat> chats = new LinkedList<>();
		OGSChats(chats);
		room.setChats(chats);
		//active games
		

	}
	
	public void OGSChats(List<Chat> chats){
		
		Request request = new Request.Builder().url("https://online-go.com/api/v1/ui/config").build();
		try {
			Response response = httpClient.newCall(request).execute();
			JSONObject responseObject = new JSONObject(response.message());
			
			JSONArray array = responseObject.getJSONObject("ogs").getJSONArray("channels");
			
			for(int i=0;i<array.length();i++){
				JSONObject obj = array.getJSONObject(i);
				Chat ch = new Chat();
				ch.setId(obj.getString("id"));
				ch.setName(obj.getString("name"));
				chats.add(ch);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/rooms-to-join")
	public List<Room> roomsToJoin(@PathParam("serverID") String serverID,
									@PathParam("accID") String accID,
									@PathParam("lobbyID") String lobbyID){
		List<Room> rooms= new LinkedList<>();
		
		if(serverID.equals("ogs")){
			OgsRoom(rooms,accID);
		}else{
			
		}
		
		return rooms;
	}
	
}
