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

}
