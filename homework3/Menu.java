package poli_lecture;

import java.util.List;

class Menu {
	private String       name;
	private String       type;
	private List<Recipe> recipes;
	private int          cal;
	
	Menu(String name, String type, List<Recipe> recipes) {
		
		this.name = name;
		this.type = type;
		this.recipes = recipes;
	}

	String getName() {
		return name;
	}

	String getType() {
		return type;
	}

	List<Recipe> getRecipes() {
		return recipes;
	}

	int getCal() {
		return cal;
	}
	
	
}
