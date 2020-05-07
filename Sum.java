package lectuer;

public class Sum {

	public static void main(String[] args) {
		try {
			int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
			System.out.println(sum);
		}catch(NumberFormatException ex) {
			System.out.println("不正な入力です");
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("数値を二つ入力してください！");
		}
	}
}
