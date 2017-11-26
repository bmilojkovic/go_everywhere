package test.java;


import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.PathParam;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import main.java.models.Lobby;
import main.java.servers.abstraction.user.AbstractUserAccount;
import main.java.servers.ogs.user.OgsUserAccount;

public class UserControllerTest {
	
	/*
	 testToken to be changed into a single JWT token for testing
	 */
	
	private static String url = "http://localhost:8080/go_everywhere_be/api/user/server/OGS";
	
	// This is used in case that for modifying account user should be logged in.
	@BeforeClass
	public static void login() {
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("username", "MortyC132");
		userInfo.put("password", "password123");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/login").then()
		.statusCode(200);
	}
	
	
	@Test
	public void testForRESTAssured(){
		//get("http://www.google.com").then().body("error",equalTo(""")).statusCode(200);	
	}
	
	//test
	@Test
	public void NekiTest(){
		HashMap<String, Object> hm= new HashMap<>();
		hm.put("A", "B");
			Response response = given().when().contentType(ContentType.JSON).get(url + "/accounts");
			response.then().statusCode(200);
			String json = response.asString();
			try {
				List<Lobby> accounts=  from(json).getList("accounts",Lobby.class);
			}catch (Exception e){
				
			}
			List<Lobby> lobbies = new ArrayList<Lobby>();
			Lobby lob = new Lobby();
			lob.setId("5");
			lobbies.add(lob);
			//assertEquals(accounts, new ArrayList<Lobby>());
	}
	
	/*
	 Account written below has to be a real account on OGS server and also has to be in our database for the test user.
	 */
	@Test
	public void addAccountExistsAlready(){
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("username", "MortyCopy");
		userInfo.put("email", "mortygoeverywhere@gmail.com");
		userInfo.put("password", "password123");	  
		given().log().all().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then().log().all()
		.body("error",equalTo("OGS account already exists for this user profile. Please use modify URL: acc/modify"))
		.statusCode(400);
	}
	
	/*
	 Account written below has to be a real account on OGS server but mustn't to be in our database for the test user.
	 */
	@Test
	public void addAccount(){
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("username", "MortyC132");
		userInfo.put("email", "mortygoeverywhere@gmail.com");
		userInfo.put("password", "password123");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
		.statusCode(200);		
		
		// rollback of made action, because of that test will looks more like integration test (but what I can ?)
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
			if (accounts.size()<1) {
				fail("At least one account should be returned.");
			}
			OgsUserAccount acc=null;
			for (int i=0;i<accounts.size();i++) {
				if (accounts.get(i) instanceof OgsUserAccount && 
						accounts.get(i).getUsername().equals("MortyC132") && 
						((OgsUserAccount)accounts.get(i)).getEmail().equals("mortygoeverywhere@gmail.com")) {
					acc=(OgsUserAccount)accounts.get(i);
					break;
				}
			}
			if (acc==null) {
				fail("Expected account wasn't found.");
			}
			String accID=acc.getId();
			given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/remove-acc/" + accID).then()
			.statusCode(200);
			// zapamti ovaj nalog sto ces da sklonis, da ga lakse dobijes
		}catch (Exception e){
			fail("Array list of OGS accounts should be reutrned.");
		}
	}
	
	
	/*
	 Account written below mustn't real account on OGS server and not in our database for the test user.
	 */
	@Test
	public void addAccountInvalidUsernameAndPassword(){
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("username", "MortyC132");
		userInfo.put("email", null);
		userInfo.put("password", null);
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
		.body("error",equalTo("Invalid values for properties email and password"))
		.statusCode(400);	
	}
	
	
	/*
	 Account written below mustn't real account on OGS server and not in our database for the test user.
	 */
	@Test
	public void addAccountNonExistingAccount(){
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("username", "MortyC1321");
		userInfo.put("email", "mortygoeverywhere123@gmail.com");
		userInfo.put("password", "password123456");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
		.body("error",equalTo("Account doesn't exist on OGS server, please check your account info"))
		.statusCode(400);		
	}
	
	/*
	 In our database mustn't be account with id -1.
	 */
	@Test
	public void removeAccountNotExisting(){
		String accId="-1";
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/remove-acc/" + accId).then()
		.body("error",equalTo("No account with passed id"))
		.statusCode(400);
	}
	
	/*
	 In our database has to be test user's account with id 80085.
	 This test is defined in specification, but we cannot know accID before account on OGS is made.
	 If you want to use this account set accID to proper value.
	 */
	/*@Test
	public void removeAccount(){
		String accID="80085";
		given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/remove-acc/" + accId).then()
		.statusCode(200);
	}*/

	/*
	 * Test user has to have at least one account.
	 */
	@Test
	public void iGet_RemoveAccount(){
		OgsUserAccount acc=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
			if (accounts.size()<1) {
				fail("At least one account should be returned.");
			}
			for (int i=0;i<accounts.size();i++) {
				if (accounts.get(i) instanceof OgsUserAccount) {
					acc=(OgsUserAccount)accounts.get(i);
					break;
				}
			}
			if (acc==null) {
				fail("Expected account wasn't found.");
			}
			String accID=acc.getId();
			given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/remove-acc/" + accID).then()
			.statusCode(200);
			// zapamti ovaj nalog sto ces da sklonis, da ga lakse dobijes
		}catch (Exception e){
			fail("Array list of OGS accounts should be reutrned.");
		}
		//rollback
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", acc.getServerKey());
		userInfo.put("username", acc.getUsername());
		userInfo.put("email", acc.getEmail());
		// Password will be changed with this test, it seems that it is no so important, as it is no used anywhere.
		userInfo.put("password", "password");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
		.statusCode(200);
	}
	
	// Username for first account for test user should be testAcc1 and that account has to have id 999
	@Test
	public void iGet_ModifyAccount(){
		OgsUserAccount acc=null;
		Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
		response.then().statusCode(200);
		String json = response.asString();
		try {
			List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
			if (accounts.size()<1) {
				fail("At least one account should be returned.");
			}
			for (int i=0;i<accounts.size();i++) {
				if (accounts.get(i) instanceof OgsUserAccount) {
					acc=(OgsUserAccount)accounts.get(i);
					break;
				}
			}
			if (acc==null) {
				fail("At least one OGS account should be returned");
			}
		}catch (Exception e){
			fail("Array list of OGS accounts should be reutrned.");
		}		
		String accID=acc.getId();
		HashMap<String,String> userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("accID", accID);
		userInfo.put("username", "testAcc2");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
		.statusCode(200);	
		response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
		response.then().statusCode(200);
		json = response.asString();
		OgsUserAccount acc2=null;
		try {
			List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
			if (accounts.size()<1) {
				fail("At least one account should be returned.");
			}
			for (int i=0;i<accounts.size();i++) {
				if (accounts.get(i).getId()==acc.getId() && accounts.get(i).getUsername().equals("testAcc2")) {
					acc2=(OgsUserAccount)accounts.get(i);
					break;
				}
			}
			if (acc2==null) {
				fail("Changed account wasn't found.");
			}
		}catch (Exception e){
			fail("Array list of OGS accounts should be reutrned.");
		}		
		
		userInfo = new HashMap<String,String>();
		userInfo.put("serverName", "OGS");
		userInfo.put("accID", accID);
		userInfo.put("username", "testAcc1");
		given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/modify-acc").then()
		.statusCode(200);
	}
	
	// Test user has to have 0 accounts. Account MortyC123 (as in code) has to be valid account on OGS.
		@Test
		public void iGet_Add_ModifyAccount(){
			Response response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
			response.then().statusCode(200);
			String json = response.asString();
			try {
				List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
				if (accounts.size()!=0) {
					fail("Emplty list of accounts should be returned.");
				}
			}catch (Exception e){
				fail("Array list of OGS accounts should be reutrned.");
			}		
			
			HashMap<String,String> userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("username", "MortyC132");
			userInfo.put("email", "mortygoeverywhere@gmail.com");
			userInfo.put("password", "password123");
			given().auth().oauth2("testTokenNoAcc").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
			.statusCode(200);		
			
			OgsUserAccount acc=null;
			response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
			response.then().statusCode(200);
			json = response.asString();
			try {
				List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
				if (accounts.size()<1) {
					fail("At least one account should be returned.");
				}
				if (accounts.size()!=1) {
					fail("User should have one account, but returned list has size different than 1.");
				}
				if (accounts.get(0) instanceof OgsUserAccount) {
					acc=(OgsUserAccount) accounts.get(0);
				}else {
					fail("OGS account was added, but non OGS account was returned.");
				}
				if (!acc.getUsername().equals("MortyC132") ||
						!acc.getEmail().equals("mortygoeverywhere"))
					fail("Properties of returned account are unexpected");
			}catch (Exception e){
				fail("Array list of OGS accounts should be reutrned.");
			}		
			
			String accID = acc.getId();
			userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("accID", accID);
			userInfo.put("username", "MortyNew");
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/add-acc").then()
			.statusCode(200);		
			
			acc=null;
			response = given().auth().oauth2("testToken").when().contentType(ContentType.JSON).get(url + "/accounts");
			response.then().statusCode(200);
			json = response.asString();
			try {
				List<AbstractUserAccount> accounts=  from(json).getList("accounts",AbstractUserAccount.class);
				if (accounts.size()<1) {
					fail("At least one account should be returned.");
				}
				if (accounts.size()!=1) {
					fail("User should have one account, but returned list has size different than 1.");
				}
				if (accounts.get(0) instanceof OgsUserAccount) {
					acc=(OgsUserAccount) accounts.get(0);
				}else {
					fail("OGS account was added, but non OGS account was returned.");
				}
				if (!acc.getUsername().equals("MortyNew") ||
						!acc.getEmail().equals("mortygoeverywhere"))
					fail("Properties of returned account are unexpected");
			}catch (Exception e){
				fail("Array list of OGS accounts should be reutrned.");
			}	
			
			userInfo = new HashMap<String,String>();
			userInfo.put("serverName", "OGS");
			userInfo.put("accID", accID);
			userInfo.put("username", "MortyC132");
			given().auth().oauth2("testToken").contentType(ContentType.JSON).body(userInfo).when().post(url + "/modify-acc").then()
			.statusCode(200);
			
			given().auth().oauth2("testToken").contentType(ContentType.JSON).when().get(url + "/remove-acc/" + acc.getId()).then()
			.statusCode(200);
			
		}
}