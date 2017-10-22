package servers.ogs.user;

import servers.abstraction.user.AbstractUserAccount;

public class OgsUserAccount extends AbstractUserAccount {

	@Override
	public String getServerKey() {
		return "ogs";
	}

	
	
}
