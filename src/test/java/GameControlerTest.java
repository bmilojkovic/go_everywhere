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
import main.java.servers.abstraction.user.AbstractUserAccount;
import main.java.servers.ogs.user.OgsUserAccount;

public class GameControlerTest {
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/server";
	
	/* 
	 * Test user should have account on OGS with id 80085.
	 */
	@Test
	public void openGames(){	
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/looby/0/room/0/open-games");
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
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/open-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void openGamesInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/-1/looby/0/room/0/open-games").then()
		.body("error",equalTo("Authorization error"))
		.statusCode(400);
	}
	
	@Test
	public void openGamesInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/looby/12345/room/0/open-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void myActiveGames(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/looby/0/room/0/my-active-games");
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
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/my-active-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void myActiveGamesInvalidServerID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/MarryPopins/acc/80085/looby/0/room/0/my-active-games").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesInProgressInvalidParameters(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/games-in-progress").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesInProgressInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/-1/looby/0/room/0/games-in-progress").then()
		.body("error",equalTo("Authorization error"))
		.statusCode(400);
	}
	
	@Test
	public void gamesHistory(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/looby/0/room/0/games-history");
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
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/games-history").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gamesHistoryInvalidAccID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/looby/12345/room/0/games-history").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void postGameInvalidGame(){
		//no id and other details in game
		Game game = new Game();	
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("game", game);
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(map).when().post(url + "/OGS/acc/80085/looby/0/room/0/post-game").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void startReviewInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().post(url + "/OGS/acc/80085/looby/0/room/0/game/KnightsOfHonor/start-review").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gameChatsInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/game/KnightsOfHonor/game-chats").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void gameInfoInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/game/KnightsOfHonor/game-info").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
	@Test
	public void getEstimatedScoreInvalidGameID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/bla/acc/80085/looby/12345/room/54312/game/KnightsOfHonor/get-estimated-score").then()
		.body("error",equalTo("Bad request"))
		.statusCode(400);
	}
	
}
