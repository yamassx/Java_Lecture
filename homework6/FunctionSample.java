package aivick;

import java.util.List;
import java.util.function.Function;

public class FunctionSample<T,R> {

	public static void main(String[] args){
		Function<String, Integer> length = (v)-> v.length();
		Function<String, String> upcase = (v) -> v.toUpperCase();
		Function<Integer, Boolean> isEven = (n) -> n % 2 == 0;
		Function<Boolean, Integer> binary = (b) -> {
									if (b == true) {return 0;}else {return 1;}
									};
		Function<Integer, Integer> newBinary = binary.compose(isEven);
		//homework3で作成したメニューMenuオブジェクトを受け取り、そのカロリーを返すラムダ式。
		Function<Menu, Double> getCal = m -> m.getCal();
		//homework3で作成したメニューMenuオブジェクトを受け取り、そのメニューを構成するレシピ名のリストを返すラムダ式。
		Function<Menu, List<Recipe>> getMenus = m -> m.getRecipes();

		System.out.println(length.apply("きれいなお姉さん"));
		System.out.println(upcase.apply("abc"));
		System.out.println(isEven.apply(10));
		System.out.println(isEven.apply(9));
		System.out.println(binary.apply(true));
		System.out.println(binary.apply(false));
		System.out.println(newBinary.apply(10));
		System.out.println(newBinary.apply(9));
		System.out.println(getCal.apply(new Menu("さば","和食",List.of(new Recipe("さば",100)))));
		System.out.println(getMenus.apply(new Menu("さば","和食",List.of(new Recipe("さば",100)))));
	}


}
