package lectuer;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	public static void main(String[] args) {
		var intList = List.of(1,2,3,4,5,6,7);
		
		List <Integer> evenList = ListUtil.evensof(intList);
		for (Integer e :evenList) {
			System.out.println(e);
		}
		System.out.println(replicate(5, "金"));
		System.out.println(zip(List.of(1,4,7), List.of(2,5,8)));
		System.out.println(factors(36));
		System.out.println(perfects(500));
//		System.out.println(pairs(List.of(1,2,3,4)));
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		System.out.println(pairs(list));
	}
	
	private static List<Integer> evensof(List<Integer> intList){
		List<Integer> evensList= new ArrayList<>();
		for (Integer e :intList) {
			if (e % 2 == 0) {
				evensList.add(e);
			}
		}
		return evensList;
	
	}
	
	private static List<String> replicate(int length, String value){
		
		List<String> anyValueList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			anyValueList.add(value);
		}
		return anyValueList;
	}
	
	private static List<List<Integer>> zip (List<Integer> first, List<Integer> second){
		List<List<Integer>> pair  = new ArrayList<>();
		int pairIndex = Math.min(first.size(), second.size());
		
		for (int i = 0; i < pairIndex; i++) {
			List<Integer> value = new ArrayList<>();
			value.add(first.get(i));
			value.add(second.get(i));
			pair.add(value);
		}
		return pair;
	}
	
	private static List<Integer> factors(int value) {
		List<Integer> factors = new ArrayList<>();
		if (value != 0) {
			for(int factor = 1; factor < value; factor++) {
				if (value % factor == 0) {
					factors.add(factor);
					continue;
				}
			}
			factors.add(value);
		}
		return factors;
	}
	
	private static List<Integer> perfects(int max) {
		List <Integer> perfects = new ArrayList<>();
		for(int i=1; i < max + 1; i++) {
			int sum = 0;
			List<Integer> factors = ListUtil.factors(i);
			for(int factor : factors) {
				sum += factor;
			}
			if (sum == 2*i) {
				perfects.add(i);
			}
		}
		return perfects;
	}
	
	private static List<Pair<T,T>> pairs(List list){
		List<Pair<T,T>> pairs = new ArrayList<>();	
		for (int i = 0; i< list.size - 1; i++) {
			pairs.add(Pair(list[i], list[i+1]));	
		}
		return pairs;
	}
}