package poli_lecture;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		MenuSet menuSet = new MenuSet(List.of());
		var menus1 = menuSet.getMenusBySpec(new MenuTypeSpec("和食"));
		var menus2 = menuSet.getMenusBySpec(new MenuTypeSpec("洋食"));
		var menus3 = menuSet.getMenusBySpec(new AndSpec(new MenuTypeSpec("和食"), new CalorieOverSpec(100)));
		System.out.println();

	}

}
