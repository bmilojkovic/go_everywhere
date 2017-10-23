package tests.ogs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import servers.ogs.authentification.OgsAuthProvider;

public class OgsAuthTest {

	private OgsAuthProvider ogsAuthProvide;
	
	public OgsAuthTest() {
		super();
		ogsAuthProvide = new OgsAuthProvider();
	}

	@Test
	public void LoginUserTest() throws InterruptedException, ExecutionException {
		assertNotNull(ogsAuthProvide.asyncAuthorize("go_e_1", "qweqwe").get());
	}
	
	@Test
	public void LoginUserInvalidCredentialsTest() throws InterruptedException, ExecutionException {
		assertNull(ogsAuthProvide.asyncAuthorize("go_e_1", "111111").get());
	}
}
