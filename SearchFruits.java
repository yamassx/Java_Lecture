package lectuer;


import java.util.*;

public class SearchFruits {

	public static void main(String[] args) {
		try {
			int price = Integer.parseInt(args[0]);
			
			Map<String, Integer> fruits = new Hashtable<String, Integer>();
			fruits.put("りんご", 200);
			fruits.put("バナナ", 100);
			fruits.put("みかん", 150);
			fruits.put("ぶどう", 300);
			fruits.put("もも", 400);
			
			suggest(price, fruits);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("数値を入力してください！");
		}catch(NumberFormatException ex) {
			System.out.println("不正な入力です");
		}
	}
	private static void suggest(int price, Map<String, Integer> fruits ) {
		for (Map.Entry <String, Integer> entry : fruits.entrySet()) {
			if(price <= entry.getValue()) {
				System.out.print(entry.getKey() + " ");
			}else {
				continue;
			}
		}
		
	}
}
