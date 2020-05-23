package aivick;

import java.util.Collections;
import java.util.List;
class Menu {
	private String name;
	private String type;
	private List<Recipe> recipes;

	Menu(String name, String type, List<Recipe> recipes) {
		this.name = name;
		this.type = type;
		this.recipes = Collections.unmodifiableList(recipes);
	}
	String getName() {
		return this.name;
	}
	String getType() {
		return this.type;
	}
	List<Recipe> getRecipes() {
		return this.recipes;
	}
    double getCal() {
    	double total = 0;
    	for (Recipe recipe : this.recipes) {
    		total += recipe.getCal();
    	}
    	return total;
    }
    @Override
    public String toString() {
    	return this.name;
    }
}
