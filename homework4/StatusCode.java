package homework4;

import java.util.HashMap;
import java.util.Map;

public class StatusCode {
	private static Map<Integer, String> codes = new HashMap<>() {
		{
			this.put(200, "OK");
		}
	};

	public static void main(String[] args) {
		int code = Integer.parseInt(args[0]);
		messageGetter(code);
	}

	// ゲッター
	static String messageGetter(int code) {

		return codes.get(code);
	}
}
