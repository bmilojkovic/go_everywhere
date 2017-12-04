package main.java.servers.go_everywhere;

public class DBParameters {
	
	private String username = "root";
	private String password = "";
	private String path = "jdbc:mysql://localhost/godb?";
	private static DBParameters instance = new DBParameters();
	
	public static DBParameters getInstance() {
		return instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
