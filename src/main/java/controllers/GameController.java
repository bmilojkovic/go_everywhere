package main.java.controllers;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import model.AbstractGame;
import model.OGSGame;
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
		
		System.out.println(game.getGameName());
		
		
		
		return game.toString();
		
		//Nas OGS Rest ce vratiti {"status":"ok","challenge":7144636,"game":10879882}
		//kakav response vracaju drugi serveri ???
	}
	
	@POST
	@Path("/TestGame")
	@Consumes("application/json")
	public String test2(OGSGame ogame){
		
		System.out.println(ogame.getGameName());
		
		return ogame.toString();
	}
	
	@GET
	@Path("/server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/games-in-progress")
	public Response openGames(@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		if(serverID.equals("ogs")){
			Request req = new Request.Builder().url("http://localhost:4700/api/challenge/openGames/"+accID).build();
			okhttp3.Response res = httpClient.newCall(req).execute();
			return Response.status(200).entity(res.body().string()).build();
		}else{
			return Response.status(404).build();
		}
		
		
	}
	
	@GET
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/my-active-games")
	public Response myActiveGames(@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		if(serverID.equals("ogs")){
			Request req = new Request.Builder().url("http://localhost:4700/api/challenge/inProgress/"+accID).build();
			okhttp3.Response res = httpClient.newCall(req).execute();
			return Response.status(200).entity(res.body().string()).build();
		}else{
			return Response.status(404).build();
		}
		
		
	}
	
	
	@POST
	@Path("server/{serverID}/acc/{accID}/lobby/{lobbyID}/room/{roomID}/post-game")
	@Consumes("application/json")
	public String postGame(String body,@PathParam("serverID") String serverID,@PathParam("accID") int accID,@PathParam("lobbyID") String lobbyID, @PathParam("roomID") String roomID) throws IOException{
		String id="";
		
		if(serverID.equals("ogs")){
			//as so just relay the request from frontend to express
			
			JSONObject jobject = new JSONObject(body);
			JSONObject requestObj = new JSONObject();
			requestObj.accumulate("game", jobject);
			requestObj.accumulate("account", accID);
			requestObj.accumulate("lobby", serverID);
			requestObj.accumulate("server", serverID);
			requestObj.accumulate("room", serverID);
			
			
			RequestBody reqBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestObj.toString());
			Request request = new Request.Builder().url("http://localhost:4700/api/challenge/create").post(reqBody).build(); 
			okhttp3.Response response = httpClient.newCall(request).execute();
			
			//Dva puta kada se za istog usera pokrene onda ne radi ???
			
			
			
			return response.message();
			
		}else{
			return "-1";
		}
		
	}
	
}
