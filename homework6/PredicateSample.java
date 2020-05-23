package aivick;

import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {

	public static void main(String[] args) {
		Predicate<String> isUpCased = (v) -> {return v.toUpperCase().equals(v);};
		Predicate<String> isDownCased = v-> v.toLowerCase().equals(v);
		Predicate<Integer> multipleOfThree = n -> n % 3 == 0;
		Predicate<Integer> multipleOfFive = n -> n % 5 == 0;
		Predicate<Integer> multipleOfFifteen = multipleOfThree.and(multipleOfFive);
//		homework3で作成したメニューMenuオブジェクトを受け取り、和食ならばtrueを返すラムダ式。
		Predicate <Menu> isJapanese = m -> m.getType().equals("和食");
//		homework3で作成したメニューMenuオブジェクトを受け取り、100Kカロリー以上ならばtrueを返すラムダ式。
		Predicate <Menu> isOver100kcal = m -> m.getCal() > 100;
//		homework3で作成したメニューMenuオブジェクトを受け取り、和食かつ100Kカロリー以上ならばtrueを返すラムダ式。
		Predicate <Menu> isJapOver100kcal = isJapanese.and(isOver100kcal);

		System.out.println(isUpCased.test("ABC"));
		System.out.println(isUpCased.test("AbC"));
		System.out.println(isDownCased.test("abc"));
		System.out.println(isDownCased.test("aBc"));
		System.out.println(multipleOfThree.test(9));
		System.out.println(multipleOfThree.test(8));
		System.out.println(multipleOfFive.test(10));
		System.out.println(multipleOfFive.test(9));
		System.out.println(multipleOfFifteen.test(30));
		System.out.println(multipleOfFifteen.test(10));
		System.out.println(isJapanese.test(new Menu("鯖","和食",List.of(new Recipe("さば",100)))));
		System.out.println(isOver100kcal.test(new Menu("鯖","和食",List.of(new Recipe("さば",100)))));
		System.out.println(isJapOver100kcal.test(new Menu("鯖","和食",List.of(new Recipe("さば",100)))));
	}

}
