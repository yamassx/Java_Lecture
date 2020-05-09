package lectuer;

public class PairMain {

	public static void main(String[] args) {
		Pair<Integer, Integer> pair = new Pair<>(1, 2);
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());
		System.out.println(pair.toString());
	}
}
