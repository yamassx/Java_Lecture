package lectuer;
import java.util.*;

public class Sort2 {

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<Integer>();
		for(String arg : args) {
			array.add(Integer.parseInt(arg));
		}
		Collections.sort(array);
		for (int number :array) {
			System.out.print(number + " ");
		}
	}

}
