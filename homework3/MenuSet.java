package poli_lecture;

import java.util.ArrayList;
import java.util.List;

public class MenuSet {
	private List<Menu> menus;
	
	MenuSet(List<Menu> menus){
		this.menus = menus;
	}
	
	List<Menu> getMenusByType(String type){
		List<Menu> anyTypeMenu = new ArrayList<Menu>();
		for (Menu menu : this.menus) {
			if(menu.getType().equals(type)) {
				anyTypeMenu.add(menu);
			}
		}
		return anyTypeMenu;
	}
	
	List<Menu> getMenusByOverCalorie(int cal){
		List<Menu> overCalMenu = new ArrayList<Menu>();
		for (Menu menu : this.menus) {
			if(menu.getCal() > cal) {
				overCalMenu.add(menu);
			}
		}
		return overCalMenu;
	}
	
	List<Menu> getMenusBySpec(MenuSpec spec){
		List<Menu> anySpecMenu = new ArrayList<Menu>();
		for(Menu menu : this.menus) {	
			if (spec.satisfiedBy(menu) == true) {					
				anySpecMenu.add(menu);	
			}
		}
		return anySpecMenu;
	}
}
