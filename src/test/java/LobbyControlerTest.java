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
import main.java.models.Lobby;
import main.java.models.Room;

public class LobbyControlerTest {
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/server";
	
	/* 
	 * Test user should have account on OGS with some id (when you make OGS account, change 80085 with proper account ID).
	 * This should be done for all tests.
	 */
	
	@Test
	public void allLobbies(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/all");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Lobby> lobbies=  from(json).getList("lobbies",Lobby.class);
		}catch (Exception e){
			fail("Array list of lobbies should be reutrned.");
		}
	}
	
	@Test
	public void allLobbiesInvalidServerID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/898/acc/80085/lobby/all").then()
		.body("error",equalTo("Invalid server ID"))
		.statusCode(400);
	}
	
	@Test
	public void roomsToJoin(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/0/rooms-to-join");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Room> rooms=  from(json).getList("rooms",Room.class);
		}catch (Exception e){
			fail("Array list of rooms should be reutrned.");
		}
	}
	
	@Test
	public void roomsToJoinInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/lobby/12345/rooms-to-join").then()
		.body("error",equalTo("No lobby found for passed lobbyID"))
		.statusCode(400);
	}
	
	
	@Test
	public void joinedRooms(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/lobby/0/joined-rooms");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Room> rooms=  from(json).getList("rooms",Room.class);
		}catch (Exception e){
			fail("Array list of rooms should be reutrned.");
		}
	}
	
	@Test
	public void joinedRoomsInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/lobby/12345/joined-rooms").then()
		.body("error",equalTo("No lobby found for passed lobbyID"))
		.statusCode(400);
	}
	
	@Test
	public void joinedRoomsEmptyList(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/lobby/3/joined-rooms").then()
		.statusCode(200);
	}
}
