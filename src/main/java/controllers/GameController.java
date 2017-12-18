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
import model.ogs.game.challenges.OGSChallenge;
import model.ogs.game.history.OGSGameHistory;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Path("/game")
public class GameController {

	
	OkHttpClient httpClient = new OkHttpClient();
	
	
	/**
	 * Gets games from node expres
	 * @param games list to which the games will be stored
	 * @param path either inProgress or openGames
	 * @param accID represents the user
	 * @throws IOException
	 */
	public void getGames(List<Game> games,String path,String accID) throws IOException{
		Request req = new Request.Builder().url("http://localhost:4700/api/challenge/"+path+"/"+accID).build();
		okhttp3.Response res = httpClient.newCall(req).execute();
		
		
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
	}
	
	public void getChallanges(List<Game> games,String accID) throws IOException{
		Request req = new Request.Builder().url("http://localhost:4700/api/challenge/openGames/"+accID).build();
		okhttp3.Response res = httpClient.newCall(req).execute();
		
		
		JSONArray gameArray = new JSONArray(res.body().string());
		
		gameArray.forEach(game->{
			JSONObject gameObject = (JSONObject) game;
			
			ObjectMapper mapper = new ObjectMapper();
			
			OGSChallenge ogsGame;
			try {
				ogsGame = mapper.readValue(gameObject.toString(),OGSChallenge.class);
				Game geGame = new Game(ogsGame);
				games.add(geGame);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
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
	public List<Game> openGames(@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		List<Game> games = new LinkedList<>();
		
		if(serverID.equals("ogs")){

			getChallanges(games, accID);
			
			
		}else{
			
		}
		
		return games;
	}
	
	@GET
	@Produces("application/json")
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/my-active-games")
	public List<Game> myActiveGames(@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		List<Game> games = new LinkedList<>();
		if(serverID.equals("ogs")){

			getGames(games, "inProgress", accID);

		}else{
			
		}
		
		return games;
	}
	
	
	@POST
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/post-game")
	@Consumes("application/json")
	public String postGame(Game game,@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		
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
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/games-in-progress")
	@Produces("application/json")
	public List<Game> gamesInProgress(@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		List<Game> games = new LinkedList<>();
		
		if(serverID.equals("ogs")){
			
			 getGames(games, "inProgress", accID);
			 getChallanges(games, accID);
			
		}else{
			
		}
		
		return games;
	}
	
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/game-history/{hisAccID}")
	@Produces("application/json")
	public List<Game> gameHistory(@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID, @PathParam("hisAccID") String hisAccID){
		
		List<Game> games= new LinkedList<>();
		
		if(serverID.equals("ogs")){
			
			Request req = new Request.Builder().url("https://online-go.com/api/v1/players/"+hisAccID+"/games").build();
			try {
				Response res = httpClient.newCall(req).execute();
				
				JSONObject responseObject = new JSONObject(res.body().string());
				
				JSONArray results = responseObject.getJSONArray("results");
				
				results.forEach(game->{
				
					JSONObject gameObject = (JSONObject)game;
					
					ObjectMapper map = new ObjectMapper();
					try {
						OGSGameHistory ogsGame= map.readValue(gameObject.toString(), OGSGameHistory.class);
						games.add(new Game(ogsGame));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				});
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			
		}
		
		
		return games;
	}
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/game/{gameID}/game-info")
	@Produces("application/json")
	public Game GameInfo(@PathParam("serverID") String serverID,@PathParam("accID") String accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID,@PathParam("gameID") String gameID){
		Game g = new Game();
		
		if(serverID.equals("ogs")){
			
			//we need our authentification token ?
			String restToken="";
			Request nodeReq = new Request.Builder().url("http://localhost:4700/api/token/"+accID+"/").build();
			try{
				
				Response restTokenResponse = httpClient.newCall(nodeReq).execute();
				JSONObject tokenResponse = new JSONObject(restTokenResponse.body().string());
				restToken = tokenResponse.getString("restToken"); 
				
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			Request req = new Request.Builder().url("http://online-go.com/v1/games/"+gameID).header("Authorization", "Bearer "+restToken).build();
			
			try{
				
				Response res = httpClient.newCall(req).execute();
				System.out.println(res.body().string());
				
			}catch(IOException e){
				e.printStackTrace();
			}
			
			
		}else{
			g = new Game();
		}
			
		
		return g;
	}
	
	//returns raw OGS object
	@GET
	@Path("/server/{serverID}/lobby/{lobbyID}/room/{roomID}/game/{gameID}/estimate")
	@Produces("application/json")
	public String getEstimatedScore(String body,@PathParam("serverID") String serverID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID,@PathParam("gameID") String gameID){

		if(serverID.equals("ogs")){
			return body;
		}else{
			
		}
		
		return null;
	}
	
	
}
