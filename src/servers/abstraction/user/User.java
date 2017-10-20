package servers.abstraction.user;

public abstract class User extends AbstractUserAccount {

	@Override
	public String getServerKey() {
		return "go-everywhere";
	}
	
	
	
}
