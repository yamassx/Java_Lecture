package homework4;

public class Pair<T, S> {

	private final T first;
	private final S second;

	public Pair(T first, S second) {

		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return this.first;
	}

	public S getSecond() {
		return this.second;
	}
	
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return "(" + this.getFirst() + "," + this.getSecond() + ")" ;
	}
	
}
