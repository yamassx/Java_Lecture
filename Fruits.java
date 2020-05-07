package lectuer;
import java.util.*;
public class Fruits {

	public static void main(String[] args) {
		try {
			String name = args[0];
			
			Map<String, Integer> fruits = new Hashtable<String, Integer>();
			fruits.put("りんご", 200);
			fruits.put("バナナ", 100);
			fruits.put("みかん", 150);
			fruits.put("ぶどう", 300);
			fruits.put("もも", 400);
			
			if (fruits.get(name) != null) {
				System.out.println(fruits.get(name));
			}else {
				System.out.println("そんなものありまへん");
			}
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("値段を見たいフルーツの名称を入力してください！");
		}
		
	}

}
