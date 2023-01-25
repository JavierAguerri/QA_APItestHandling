package swaggerAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetList {
	private List<Pet> petList;
	
	public ArrayList<PetIdName> petsByStatusIdName(String status) {
		ArrayList<PetIdName> petIdNameList = new ArrayList<PetIdName>();
		for(Pet pet : this.petList) {
			if (pet.getStatus().equals("sold")) {
				petIdNameList.add(pet.getIdName());
		  	}
		}
		return petIdNameList;
	}
	
	public Map<String, Integer> getNameCount() {
	    Map<String, Integer> nameCount = new HashMap<>();
	    for (Pet pet : this.petList) {
	        String name = pet.getName();
	        if (nameCount.containsKey(name) && name!=null) {
	            nameCount.put(name, nameCount.get(name) + 1);
	        } else {
	            nameCount.put(name, 1);
	        }
	    }
	    // remove names that occur only once
	    nameCount.values().removeIf(count -> count == 1);
	    return nameCount;
	}
	
	public PetList(List<Pet> pets) {
        this.petList = pets;
    }
}
