package homework4;

public class Main {

	public static void main(String[] args) {
		NumPair<Integer, Integer> numpair = new NumPair<>(3,5);
		System.out.println(numpair.toString());
		NumPair<Double, Double> doublepair = new NumPair<>(3.3,5.5);
		System.out.println(doublepair.toString());
		
//		NumPair<String, String> stringpair = new NumPair<String, String>("3","5");
//		System.out.println(stringpair.toString());
		
	}
}
