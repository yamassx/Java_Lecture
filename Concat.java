package lectuer;

public class Concat {

	public static void main(String[] args) {
		String concat = "";
		for(String arg : args) {
			concat += arg;
		}
		if(concat == "") {
			System.out.println("文字列が入力されていません");
		}else {
			System.out.println(concat);
		}
	}
}
