package swaggerAPI;
import java.util.List;

import com.google.gson.Gson;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
	
	class Category { 
		private long id;
		private String name;
	} 
	
	class Tag { 
		private long id;
		private String name;
	} 
	
	public String getStatus() {
		return this.status;
	}
	
	public String getName() {
		return this.name;
	}
	
	public PetIdName getIdName(){
        PetIdName petIdName = new PetIdName(this.id, this.name);
        return petIdName;
    }
	
    public static Pet fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Pet.class);
    }
}
