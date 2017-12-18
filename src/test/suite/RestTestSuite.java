package test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.java.GameControlerTest;
import test.java.LobbyControlerTest;
import test.java.LobbyRoomChatControllerIntegrationTest;
import test.java.RoomControlerTest;
import test.java.UserControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GameControlerTest.class,
	LobbyControlerTest.class,
	LobbyRoomChatControllerIntegrationTest.class,
	RoomControlerTest.class,
	UserControllerTest.class
})

public class RestTestSuite {

}
