package servers.ogs;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class OgsWebSocket extends WebSocketClient {

	private HashMap<String, ArrayList<OgsEventListener>> listeners = new HashMap<>();
	
	public OgsWebSocket() throws URISyntaxException {
		super(new URI("wss://online-go.com/socket.io/?transport=websocket"));
	}
	
	public void subscribeOnEvent(String eventKey, OgsEventListener listener) {
		ArrayList<OgsEventListener> listenersList;
		if (listeners.containsKey(eventKey))
			listenersList = listeners.get(eventKey);
		else
			listenersList = listeners.put(eventKey, new ArrayList<>());
		listenersList.add(listener);
	}

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		
	}

	@Override
	public void onError(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String arg0) {
		//parsuj poruku	
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		// TODO Auto-generated method stub
		
	}

}
