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
		} while (turn > 2 || turn == 0);
		// 先手、後手の場合分け
		String token;
		switch (turn) {
		case 1:
			token = "○";
		case 2:
			token = "x";
		}
		while (true) {
			System.out.print("次の手を入力してください(行,列　, 終了：quit):");
			Scanner pos = new Scanner(System.in);
			var position = pos.nextLine();
			if (position.equals("quit")) {
				System.out.print("bye");
				break;
			}
			// 座標の取得
			Pair<Integer, Integer> coodinate = coodinate(position);
			// フィールドのインスタンス生成
			Field field = new Field();
			// フィールドの状態変更
			field.changer(coodinate, token, field);
			// フィールドの状態表示
			field.print();
			// 終了判定
			// comTurn
			// フィールドの状態表示
			field.print();
			// 終了判定
		}
	}

	// AI（笑）
	private static void comTurn() {
		// 座標を２つのリスト（0,1,2）, (0,1,2)の各要素の組み合わせから選択
		// 座標の位置のフィールド情報にマルかバツを代入
		// Field.printField();
	}

	// 座標認識用メソッド
	private static Pair<Integer, Integer> coodinate(String position) {
		String[] elems = position.split(",");
		int line = Integer.parseInt(elems[0]);
		int row = Integer.parseInt(elems[1]);
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(line, row);

		return pair;
	}

	// 終了判定
	private static boolean result(Field field) {
		// フィールド情報の取得
		
		// 終了の場合を列挙
		return false;
	}
}

class Field {
	// バトルフィールドの情報保持変数初期化
	private List<String> line1 = List.of("-", "-", "-");
	private List<String> line2 = List.of("-", "-", "-");
	private List<String> line3 = List.of("-", "-", "-");
	// スタティックイニシャライザ
	{
	}

	// ゲッター
	List<String> getLine1() {
		return line1;
	}

	List<String> getLine2() {
		return line2;
	}

	List<String> getLine3() {
		return line3;
	}

	// 状態変更用メソッド
	// 変更するフィールドを指定する
	void changer(Pair<Integer, Integer> position, String token, Field field) {
		int line = position.getFirst();
		int row = position.getSecond();
		List<String> whereLine;

		switch (line) {
		case 0:
			whereLine = field.getLine1();
			this.change(row, token, whereLine);
		case 1:
			whereLine = field.getLine2();
			this.change(row, token, whereLine);
		case 2:
			whereLine = field.getLine3();
			this.change(row, token, whereLine);
		default:
			System.out.println("予期しない入力により終了");
			break;
		}
	}

	// 実際に値を入力する
	void change(int row, String token, List<String> line) {
		line.get(row).replace(line.get(row), token);
	}

	// 表示用メソッド
	void print() {
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
	}

}