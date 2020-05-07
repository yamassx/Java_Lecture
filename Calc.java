package lectuer;

public class Calc {

	public static void main(String[] args) {
		try {
//		argsをメソッドの引数にできなかったので変数化
			String operator = args[0];
			int x = Integer.parseInt(args[1]);
			int y = Integer.parseInt(args[2]);
//      メソッドの呼び出し
			calclate(operator, x, y);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("演算子と引数２つを入力してください！");
		}catch(NumberFormatException ex){
			System.out.println("不正な入力です");
		}
	}
//		計算、結果表示をするメソッド
	private static void calclate(String operator, int x, int y) {		
		switch(operator) {
			case "+":				
				System.out.println(x + y);
				break;
			case "-":				
				System.out.println(x - y);
				break;
			case "m":				
				System.out.println(x * y);
				break;
			case "/":				
				System.out.println((double)x / (double)y);
				break;
			default:
				System.out.println("不正な入力です");
		}
	}
}
