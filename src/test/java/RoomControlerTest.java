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
import main.java.models.Chat;
import main.java.models.Game;

public class RoomControlerTest {
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/server";
	
	/* 
	 * Test user should have account on OGS with id 80085.
	 */
	
	@Test
	public void joinedChats(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/looby/0/room/0/joined-chats");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Chat> chats=  from(json).getList("chats",Chat.class);
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
	
	@Test
	public void joinedChatsInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/looby/12345/room/0/joined-chats").then()
		.body("error",equalTo("No lobby found for passed lobbyID"))
		.statusCode(400);
	}
	
	
	@Test
	public void joinedRooms(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/80085/looby/0/room/0/chats-to-join");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<Chat> chats=  from(json).getList("chats",Chat.class);
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
	
	@Test
	public void joinedRoomsInvalidLobbyID(){
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/80085/looby/0/room/12345/chats-to-join").then()
		.body("error",equalTo("No room  found for passed roomID in Lobby {lobbyID}."))
		.statusCode(400);
	}
}
