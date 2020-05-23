package aivick;

public class Recipe {

	private final String name;
	private final double cal;

	Recipe(String name, int cal){
		this.name = name;
		this.cal = cal;
	}
	String getName() {
		return this.name;
	}
	double getCal() {
		return this.cal;
	}
	@Override
	public String toString() {
		return "(レシピ名：" + this.name + ","+ "カロリー：" + this.cal + "kcal" + ")";
	}
}
