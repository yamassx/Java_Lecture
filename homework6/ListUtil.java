package aivick;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

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
		//scalarProduct動作確認
		System.out.println(scalarProduct(List.of(1, 2, 3), List.of(4, 5, 6)));
		//zip4動作確認
		var tetrads = zip4(List.of(1, 2, 3), List.of(10, 20, 30), List.of(100, 200, 300), List.of(1000, 2000, 3000));
		var firstTetrad = tetrads.get(0); //リストの最初の４つ組
		var first = firstTetrad.getFirst(); //1
		var tuple = firstTetrad.getSecond();
		var second = tuple.getFirst(); //10
		var pair = tuple.getSecond();
		var third = pair.getFirst(); //100
		var fourth = pair.getSecond(); //1000
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println(fourth);
	}

	public static List<Integer> evensof(List<Integer> intList) {
		//		List<Integer> evensList = new ArrayList<>();
		//		for (Integer e : intList) {
		//			if (e % 2 == 0) {
		//				evensList.add(e);
		//			}
		return intList.stream()
				.filter(e -> e % 2 == 0)
				.collect(toList());
	}

	public static List<String> replicate(int length, String value) {
		/*List<String> anyValueList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			anyValueList.add(value);
		}
		return anyValueList;*/
		return IntStream.range(0, length).mapToObj(i -> value).collect(toList());
	}

	public static <F, S> List<Pair<F, S>> zip(List<F> first, List<S> second) {
		/*		List<Pair<F, S>> pairs = new ArrayList<>();
				int pairIndex = Math.min(first.size(), second.size());
				for (int i = 0; i < pairIndex; i++) {
					Pair<F, S> value = new Pair<F, S>(first.get(i), second.get(i));
					pairs.add(value);
				}
				return pairs;
		*/ /*}*/
		return IntStream.range(0, Math.min(first.size(), second.size()))
				.mapToObj(i -> new Pair<>(first.get(i), second.get(i)))
				.collect(toList());
	}

	public static List<Integer> factors(int value) {
		if (value == 0) {
			return List.of(value);
		}
		/*		List<Integer> factors = new ArrayList<>();
				for (int factor = 1; factor <= value; factor++) {
					if (value % factor == 0) {
						factors.add(factor);
					}
				}
				return factors;*/
		//なぜvalue+ 1 ?
		return IntStream.range(1, value + 1).filter(i -> value % i == 0).mapToObj(i -> Integer.valueOf(i))
				.collect(toList());
	}

	public static List<Integer> perfects(int max) {
		/*List<Integer> perfects = new ArrayList<>();
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
		return perfects;*/
		return IntStream.range(1, max + 1).filter(i -> total(ListUtil.factors(i)) - i == i)
				.boxed()
				.collect(toList());
	}

	public static int total(List<Integer> list) {
		/*int total = 0;

		for(int elem: list) {
			total += elem;
		}

		return total;*/
		return list.stream()
				.mapToInt(e -> Integer.valueOf(e))
				.sum();
	}

	public static <T> List<Pair<T, T>> pairs(List<T> list) {
		/*List<Pair<T, T>> pairs = new ArrayList<>();
		for (int i = 0; i < list.size() - 1; i++) {
			Pair<T, T> pair = new Pair<>(list.get(i), list.get(i + 1));
			pairs.add(pair);
		}
		return pairs;*/
		return IntStream.range(0, list.size() - 1)
				.mapToObj(i -> new Pair<>(list.get(i), list.get(i + 1)))
				.collect(toList());
	}

	public static boolean isSorted(List<Integer> list) {
		/*List<Pair<Integer, Integer>> pairs = ListUtil.pairs(list);
		boolean result = true;
		for (Pair<Integer, Integer> pair : pairs) {
			int first = pair.getFirst();
			int second = pair.getSecond();
			if (first > second) {
				result = false;
				break;
			}
		}
		return result;*/
		return pairs(list).stream()
				.noneMatch(e -> e.getFirst() > e.getSecond());
	}

	public static List<Integer> positions(int value, List<Integer> list) {
		/*List<Integer> index = new ArrayList<>();
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
		return result;*/
		var index = IntStream.range(0, list.size())
				.boxed()
				.collect(toList());
		return ListUtil.zip(index, list)
				.stream()
				.filter(e -> e.getSecond().equals(value))
				.map(Pair::getFirst)
				.collect(toList());
		/*return list.stream()
				   .entryMap()
				   .filter(e -> e.getValue() == value)
				   .collect(toList())
				   .stream()
				   .forEach(e -> e.getKey())
				   .collect(toList());*/
	}

	public static int scalarProduct(List<Integer> v1, List<Integer> v2) {
		/*List<Pair<Integer, Integer>> pairList = ListUtil.zip(v1, v2);
		int innerProduct = 0;
		for (Pair<Integer, Integer> pair : pairList) {
			innerProduct += pair.getFirst() * pair.getSecond();
		}
		return innerProduct;*/
		return ListUtil.zip(v1, v2)
						.stream()
						.mapToInt(p -> p.getFirst()* p.getSecond())
						.sum();
	}

	public static List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> zip4(List<Integer> first,
			List<Integer> second, List<Integer> third, List<Integer> fourth) {

		/*	return ListUtil.zip(first, ListUtil.zip(second, ListUtil.zip(third, fourth)));*/

		return IntStream.range(0,first.size())
						.mapToObj(i -> new Pair<>(first.get(i), new Pair<>(second.get(i),new Pair<>(third.get(i), fourth.get(i)))))
						.collect(toList());
	}
}
