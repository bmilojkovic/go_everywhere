package core;

import java.net.URISyntaxException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api")
public class GoEverywhereApp extends Application {

	public GoEverywhereApp() throws URISyntaxException {
		super();	
	}

	
}
