package lectuer;

import java.util.List;
import java.util.Scanner;

/**
 * このような入力値の評価と出力を繰り返すプログラムをREPL(Read, Eval, Print, Loop)と呼ぶ。
 */
public class ThreeInRow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("三目並べにようこそ");
		int turn;
		do {
			System.out.print("先手・後手を選んでください。先手(1),後手(2):");
			turn = sc.nextInt();
		}while(turn > 2 || turn ==0);
		//先手、後手の場合分け
		//if~~~~~~~~~~~
		while (true) {
			System.out.print("次の手を入力してください(行,列　, 終了：quit):");
			Scanner pos = new Scanner(System.in);
			var position = pos.nextLine();
			if (position.equals("quit")) {
				System.out.print("bye");
				break;
			}
			//フィールドのインスタンス生成
			Field field = new Field();
			//フィールドの状態変更
			//フィールドの状態表示
			System.out.println(coodinate(position));
			//終了判定
			//result();
		}
	}
	
	//AI（笑）
	private static void comTurn() {
		//座標を２つのリスト（0,1,2）, (0,1,2)の各要素の組み合わせから選択
		//座標の位置のフィールド情報にマルかバツを代入
		//Field.printField();
	}
	
	//座標認識用メソッド
	private static Pair<Integer, Integer> coodinate(String position ){
		String[] elems = position.split(",");
		int line = Integer.parseInt(elems[0]);
		int row  = Integer.parseInt(elems[1]);
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(line, row);
		
		return pair;
	}
	
	//終了判定
	private static boolean result() {
		//フィールド情報の取得
		//終了の場合を列挙
		return false;
	}
}
	
class Field {
	//バトルフィールドの情報保持変数初期化
	private List<String> line1 = List.of("-","-","-");
	private List<String> line2 = List.of("-","-","-");
	private List<String> line3 = List.of("-","-","-");
	//スタティックイニシャライザ
	{}
	//ゲッターとセッター
	List<String> getLine1() {
		return line1;
	}
	void setLine1(List<String> line1) {
		this.line1 = line1;
	}
	List<String> getLine2() {
		return line2;
	}
	void setLine2(List<String> line2) {
		this.line2 = line2;
	}
	List<String> getLine3() {
		return line3;
	}
	void setLine3(List<String> line3) {
		this.line3 = line3;
	}
	//状態変更用メソッド
	void change(Pair<Integer, Integer> position, String token) {
		int line = position.getFirst();
		int row = position.getSecond();
		switch(line) {
		 case 0:
		 case 1:
		 case 2:
		 default:
		}
		
	}
	//表示用メソッド
	void print(){
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
	}
	
}