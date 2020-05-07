package lectuer;

public class Average {

	public static void main(String[] args) {
		try {
			int sum = 0;
			for( String arg : args) {
				sum += Integer.parseInt(arg);
			}
			double average = (double)sum / (double)args.length;
			if (Double.isNaN(average)== false) {
				System.out.println(average);
			}else {
				System.out.println("無限！！！");
			}
		}catch(ArithmeticException ex) {
			System.out.println("不正な計算です");
			
		}finally {
			if(args.length == 0)
				System.out.println("平均をとりたい数値を入力してください！");
		}
	}
}
