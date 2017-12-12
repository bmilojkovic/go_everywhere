package main.java.core;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class GoEverywhereApp extends Application {

	public static final String secretKey = "KSALDJFLKSADJFKLASDJNJDSAFksjfsalkfd";

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		return super.getClasses();
	}
	
	
	
}
