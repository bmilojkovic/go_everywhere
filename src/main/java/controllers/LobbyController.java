package main.java.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Chat;
import model.Lobby;
import model.OGS;
import model.Room;
import model.game.Game;
import model.ogs.game.OGSGame;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Path("/lobby")
public class LobbyController {

	
	@POST
	@Path("/TEST")
	@Consumes("application/json")
	@Produces("application/json")	
	public OGSGame test(String body) throws JsonParseException, JsonMappingException, IOException{
		
		JSONObject obj = new JSONObject(body);
		ObjectMapper mapper = new ObjectMapper();
		OGSGame bl = mapper.readValue(obj.toString(),OGSGame.class);
		
		return bl;
	}
	
	
	OkHttpClient httpClient = new OkHttpClient();
	
	public void OgsRoom(List<Room> rooms, String accID){
		//We only have one room
	
		Room room = new Room();
		room.setId(OGS.ogsRoomId);
		
		//setChats
		OGSChats(room);
		//active games
		OGSActiveGames(room, accID);
		//open challanges
		OGSOpenGames(room, accID);
		
		rooms.add(room);
		
	}
	
	//ogs.activeGames
	public void OGSActiveGames(Room room,String accId){
		
		Request req = new Request.Builder().url("http://localhost:4700/api/challenge/inProgress/"+accId).build();
		
		try {
			Response resp = httpClient.newCall(req).execute();
			JSONArray activeGamesArray = new JSONArray(resp.body().string());
			List<Game> games = new LinkedList<>();
			activeGamesArray.forEach(game ->{
				JSONObject obj = (JSONObject) game;
				
				ObjectMapper mapper = new ObjectMapper();
				
				try {
					OGSGame oGame = mapper.readValue(obj.toString(),OGSGame.class);
					Game newGoEGame = new Game(oGame);
					games.add(newGoEGame);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			
			room.setActive_games(games);
			resp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//ogs.openChallenges
	public void OGSOpenGames(Room room,String accId){
		Request req = new Request.Builder().url("http://localhost:4700/api/challenge/openGames/"+accId).build();
		
		try {
			Response resp = httpClient.newCall(req).execute();
			JSONArray joinedChatsArray = new JSONArray(resp.body().string());
			
			List<Game> games = new LinkedList<>();
			
			joinedChatsArray.forEach(game ->{
				JSONObject obj = (JSONObject) game;
				
				ObjectMapper mapper = new ObjectMapper();
				
				try{
					
					OGSGame oGame = mapper.readValue(obj.toString(),OGSGame.class);
					Game goEGame = new Game(oGame);
					games.add(goEGame);
				}catch(IOException e){
					e.printStackTrace();
				}
			});
			room.setOpen_games(games);
			resp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void JoinedOGSChats(Room room,String accId){
		
		Request req = new Request.Builder().url("http://localhost:4700/api/challenge/joinedChats/"+accId).build();
		try {
			Response resp = httpClient.newCall(req).execute();
			System.out.println(resp.message());
			JSONArray activeGamesArray = new JSONArray(resp.body().string());
			List<Chat> chats = new LinkedList<>();
			activeGamesArray.forEach(game ->{
				Chat ch = new Chat(OGS.ogsChatId,(String)game);
				chats.add(ch);
			});
			
			room.setChats(chats);
			resp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void OGSChats(Room room){
		
		Request request = new Request.Builder().url("http://online-go.com/api/v1/ui/config").build();
		try {
			Response response = httpClient.newCall(request).execute();
			JSONObject responseObject = new JSONObject(response.body().string());
			
			JSONArray array = responseObject.getJSONObject("ogs").getJSONArray("channels");
			
			for(int i=0;i<array.length();i++){
				JSONObject obj = array.getJSONObject(i);
				Chat ch = new Chat();
				ch.setId(obj.getString("id"));
				ch.setName(obj.getString("name"));
				room.getChats().add(ch);
			}
			
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@GET
	@Produces("application/json")
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
	
	@GET
	@Produces("application/json")
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/joined-rooms")
	public List<Room> joinedRooms(@PathParam("serverID") String serverID,
								  @PathParam("accID") String accID,
								  @PathParam("lobbyID") String lobbyID){
		
		List<Room> rooms = new LinkedList<>();
		
		if(serverID.equals("ogs")){
			
			Room room = new Room();
			room.setId(OGS.ogsRoomId);

			JoinedOGSChats(room,accID);
			//active games
			OGSActiveGames(room, accID);
			//open challanges
			OGSOpenGames(room, accID);
			
			rooms.add(room);
		}else{
			
		}
		return rooms;
	}
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/all")
	public List<Lobby> getAllLobbies(@PathParam("serverID") String serverID,@PathParam("accID") String accID){
		List<Lobby> lobbies = new LinkedList<>();
		
		
		if(serverID.equals("ogs")){
			Lobby l = new Lobby();
			l.setId("ogsID");
			Room r = new Room();
			OGSChats(r);
			lobbies.add(l);
		}else{
			
		}
		
		return lobbies;
	}
	
}
