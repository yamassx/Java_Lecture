package lectuer;


import java.util.Hashtable;
import java.util.Map;

public class FruitsAvg {

	public static void main(String[] args) {
		String[] fruitsNames = args;
		
		Map<String, Integer> fruits = new Hashtable<String, Integer>();
		fruits.put("りんご", 200);
		fruits.put("バナナ", 100);
		fruits.put("みかん", 150);
		fruits.put("ぶどう", 300);
		fruits.put("もも", 400);
		
		average(fruitsNames, fruits);
		if(args.length == 0) {
			System.out.println("フルーツの名称を入力してください！");
		}
	}
	private static void average(String[] fruitsNames, Map<String, Integer> fruits) {
		Integer totalPrice  = 0;
		double average ;
			for(String fruitsName: fruitsNames) {
				if(fruits.get(fruitsName) != null) {
					totalPrice += fruits.get(fruitsName);
					
				}else {
					System.out.println(fruitsName + "は私の辞書には存在しません");
				}
			}
			average = (double)totalPrice / (double)fruitsNames.length;	
			if(Double.isNaN(average)==false) {
				System.out.println(average);
			}else {
				System.out.println("無限！！");
			}
	}
}
