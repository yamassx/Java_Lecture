package poli_lecture;

public class Calc {

	public static void main(String[] args) {
		Calculator culc = Calculator.create(args[0]);
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		int result = culc.calculate(x, y);
		
		System.out.println(result);
	}

}

interface Calculator {
	
	public abstract int calculate(int x, int y);
	public static Calculator create(String op) {
		switch (op) {
		case "+": return new Sum();
		case "-": return new Minus();
		case "m": return new Multiple();
		case "/": return new Divide();
		default: throw new IllegalArgumentException("不正な入力");
		}
	}
}

class Sum implements Calculator {
	@Override
	public int calculate(int x, int y) {
		return x + y;
	}
}

class Minus implements Calculator {
	@Override
	public int calculate(int x, int y) {
		return x - y;
	}
}

class Multiple implements Calculator {
	@Override
	public int calculate(int x, int y) {
		return x * y;
	}
}

class Divide implements Calculator {
	@Override
	public int calculate(int x, int y) {
		return x / y;
	}
}
