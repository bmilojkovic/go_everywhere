package servers.go_everywhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import servers.abstraction.user.AbstractUserAccount;
import servers.abstraction.user.IUserRepository;
import servers.abstraction.user.User;
import servers.ogs.user.UserAccountFactory;

public class UserRepository implements IUserRepository{

	private String user = "root";
	private String pass = "";
	Connection connection = null;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
	public UserRepository() {
				
		try {
						
		    connection =
		       DriverManager.getConnection("jdbc:mysql://localhost/godb?" +
		                                   "user=" + user + "&password=" + pass);

		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public String simpleQuery() throws Exception{
		
        /*ArrayList<User> list = (ArrayList<User>) search("p");
        for (User user : list) {
			System.out.println(user.getUsername());
		}*/
		
		//User user = new User("2", "xgrizx", new Date(117, 2, 2),"3", "3", "", "", "Aleksandar", "Ogrizovic");
		//User user2 = new User("qwerty", "jooooifications", new Date(117, 10, 27), "at", "rt", "ogs", "jovana.png", "Jovana", "Mihaljcic");
		
		
		User user = new User("userid", "username", new Date(117, 10, 27), "at", "rt", "ogs", "user.png", "FName", "LName");
		create(user);
		delete(user);
		delete(user);
		
		//delete(user2);
		
		//User u = read("s");
		//User user = new User("yyyy", "limetine", new Date(117, 5, 2), "yy", "yy", "", "anna.png", "Annamaria", "Uri");
		
		//delete(user);
		
//		Statement statement;
//		ResultSet resultSet;
//		
//		String query = "insert into godb.account values(\"y1\", \"yy\", \"yy\", \"limetine\", \"ogs\", \"dddd\")";
//		statement =connection.createStatement();
//		statement.executeUpdate(query);
//		
		//deleteUserAccount("yyyy", "y1", "ogs");
		
		connection.close();
		
		return "Pljas";
		
	}

	@Override
	public void create(User model) throws SQLException  {
		// TODO Auto-generated method stub
		
		String query = "insert into godb.user values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, model.getId());
		preparedStatement.setString(2, model.getUsername());
		preparedStatement.setString(3, model.getFirstName());
		preparedStatement.setString(4, model.getLastName());
		preparedStatement.setString(5, model.getPictureUrl());
		preparedStatement.setString(6, model.getRefreshToken());
		preparedStatement.setString(7, model.getAccessToken());
		preparedStatement.setDate(8, model.getRegistrationDate());
		
		preparedStatement.executeUpdate();
	}

	@Override
	public User read(String primaryKey) throws SQLException {
		
		String query = "select * from godb.user where (id = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, primaryKey);
		resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {		
			String id = resultSet.getString("ID");
			String username = resultSet.getString("USERNAME");
			Date registrationDate = resultSet.getDate("REGISTRATIONDATE");
			String accessToken = resultSet.getString("ACCESSTOKEN");
			String refreshToken = resultSet.getString("REFRESHTOKEN");
			String serverKey = "";
			String pictureUrl = resultSet.getString("PICTUREURL");
			String firstName = resultSet.getString("FIRSTNAME");
			String lastName = resultSet.getString("LASTNAME");
			User user = new User(id, username, registrationDate, accessToken,refreshToken, serverKey, pictureUrl, firstName, lastName);
			return user;
		}
		
		
		return null;
	}

	@Override
	public void update(User model) throws SQLException{
		
		String query = "update godb.user set username = ?, firstname = ?, lastname = ?, pictureurl = ?, refreshtoken = ?, accesstoken = ?, registrationdate = ?  where (id = ?)";
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, model.getUsername());
		preparedStatement.setString(2, model.getFirstName());
		preparedStatement.setString(3, model.getLastName());
		preparedStatement.setString(4, model.getPictureUrl());
		preparedStatement.setString(5, model.getRefreshToken());
		preparedStatement.setString(6, model.getAccessToken());
		preparedStatement.setDate(7, model.getRegistrationDate());
		preparedStatement.setString(8, model.getId());
		
		preparedStatement.executeUpdate();
				
	}

	@Override
	public void delete(User model) throws SQLException {
		
		String query = "delete from godb.account where(user_id = ?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, model.getId());
		
		preparedStatement.executeUpdate();
		
		query = "delete from godb.user where(id = ?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, model.getId());
		
		preparedStatement.executeUpdate();
				
	}

	@Override
	public Collection<User> search(String s) throws SQLException {		
		
		ArrayList<User> users = new ArrayList<>();
		String query = "select * from godb.user where username like \"%" + s + "%\" ";
		
		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			String id = resultSet.getString("ID");
			String username = resultSet.getString("USERNAME");
			String firstName = resultSet.getString("FIRSTNAME");
			String lastName = resultSet.getString("LASTNAME");
			String pictureUrl = resultSet.getString("PICTUREURL");
			String accessToken = resultSet.getString("ACCESSTOKEN");
			String refreshToken = resultSet.getString("REFRESHTOKEN");
			Date registrationDate = resultSet.getDate("REGISTRATIONDATE");
			users.add(new User(id, username, registrationDate, firstName, lastName, pictureUrl, refreshToken, accessToken, " "));
		}		
		
		return users;
		
	}

	@Override
	public Collection<AbstractUserAccount> getUserAccounts(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		UserAccountFactory uaf = new UserAccountFactory();
		ArrayList<AbstractUserAccount> accounts = new ArrayList<>();
		String query = "select * from godb.account where (user_id = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();
				
		while (resultSet.next()) {
			String server = resultSet.getString("SERVER");
			String accId = resultSet.getString("ID");
			String username = resultSet.getString("USERNAME");
			String accessToken = resultSet.getString("ACCESSTOKEN");
			String refreshToken = resultSet.getString("REFRESHTOKEN");
			String userId = resultSet.getString("USER_ID");
			Date registrationDate = resultSet.getDate("REGISTRATIONDATE");
			accounts.add(uaf.getUserAccount(server, accId, username, registrationDate, accessToken, refreshToken, userId));
		}		
		
		return accounts;
	}

	@Override
	public void addUserAccount(String userId, AbstractUserAccount userAccount) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into godb.account values(?, ?, ?, ?, ?, ?,?)";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, userAccount.getId());
		preparedStatement.setString(2, userAccount.getRefreshToken());
		preparedStatement.setString(3, userAccount.getAccessToken());
		preparedStatement.setString(4, userAccount.getUsername());
		preparedStatement.setString(5, userAccount.getServerKey());
		preparedStatement.setString(6, userId);
		preparedStatement.setDate(7, userAccount.getRegistrationDate());
				
		preparedStatement.executeUpdate();
		
	}

	@Override
	public void deleteUserAccount(String userId, String accountId, String serverId) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "delete from godb.account where(id = ? and User_id = ? and server = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, accountId);
		preparedStatement.setString(2, userId);
		preparedStatement.setString(3, serverId);
		
		preparedStatement.executeUpdate();
		
	}

	
	public Connection getConnection() {
		return connection;
	}

	
	
	
	

}
