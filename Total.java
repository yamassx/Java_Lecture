package lectuer;

public class Total {

	public static void main(String[] args) {
		try {
			int total = 0;
			for (String arg : args) {
				total += Integer.parseInt(arg);
			}
			if(args.length == 0) {
				System.out.println("値を入力してください！");
			}else {
				System.out.println(total);
			}	
		}catch(NumberFormatException ex) {
			System.out.println("不正な入力です");
		}
	}
}
