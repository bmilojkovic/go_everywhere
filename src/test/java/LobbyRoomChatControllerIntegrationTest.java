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
import main.java.models.Lobby;
import main.java.models.Room;

public class LobbyRoomChatControllerIntegrationTest {
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/server";
	
	/* 
	 * Test user should have account on OGS with id 80085.
	 */
	
	// This is used in case that for modifying account user should be logged in.
		@BeforeClass
		public static void login() {
			HashMap<String,String> userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("username", "MortyC132");
			userInfo.put("password", "password123");
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post("http://localhost:8080/go_everywhere_be/api/user/server/OGS/login").then()
			.statusCode(200);
		}
	
	private String validAccID = "80085";
	
	// Pre Conditions: Existing account and for the specific user that he is not joined in any room chat
	@Test
	public void getListOfRoomsAndJoinRoomChat(){
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/OGS/acc/"+validAccID+"/lobby/all");
		response.then().statusCode(200);
		String json = response.asString();
		String roomID="",lobbyID="",chatID="";
		try {
			List<Lobby> lobbies=  from(json).getList("lobbies",Lobby.class);
			if (lobbies.size()<1) {
				fail("At least one lobby should be returned.");
			}else {
				lobbyID = lobbies.get(0).getId();
			}
		}catch (Exception e){
			fail("Array list of lobbies should be reutrned.");
		}		
		
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/"+lobbyID+"/joined-rooms");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<Room> rooms=  from(json).getList("rooms",Room.class);
			if (rooms.size()>0) {
				fail("List should be empty.");
			}
		}catch (Exception e){
			fail("Array list of rooms should be reutrned.");
		}	
		
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/"+lobbyID+"/roooms-to-join");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<Room> rooms=  from(json).getList("rooms",Room.class);
			if (rooms.size()<1) {
				fail("List should contatin at least one room.");
			}
			else {
				roomID = rooms.get(0).getId();
			}
		}catch (Exception e){
			fail("Array list of rooms should be reutrned.");
		}
		
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/"+lobbyID+"/room/"+roomID+"/chats-to-join");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<Chat> chats=  from(json).getList("chats",Chat.class);
			if (chats.size()<1) {
				fail("List should contatin at least one chat room.");
			}
			else {
				chatID = chats.get(0).getId();
			}
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
		
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().post(url + "/OGS/acc/"+validAccID+"/lobby/"+lobbyID+"/room/"+roomID+"/roomChat/"+chatID+"/join-room-chat").then()
		.statusCode(200);
		
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/"+lobbyID+"/room/"+roomID+"/joined-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<Chat> chats=  from(json).getList("chats",Chat.class);
			if (chats.size()!=1) {
				fail("List should contatin only one chat room.");
			}
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
	}
	
	// Pre Conditions: Existing account and for the specific user that he has joined in at least one room chat
	@Test
	public void joiningRoomChatTwice(){
		Response response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/0/joined-rooms");
		response.then().statusCode(200);
		String json = response.asString();
		String roomID="",chatID="";
		try {
			List<Room> rooms=  from(json).getList("rooms",Room.class);
			if (rooms.size()<1) {
				fail("List should contatin at least one room.");
			}
			else {
				roomID = rooms.get(0).getId();
			}
		}catch (Exception e){
			fail("Array list of rooms should be reutrned.");
		}
		
		response = given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/OGS/acc/"+validAccID+"/lobby/0/room/"+roomID+"/joined-chats");
		response.then().statusCode(200);
		json = response.asString();
		try {
			List<Chat> chats=  from(json).getList("chats",Chat.class);
			if (chats.size()<1) {
				fail("List should contatin at least one chat room.");
			}
			else {
				chatID = chats.get(0).getId();
			}
		}catch (Exception e){
			fail("Array list of chats should be reutrned.");
		}
		
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().post(url + "/OGS/acc/"+validAccID+"/lobby/0/room/"+roomID+"/roomChat/"+chatID+"/join-room-chat").then()
		.body("error",equalTo("User already joined chat with "+chatID+" id."))
		.statusCode(400);
	}
}
