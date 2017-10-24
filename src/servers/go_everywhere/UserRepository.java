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

import javax.ejb.DuplicateKeyException;

import servers.abstraction.user.AbstractUserAccount;
import servers.abstraction.user.IUserRepository;
import servers.abstraction.user.User;
import servers.abstraction.user.UserAccounts;
import servers.ogs.user.UserAccountFactory;

public class UserRepository implements IUserRepository{
	
	private String user = "root";
	private String pass = " ";
	Connection connection = null;
	private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public UserRepository() {
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		    connection =
		       DriverManager.getConnection("jdbc:mysql://localhost/godb?" +
		                                   "user=" + user + "&password=" + pass);

		    
		} catch (SQLException | ClassNotFoundException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}

	@Override
	public void create(User model) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = "insert into godb.user values(?, ?, ?, ?, ?, ?, ?, ?))";
		
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
		
		//throw new DuplicateKeyException();
	}

	@Override
	public User read(String primaryKey) throws SQLException {
		
		String query = "select * from godb.user where (id = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, primaryKey);
		resultSet = preparedStatement.executeQuery();
		
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

	@Override
	public void update(User model) throws SQLException{
		
		delete(model);
		
		create(model);
				
	}

	@Override
	public void delete(User model) throws SQLException {
		
		String query = "delete from godb.user where(id = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, model.getId());
		
		preparedStatement.executeUpdate();
		
	}

	@Override
	public Collection<User> search(String s) {
		// SVI KORISNICI KOJI U USERNAMEU IMAJU TAJ PODSTRING (MY SQL LIKE)
		return null;
	}

	@Override
	public Collection<AbstractUserAccount> getUserAccounts(String id) throws SQLException {
		// TODO Auto-generated method stub
		
		UserAccountFactory uaf = new UserAccountFactory();
		ArrayList<AbstractUserAccount> accounts = new ArrayList<>();
		String query = "select * from godb.account where (id = ?)";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			String server = resultSet.getString("SERVER");
			String accId = resultSet.getString("ID");
			String username = resultSet.getString("USERNAME");
			Date registrationDate = resultSet.getDate("REGISTRATIONDATE");
			String accessToken = resultSet.getString("ACCESSTOKEN");
			String refreshToken = resultSet.getString("REFRESHTOKEN");
			accounts.add(uaf.getUserAccount(server, accId, username, registrationDate, accessToken, refreshToken));
		}		
		
		return accounts;
	}

	@Override
	public void addUserAccount(String userId, AbstractUserAccount userAccount) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into godb.user values(?, ?, ?, ?, ?, ?))";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, userAccount.getAccessToken());
		preparedStatement.setString(2, userAccount.getId());
		preparedStatement.setString(3, userAccount.getRefreshToken());
		preparedStatement.setString(4, userAccount.getServerKey());
		preparedStatement.setString(5, userAccount.getUsername());
		preparedStatement.setString(6, userId);
				
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
	
	

}
