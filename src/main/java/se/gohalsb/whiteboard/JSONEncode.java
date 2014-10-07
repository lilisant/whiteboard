package se.gohalsb.whiteboard;

import java.util.Set;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class JSONEncode implements Encoder.Text<Set<PostIt>> {

	@Override
	public void destroy() {
		System.out.println("Encode destroy!!!  ");
	}

	@Override
	public void init(EndpointConfig ec) {
		System.out.println("Init !!! ");
	}

	@Override
	public String encode(Set<PostIt> postIts) throws EncodeException {
		System.out.println("Encoder ");

		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		for (PostIt posIt : postIts) {
			jsonArrayBuilder.add(Json.createObjectBuilder()
					.add("title", posIt.getTitle())
					.add("description", posIt.getDescription())
					.add("name", posIt.getName())
					.add("color", posIt.getColor())
					.add("category", posIt.getCategory())
					.add("done", posIt.getDone()).add("id", posIt.getId()));
		}
		JsonArray jsonArray = jsonArrayBuilder.build();
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
}
