package lectuer;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	public static void main(String[] args) {
		var intList = List.of(1, 2, 3, 4, 5, 6, 7);

		List<Integer> evenList = ListUtil.evensof(intList);
		for (Integer e : evenList) {
			System.out.println(e);
		}
		System.out.println(replicate(5, "金"));
		System.out.println(zip(List.of(1, 4, 7), List.of(2, 5, 8)));
		System.out.println(factors(36));
		System.out.println(perfects(496));

//pairsの動作確認		
		System.out.println(pairs(List.of(1, 2, 3, 4)));
		System.out.println(pairs(List.of("A", "B", "C")));
//isSorted動作確認
		System.out.println(isSorted(List.of(1, 2, 3, 4)));
		System.out.println(isSorted(List.of(5, 6, 4, 7)));
//positions動作確認	
		System.out.println(positions(10, List.of(10, 15, 20, 10, 10, 33)));
	}

	private static List<Integer> evensof(List<Integer> intList) {
		List<Integer> evensList = new ArrayList<>();
		for (Integer e : intList) {
			if (e % 2 == 0) {
				evensList.add(e);
			}
		}
		return evensList;
	}

	private static List<String> replicate(int length, String value) {

		List<String> anyValueList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			anyValueList.add(value);
		}
		return anyValueList;
	}

	private static List<Pair<Integer, Integer>> zip(List<Integer> first, List<Integer> second) {
		List<Pair<Integer, Integer>> pairs = new ArrayList<>();
		int pairIndex = Math.min(first.size(), second.size());

		for (int i = 0; i < pairIndex; i++) {
			Pair<Integer, Integer> value = new Pair<>(first.get(i), second.get(i));
			pairs.add(value);
		}
		return pairs;
	}

	private static List<Integer> factors(int value) {
		if (value == 0) {
			return List.of(0, 0, 0, 0, 0);
		}
		List<Integer> factors = new ArrayList<>();

		for (int factor = 1; factor < value; factor++) {
			if (value % factor == 0) {
				factors.add(factor);
			}
		}
		factors.add(value);
		return factors;
	}

	private static List<Integer> perfects(int max) {
		List<Integer> perfects = new ArrayList<>();
		for (int i = 1; i <= max; i++) {
			int sum = 0;
			List<Integer> factors = ListUtil.factors(i);
			for (int factor : factors) {
				sum += factor;
			}
			if (sum - i == i) {
				perfects.add(i);
			}
		}
		return perfects;
	}

	private static <T> List<Pair<T, T>> pairs(List<T> list) {
		List<Pair<T, T>> pairs = new ArrayList<>();
		for (int i = 0; i < list.size() - 1; i++) {
			Pair<T, T> pair = new Pair<>(list.get(i), list.get(i + 1));
			pairs.add(pair);
		}
		return pairs;
	}

	private static boolean isSorted(List<Integer> list) {
		List<Pair<Integer, Integer>> pairs = ListUtil.pairs(list);
		boolean result = true;
		for (Pair<Integer, Integer> pair : pairs) {
			int first = pair.getFirst();
			int second = pair.getSecond();
			if (first > second) {
				result = false;
				break;
			}
		}
		return result;
	}

	private static List<Integer> positions(int value, List<Integer> list) {
		List<Integer> index = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			index.add(i);
		}
		List<Pair<Integer, Integer>> forMap = ListUtil.zip(list, index);
		for (Pair<Integer, Integer> pair : forMap) {
			if (pair.getFirst() == value) {
				result.add(pair.getSecond());
			}
		}
		return result;
	}
}