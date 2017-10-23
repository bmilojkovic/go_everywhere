package servers.go_everywhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.ejb.DuplicateKeyException;

import servers.abstraction.user.AbstractUserAccount;
import servers.abstraction.user.IUserRepository;
import servers.abstraction.user.User;
import servers.abstraction.user.UserAccounts;

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
	public void create(User model) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		
		throw new DuplicateKeyException();
	}

	@Override
	public User read(String primaryKey) throws SQLException {
		
		String query = "";
		
		statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		
		String id = resultSet.getString("ID");
		String username;
		Date registrationDate;
		String accessToken;
		String refreshToken;
		String serverKey;
		
		 User user = new User(id, username, registrationDate, accessToken,refreshToken, serverKey);
		
		return null;
	}

	@Override
	public void update(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<User> search(String s) {
		// SVI KORISNICI KOJI U USERNAMEU IMAJU TAJ PODSTRING (MY SQL LIKE)
		return null;
	}

	@Override
	public Collection<AbstractUserAccount> getUserAccounts(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserAccount(String userId, AbstractUserAccount userAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserAccount(String userId, String accountId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
