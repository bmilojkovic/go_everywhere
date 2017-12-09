package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.servers.abstraction.user.AbstractUserAccount;
import main.java.servers.abstraction.user.User;
import main.java.servers.go_everywhere.DBParameters;
import main.java.servers.go_everywhere.UserRepository;
import main.java.servers.ogs.user.OgsUserAccount;



public class UserRepositoryTest {

	private UserRepository r;
	private String dbname;
	
	@Before
	public void setUp() {
		r = new UserRepository();
		dbname = DBParameters.DBNAME;
	}

	@Test 
	public void testCreate() throws SQLException {
				
		Statement statement;
		ResultSet resultSet;
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (resultSet.next()) {
			query = "delete from " + dbname + ".User where id = \"userid\"";
			statement = r.getConnection().createStatement();
			statement.executeUpdate(query);
		}
		
		User user = new User("userid", "username", new Date(117, 10, 27), "at", "rt", "ogs", "user.png", "FName", "LName");
		r.create(user);
		
		query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		resultSet.next();
		String id = resultSet.getString("id");
		String username = resultSet.getString("username");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		String pictureUrl = resultSet.getString("pictureURL");
		String accessToken = resultSet.getString("accessToken");
		String refreshToken = resultSet.getString("refreshToken");
		Date registrationDate = resultSet.getDate("registrationDate");
		
		assertEquals(user.getId(), id);
		assertEquals(user.getUsername(), username);
		assertEquals(user.getRegistrationDate(), registrationDate);
		assertEquals(user.getAccessToken(), accessToken);
		assertEquals(user.getRefreshToken(), refreshToken);
		assertEquals(user.getPictureUrl(), pictureUrl);
		assertEquals(user.getFirstName(), firstName);
		assertEquals(user.getLastName(), lastName);
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
		
	}
	
	@Test (expected = com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException.class)
	public void testCreateDoubleUser() throws SQLException {
		
		User user = new User("userid", "username", new Date(117, 10, 27), "at", "rt", "ogs", "user.png", "FName", "LName");
		r.create(user);
		r.create(user);
	}
	
	@Test
	public void testRead() throws SQLException {
				
		Statement statement;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		User user = new User("userid", "username", new Date(117, 10, 27), "at", "rt", "ogs", "user.png", "FName", "LName");
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (!resultSet.next()) {
			query = "insert into " + dbname + ".user values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
			preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
			preparedStatement.setDate(1, new Date(117, 10, 27));
			preparedStatement.executeUpdate();
		}
		
		User newUser = r.read("userid");
		
		assertEquals(user.getUsername(), newUser.getUsername());
		assertEquals(user.getRegistrationDate(), newUser.getRegistrationDate());
		assertEquals(user.getAccessToken(), newUser.getAccessToken());
		assertEquals(user.getRefreshToken(), newUser.getRefreshToken());
		assertEquals(user.getPictureUrl(), newUser.getPictureUrl());
		assertEquals(user.getFirstName(), newUser.getFirstName());
		assertEquals(user.getLastName(), newUser.getLastName());
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		PreparedStatement preparedStatement;
		Statement statement;
		ResultSet resultSet;
		User user = new User("userid", "username", new Date(117, 10, 27), "aat", "rrt", "ogs", "useruser.png", "FName", "LName");
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (!resultSet.next()) {
			query = "insert into " + dbname + ".User values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
			preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
			preparedStatement.setDate(1, new Date(117, 10, 27));
			preparedStatement.executeUpdate();
		}
		
		query = "insert into " + dbname + ".Account values(\"accid\", \"rt\", \"at\", \"username\", \"ogs\", \"userid\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 10, 27));
		preparedStatement.executeUpdate();
		
		r.update(user);
		
		query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		resultSet.next();
		
		assertEquals("aat", resultSet.getString("accessToken"));
		assertEquals("rrt", resultSet.getString("refreshToken"));
		assertEquals("useruser.png", resultSet.getString("pictureURL"));
		
		query = "delete from " + dbname + ".Account where (id = \"accid\" and User_id = \"userid\" and server = \"ogs\")";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);		
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		User user = new User("userid", "username", new Date(117, 10, 27), "at", "rt", "ogs", "user.png", "FName", "LName");
		PreparedStatement preparedStatement;
		Statement statement;
		ResultSet resultSet;
		
		String query = "insert into " + dbname + ".User values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 10, 27));
		preparedStatement.executeUpdate();
		
		r.delete(user);
		
		query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		assertFalse(resultSet.next());
		
	}
	
	@Test
	public void testSearch() throws SQLException {
		
		PreparedStatement preparedStatement;
		ArrayList<User> result;
		Statement statement;
		ResultSet resultSet;
		
		String query = "select * from " + dbname + ".User where (id = \"userid1\" or id = \"userid2\" or id = \"userid3\")";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (resultSet.next()) {
			query = "delete from " + dbname + ".User where (id = \"userid1\" or id = \"userid2\" or id = \"userid3\")";
			statement = r.getConnection().createStatement();
			statement.executeUpdate(query);
		}
		
		query = "insert into " + dbname + ".User values(\"userid1\", \"uusername1\", \"FName1\", \"LName1\", \"user1.png\", \"rt1\", \"at1\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 1, 1));
		preparedStatement.executeUpdate();
		query = "insert into " + dbname + ".User values(\"userid2\", \"uusername2\", \"FName2\", \"LName2\", \"user2.png\", \"rt2\", \"at2\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 2, 2));
		preparedStatement.executeUpdate();
		query = "insert into " + dbname + ".User values(\"userid3\", \"username3\", \"FName3\", \"LName3\", \"user3.png\", \"rt3\", \"at3\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 3, 3));
		preparedStatement.executeUpdate();
		
		result = (ArrayList<User>) r.search("uus");
		
		for (User user : result) {
			assertTrue(user.getUsername().indexOf("uus") != -1);
		}
		
		query = "delete from " + dbname + ".User where (id = \"userid1\" or id = \"userid2\" or id = \"userid3\")";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
	}
	
	@Test
	public void testGetUserAccounts() throws SQLException {
		
		PreparedStatement preparedStatement;
		Statement statement;
		ArrayList<AbstractUserAccount> accounts = new ArrayList<>();
		ResultSet resultSet;
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (!resultSet.next()) {
			query = "insert into " + dbname + ".User values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
			preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
			preparedStatement.setDate(1, new Date(117, 10, 27));
			preparedStatement.executeUpdate();
		}
		query = "insert into " + dbname + ".Account values(\"accid\", \"rt\", \"at\", \"username\", \"ogs\", \"userid\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 10, 27));
		preparedStatement.executeUpdate();
		
		accounts = (ArrayList<AbstractUserAccount>) r.getUserAccounts("userid");
		
		OgsUserAccount ogsAcc = (OgsUserAccount) accounts.get(0);
		
		assertEquals("accid", ogsAcc.getId());
		assertEquals("rt", ogsAcc.getRefreshToken());
		assertEquals("at", ogsAcc.getAccessToken());
		assertEquals("username", ogsAcc.getUsername());
		assertEquals("ogs", ogsAcc.getServerKey());
		assertEquals("userid", ogsAcc.getUserId());
		assertEquals(new Date(117, 10, 27), ogsAcc.getRegistrationDate());
				
		query = "delete from " + dbname + ".Account where (id = \"accid\" and User_id = \"userid\" and server = \"ogs\")";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);		
		
	}
	
	@Test
	public void testAddUserAccount() throws SQLException {
		Statement statement;
		ResultSet resultSet;
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		PreparedStatement preparedStatement;
		resultSet = statement.executeQuery(query);
		
		if (resultSet.next()) {
			query = "delete from " + dbname + ".User where id = \"userid\"";
			statement = r.getConnection().createStatement();
			statement.executeUpdate(query);
		}
		
		query = "insert into " + dbname + ".User values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 10, 27));
		preparedStatement.executeUpdate();
		
		OgsUserAccount userAccount = new OgsUserAccount("accid", "username", new Date(117, 2, 2), "aac", "ars", "ogs", "userid");
		
		r.addUserAccount("userid", userAccount);
		
		query = "select * from " + dbname + ".Account where id = \"accid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		resultSet.next();
		String id = resultSet.getString("id");
		String username = resultSet.getString("username");
		Date registrationDate = resultSet.getDate("registrationDate");
		String accessToken = resultSet.getString("accessToken");
		String refreshToken = resultSet.getString("refreshToken");
		String serverKey = resultSet.getString("server");
		String userId = resultSet.getString("User_id");
		
		assertEquals(userAccount.getId(), id);
		assertEquals(userAccount.getUsername(), username);
		assertEquals(userAccount.getRegistrationDate(), registrationDate);
		assertEquals(userAccount.getAccessToken(), accessToken);
		assertEquals(userAccount.getRefreshToken(), refreshToken);
		assertEquals(userAccount.getServerKey(), serverKey);
		assertEquals(userAccount.getUserId(), userId);
		
		query = "delete from " + dbname + ".Account where (id = \"accid\" and User_id = \"userid\" and server = \"ogs\")";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);		
	
	}
	
	@Test
public void testDeleteUserAccount() throws SQLException {
		
		PreparedStatement preparedStatement;
		Statement statement;
		ResultSet resultSet;
		
		String query = "select * from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		if (!resultSet.next()) {
			query = "insert into " + dbname + ".User values(\"userid\", \"username\", \"FName\", \"LName\", \"user.png\", \"rt\", \"at\", ?)";
			preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
			preparedStatement.setDate(1, new Date(117, 10, 27));
			preparedStatement.executeUpdate();
		}
		
		query = "insert into " + dbname + ".Account values(\"accid1\", \"rt1\", \"at1\", \"username1\", \"ogs\", \"userid\", ?)";
		preparedStatement = (PreparedStatement) r.getConnection().prepareStatement(query);
		preparedStatement.setDate(1, new Date(117, 10, 27));
		preparedStatement.executeUpdate();
		
		r.deleteUserAccount("userid", "accid1", "ogs");
		
		query = "select * from " + dbname + ".Account where (User_id = \"userid\" and id = \"accid1\" and server = \"ogs\")";
		statement = r.getConnection().createStatement();
		resultSet = statement.executeQuery(query);
		
		assertFalse(resultSet.next());
		
		query = "delete from " + dbname + ".User where id = \"userid\"";
		statement = r.getConnection().createStatement();
		statement.executeUpdate(query);
		
	}
}
