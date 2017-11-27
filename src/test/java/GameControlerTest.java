package test.java;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import main.java.models.Game;
import main.java.models.GameChat;
import main.java.servers.abstraction.user.AbstractUserAccount;
import main.java.servers.ogs.user.OgsUserAccount;

public class GameControlerTest {
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/server";
	private static String testAccID1= "80851";
	private static String testAccID2= "80852";
	
	
	// This is used in case that for modifying account user should be logged in.
		@BeforeClass
		public static void login() {
			HashMap<String,String> userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("username", "MikaMikic");
			userInfo.put("password", "password123");
			given().auth().oauth2("testToken2").contentType(ContentType.JSON).body(userInfo).when().post("http://localhost:8080/go_everywhere_be/api/user/server/OGS/login").then()
			.statusCode(200);
			userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("username", "PeraPeric");
			userInfo.put("password", "password123");
			given().auth().oauth2("testToken2").contentType(ContentType.JSON).body(userInfo).when().post("http://localhost:8080/go_everywhere_be/api/user/server/OGS/login").then()
			.statusCode(200);
		}
	
	/* 
	 * Test user should have account on OGS with id 80085.
	 */
	@Test
	public void openGames(){	
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/0/room/0/open-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
	}
	 
	 
	@Test
	public void openGamesInvalidParameters(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/open-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void openGamesInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/-1/lobby/0/room/0/open-games").then()
		.body("error",equalTo("Authorization error"))
		.statusCode(400);
	}
	
	@Test
	public void openGamesInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/lobby/12345/room/0/open-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void myActiveGames(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/0/room/0/my-active-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
	}
	
	@Test
	public void myActiveGamesInvalidParameters(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/my-active-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void myActiveGamesInvalidServerID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/MarryPopins/acc/80085/lobby/0/room/0/my-active-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesInProgressInvalidParameters(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/games-in-progress").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesInProgressInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/-1/lobby/0/room/0/games-in-progress").then()
		.body("error",equalTo("Authorization error"))
		.statusCode(400);
	}
	
	@Test
	public void gamesHistory(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/0/room/0/game-history");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
	}
	
	@Test
	public void gamesHistoryInvalidParameters(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/game-history").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesHistoryInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/lobby/12345/room/0/game-history").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void postGameInvalidGame(){
		//no details in game
		Game game = new Game();	
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("game", game);
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/80085/lobby/0/room/0/post-game").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void startReviewInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().post(url + "/OGS/acc/80085/lobby/0/room/0/game/KnightsOfHonor/start-review").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gameChatsInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/game/KnightsOfHonor/game-chats").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gameInfoInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/game/KnightsOfHonor/game-info").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void getEstimatedScoreInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/lobby/12345/room/54312/game/KnightsOfHonor/get-estimated-score").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void IGetgameInfo(){
		Game game = new Game();	
		game.setBoarSize(12);
		// here all necessary should be set for game. 
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("game", game);
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/post-game").then()
		.statusCode(200);
		
		Game g=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()<1) {
				fail("Open games shouldn't be empty list.");
			}
			g=games.get(0);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		String gID=g.getId();
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game/"+gID+"/game-info");
		response.then().statusCode(200);
		json = response.asString();
		try {
			Game g2=  from(json).getObject("game",Game.class);
			if (!g.equals(g2))
				fail("Unexpected game returned.");
		}catch (Exception e){
			fail("Game should be returned.");
		}
	}
	
	/*
	 * In this test we have two users with tokens and account IDs: (testToken, testAccID) and (testToken2, testAccID2). Second user has to have game history with at least one game.
	 */
	@Test
	public void IGameHistory(){
		Game g=null;
		Response response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game-info/"+testAccID2);
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()==0)
				fail("List of games shouldn't be empty.");
			g=games.get(0);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		
		String gID=g.getId();
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game/"+gID+"/game-info");
		response.then().statusCode(200);
		json = response.asString();
		try {
			Game g2=  from(json).getObject("game",Game.class);
			if (!g.equals(g2))
				fail("Unexpected game returned.");
		}catch (Exception e){
			fail("Game should be returned.");
		}
	}
	
	@Test
	public void IActivegames(){
		// check if there is open games, if not post new game.
		Game g=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()>0)
				g=games.get(0);
			if (g==null)
				fail("Posted game isn't returned in list of games.");
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		if (g!=null) {
			Game game = new Game();	
			game.setBoarSize(12);
			// here all necessary should be set for game. 
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("game", game);
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/post-game").then()
			.statusCode(200);
			response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
			response.then().statusCode(200);
			json = response.asString();
			try {
				List<Game> games=  from(json).getList("games",Game.class);
				if (games.size()<1) {
					fail("Open games shouldn't be empty list.");
				}
				for (Game gh:games) {
					if (gh.equals(game))
						g=gh;
				}
				if (g==null)
					fail("Posted game isn't returned in list of games.");
			}catch (Exception e){
				fail("Array list of Games should be reutrned.");
			}
		}
		String gID=g.getId();
		//join to game
		given().auth().oauth2("testToken2").contentType(ContentType.JSON).when().post(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game/"+gID+"/join-game").then()
		.statusCode(200);
		// check active games for second player
		response = given().auth().oauth2("testToken2").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/my-active-games");
		response.then().statusCode(200);
		json = response.asString();
		Game g2=null;
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			for (Game gh:games) {
				if (gh.equals(g))
					g2=gh;
			}
			if (g2==null)
				fail("At least one of active games wasn't shown.");
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		// check active games for first player
		response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/my-active-games");
		response.then().statusCode(200);
		json = response.asString();
		g2=null;
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			for (Game gh:games) {
				if (gh.equals(g))
					g2=gh;
			}
			if (g2==null)
				fail("At least one of active games wasn't shown.");
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		gID=g.getId();
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game/"+gID+"/game-info");
		response.then().statusCode(200);
		json = response.asString();
		try {
			g2=  from(json).getObject("game",Game.class);
			if (!g.equals(g2))
				fail("Unexpected game returned.");
		}catch (Exception e){
			fail("Game should be returned.");
		}
	}
	
	@Test
	public void IOpenGameChats(){
		// check if there is open games, if not post new game.
		Game g=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()>0)
				g=games.get(0);
			if (g==null)
				fail("Posted game isn't returned in list of games.");
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		if (g!=null) {
			Game game = new Game();	
			game.setBoarSize(12);
			// here all necessary should be set for game. 
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("game", game);
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/post-game").then()
			.statusCode(200);
			response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
			response.then().statusCode(200);
			json = response.asString();
			try {
				List<Game> games=  from(json).getList("games",Game.class);
				if (games.size()<1) {
					fail("Open games shouldn't be empty list.");
				}
				for (Game gh:games) {
					if (gh.equals(game))
						g=gh;
				}
				if (g==null)
					fail("Posted game isn't returned in list of games.");
			}catch (Exception e){
				fail("Array list of Games should be reutrned.");
			}
		}
		String gID=g.getId();
		//join to game
		given().auth().oauth2("testToken2").contentType(ContentType.JSON).when().post(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game/"+gID+"/join-game").then()
		.statusCode(200);
		// check if chat is returned for first user.
		response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game"+gID+"/game-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<GameChat> chats=  from(json).getList("chats",GameChat.class);
			if (chats.size()==0)
				fail("No chats are returned.");
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
		// check if chat is returned for second user.
		response = given().auth().oauth2("testToken2").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game"+gID+"/game-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<GameChat> chats=  from(json).getList("chats",GameChat.class);
			if (chats.size()==0)
				fail("No chats are returned.");
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
	
	@Test
	public void IActiveGamesChats(){
		// check if there is open games, if not post new game.
		Game g=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()>0)
				g=games.get(0);
			if (g==null)
				fail("Posted game isn't returned in list of games.");
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		if (g!=null) {
			Game game = new Game();	
			game.setBoarSize(12);
			// here all necessary should be set for game. 
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("game", game);
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/post-game").then()
			.statusCode(200);
			response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/open-games");
			response.then().statusCode(200);
			json = response.asString();
			try {
				List<Game> games=  from(json).getList("games",Game.class);
				if (games.size()<1) {
					fail("Open games shouldn't be empty list.");
				}
				for (Game gh:games) {
					if (gh.equals(game))
						g=gh;
				}
				if (g==null)
					fail("Posted game isn't returned in list of games.");
			}catch (Exception e){
				fail("Array list of Games should be reutrned.");
			}
		}
		String gID=g.getId();
		//join to game
		given().auth().oauth2("testToken2").contentType(ContentType.JSON).when().post(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game/"+gID+"/join-game").then()
		.statusCode(200);
		// check if chat is returned for first user.
		response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID1+"/lobby/0/room/0/game"+gID+"/game-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<GameChat> chats=  from(json).getList("chats",GameChat.class);
			if (chats.size()==0)
				fail("No chats are returned.");
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
		// check if chat is returned for second user.
		response = given().auth().oauth2("testToken2").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game"+gID+"/game-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
		List<GameChat> chats=  from(json).getList("chats",GameChat.class);
		if (chats.size()==0)
			fail("No chats are returned.");
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
	
	/*
	 * User ((testToken2, testAccID2)) has to have game history with at least one game.
	 */
	@Test
	public void IGameHistoryChats(){
		Game g=null;
		Response response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game-info/"+testAccID2);
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Game> games=  from(json).getList("games",Game.class);
			if (games.size()==0)
				fail("List of games shouldn't be empty.");
			g=games.get(0);
		}catch (Exception e){
			fail("Array list of Games should be reutrned.");
		}
		String gID=g.getId();
		// check if chat is returned for second user.
		response = given().auth().oauth2("testToken2").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+testAccID2+"/lobby/0/room/0/game"+gID+"/game-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<GameChat> chats=  from(json).getList("chats",GameChat.class);
			if (chats.size()==0)
				fail("No chats are returned.");
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
}
