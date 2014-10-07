package se.gohalsb.whiteboard;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class JSONDecode implements Decoder.Text<Message> {

	@Override
	public void destroy() {
		System.out.println("Decode destroy!!!  ");	
	}

	@Override
	public void init(EndpointConfig ec) {
		System.out.println("Init !!! ");	
	}

	@Override
	public Message decode(String message) throws DecodeException {
		System.out.println("Decode!!! ");
		JsonObject json = Json.createReader(new StringReader(message)).readObject();
		System.out.println("Decoder " + json.get("type").toString() + "Decoder " + json.get("data").toString()); 
		return new Message(json.get("type").toString(), json.get("data").toString());
	}

	@Override
	public boolean willDecode(String message) {
		System.out.println("willDecode!!! ");
		try{
			Json.createReader(new StringReader(message)).readObject();
		}catch(JsonException e)
		{
			 return false;
		}
		return true;
	}
	

}
