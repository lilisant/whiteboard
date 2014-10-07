package se.gohalsb.whiteboard;

import javax.json.JsonObject;

public class PostIt {
	
	private String title;
	private String description;
	private String name;
	private String color;
	private String category; 
	private boolean done;
	private int id;
		
	public PostIt(int id){
		this.id = id;
	}
	
	public PostIt(String title, String description, String name, String color, String category, boolean done, int id){
		this.category = category;
		this.title = title;
		this.description = description;
		this.name = name;
		this.color = color;
		this.done = done;
		this.id = id;
		
	}

	public PostIt(JsonObject jsondata) {
		this.title = jsondata.getString("title");
		this.description = jsondata.getString("description");
		this.name = jsondata.getString("name");
		this.color = jsondata.getString("color"); 
		this.category =jsondata.getString("category"); 
		this.done = jsondata.getBoolean("done");
		this.id = jsondata.getInt("id");
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void set(PostIt postIt) {
		this.title = postIt.getTitle();
		this.description = postIt.getDescription();
		this.name = postIt.getName();
		this.color = postIt.getColor(); 
		this.category =postIt.getCategory(); 
		this.done = postIt.getDone();
	}	
	
	@Override
	public int hashCode(){
		int result = 1;
		result += result * 37 + id; 
		result += result* 37 + title.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
	  if (o instanceof PostIt) {
		  PostIt p = (PostIt)o;
	    return this.getClass().equals(p.getClass());
	  } else {
	    return false;
	  }
	}
}
