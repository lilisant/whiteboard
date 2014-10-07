package se.gohalsb.whiteboard;


public class Message {
	private String message;
	private String type;
	private String data;

	public Message(String s) {
	
	this.message = s;
	}
		
	public Message(String type, String data) {
		this.setType(type);
	    this.setData(data);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isMessage(){
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
