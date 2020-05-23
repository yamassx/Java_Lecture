package aivick;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Recipe macarel = new Recipe("さば", 100);
		Recipe radish = new Recipe("おろし", 5);
		Recipe spMacarel = new Recipe("さわら", 150);
		Recipe source = new Recipe("バターソース", 100);

		List<Recipe> macarelPackage = List.of(macarel, radish);
		List<Recipe> spMacarelPackage = List.of(spMacarel, source);

		Menu grilledMacarel = new Menu("鯖の塩焼き", "和食",macarelPackage);
		Menu grilledSpMacarel = new Menu("鰆のムニエル","洋食", spMacarelPackage);

		MenuSet menuset = new MenuSet(List.of(grilledMacarel,grilledSpMacarel));

//ラムダ式使用
//		MenuSpec japType = m -> m.getType().equals("和食");

//無名クラス使用
		MenuSpec japType = new MenuSpec(){
								@Override
								public boolean satisfiedBy(Menu menu) {
									return menu.getType().equals("和食");
									};
		                        };
		MenuSpec over100kcal = m -> m.getCal() > 100;

//ラムダ式不使用
		//MenuSpec japOver100kcal = new AndSpec(japType, over100kcal);
//ラムダ式を使用
		MenuSpec japOver100kcal = m ->  m.getType().equals("和食") && m.getCal() > 100;

		List<Menu> japTypeMenus = menuset.getMenusBySpec(japType);
		List<Menu> over100kcalMenus = menuset.getMenusBySpec(over100kcal);
		List<Menu> japOver100kcalMenus = menuset.getMenusBySpec(japOver100kcal);

		System.out.println(japTypeMenus);
		System.out.println(over100kcalMenus);
		System.out.println(japOver100kcalMenus);
//課題ここまで

//test
		List<Menu> japMenus = new ArrayList<>();
        MenuSpec target = new JapaneseSpec();
        for(Menu menu : menuset.getMenus()){
           if(target.satisfiedBy(menu)){
              japMenus.add(menu);
           }
        }
           System.out.println(japMenus);

	}

}
