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

import com.fasterxml.jackson.databind.ObjectMapper;

import model.AbstractGame;
import model.OGSGameSetup;
import model.game.Game;
import model.ogs.game.OGSGame;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Path("/game")
public class GameController {

	
	OkHttpClient httpClient = new OkHttpClient();
	
	
	@POST
	@Consumes("application/json")
	public String test(AbstractGame game){
		
		//System.out.println(game.getGameName());
		
		
		
		return game.toString();
		
		//Nas OGS Rest ce vratiti {"status":"ok","challenge":7144636,"game":10879882}
		//kakav response vracaju drugi serveri ???
	}
	
	@GET
	@Produces("application/json")
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/games-in-progress")
	public List<Game> openGames(@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		if(serverID.equals("ogs")){
			Request req = new Request.Builder().url("http://localhost:4700/api/challenge/openGames/"+accID).build();
			okhttp3.Response res = httpClient.newCall(req).execute();
			
			List<Game> games = new LinkedList<>();
			JSONArray gameArray = new JSONArray(res.body().string());
			
			gameArray.forEach(game->{
				JSONObject gameObject = (JSONObject) game;
				
				ObjectMapper mapper = new ObjectMapper();
				
				OGSGame ogsGame;
				try {
					ogsGame = mapper.readValue(gameObject.toString(),OGSGame.class);
					Game geGame = new Game(ogsGame);
					games.add(geGame);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			});
			
			
			return games;
		}else{
			return null;
		}
		
		
	}
	
	@GET
	@Produces("application/json")
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/my-active-games")
	public List<Game> myActiveGames(@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		if(serverID.equals("ogs")){
			Request req = new Request.Builder().url("http://localhost:4700/api/challenge/inProgress/"+accID).build();
			okhttp3.Response res = httpClient.newCall(req).execute();
			
			List<Game> games = new LinkedList<>();
			JSONArray gameArray = new JSONArray(res.body().string());
			
			gameArray.forEach(game->{
				JSONObject gameObject = (JSONObject) game;
				
				ObjectMapper mapper = new ObjectMapper();
				
				OGSGame ogsGame;
				try {
					ogsGame = mapper.readValue(gameObject.toString(),OGSGame.class);
					Game geGame = new Game(ogsGame);
					games.add(geGame);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			return games;
			
		}else{
			return null;
		}
		
		
	}
	
	
	@POST
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/post-game")
	@Consumes("application/json")
	public String postGame(Game game,@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		String id="";
		
		if(serverID.equals("ogs")){
			//as so just relay the request from frontend to express
			OGSGameSetup newGame = new OGSGameSetup(game);
			RequestBody reqBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),newGame.toJson().toString());
			Request request = new Request.Builder().url("http://localhost:4700/api/challenge/create").post(reqBody).build(); 
			okhttp3.Response response = httpClient.newCall(request).execute();
			
			
			return response.body().string();
		}else{
			return "-1";
		}
		
	}
	
}
