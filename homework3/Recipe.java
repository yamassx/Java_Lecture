package poli_lecture;

class Recipe {
	
	private String name;
	private int    cal;
	
	Recipe(String name, int cal){
		this.name = name;
		this.cal  = cal;
	}

	String getName() {
		return name;
	}

	int getCal() {
		return cal;
	}
	

}
