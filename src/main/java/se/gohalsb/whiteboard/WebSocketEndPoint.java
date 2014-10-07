package se.gohalsb.whiteboard;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.*;

@ServerEndpoint(value = "/whiteboard", encoders = JSONEncode.class, decoders = JSONDecode.class)
public class WebSocketEndPoint {
	// contains list of active sessions
	private static List<Session> sessions = Collections
			.synchronizedList(new ArrayList<Session>());

	@OnOpen
	public void onOpen(Session session) {
		// session.get
		sessions.add(session);
		System.out.println("I works  = " + session);
		System.out
				.println("Open session : no of sessions = " + sessions.size());
	}

	@OnMessage
	public void onMessage(Message message, Session session) throws IOException, EncodeException {

		switch (message.getType()) {
		
		case "\"post\"":
			System.out.println("Update postIt");
			Whiteboard.upPostIt(new PostIt(Json.createReader(
					new StringReader(message.getData())).readObject()));
			break;
			
		case "\"delete\"":
			System.out.println("Delete postIt id = " + message.getData());
			Whiteboard.delePostIt(Integer.parseInt(message.getData()));
			System.out.println("After delete a postIt");
			break;
			
		case "\"put\"":
			System.out.println("Create a postIt");
			Whiteboard.addPostIt(new PostIt(Json.createReader(
					new StringReader(message.getData())).readObject()));
			break;

		default:
			System.out.println("no method like this:"+ message.getType());
			break;
		}

		try {
			for (Session s : session.getOpenSessions()) {
				if (s.isOpen()) {
					s.getBasicRemote().sendObject(Whiteboard.postIts);
				}
			}
		} catch (EncodeException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session s) {
		sessions.remove(s); // remove session from the active session list.
	}

}