package poli_lecture;

public interface MenuSpec {
	public abstract boolean satisfiedBy(Menu menu);

}

class MenuTypeSpec implements MenuSpec {
	private String menutype;

	public MenuTypeSpec(String menutype) {
		this.menutype = menutype;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return menu.getType().equals(this.menutype);

	}
}

class CalorieOverSpec implements MenuSpec {

	private int menucal;

	CalorieOverSpec(int menucal) {

		this.menucal = menucal;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return (menu.getCal() > menucal);
	}

}

class AndSpec implements MenuSpec {
	private MenuSpec spec1;
	private MenuSpec spec2;

	AndSpec(MenuSpec spec1, MenuSpec spec2) {

		this.spec1 = spec1;
		this.spec2 = spec2;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return spec1.satisfiedBy(menu) && spec2.satisfiedBy(menu);
	}
}

class OrSpec implements MenuSpec {

	private MenuSpec spec1;
	private MenuSpec spec2;

	OrSpec(MenuSpec spec1, MenuSpec spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return spec1.satisfiedBy(menu) || spec2.satisfiedBy(menu);
	}
}

class NotSpec implements MenuSpec {
	private MenuSpec spec;

	NotSpec(MenuSpec spec) {
		this.spec = spec;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return !spec.satisfiedBy(menu);
	}

}