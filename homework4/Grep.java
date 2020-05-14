package homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Grep {

	public static void main(String[] args) {
		Path filePath       = Path.of(args[0] + "*" + "*.text");
		Path directFilePath = Path.of(args[0] + "*.text");
		String forGrep = args[1];
		Map<Path, List<Integer>> map1 = search(filePath, forGrep);
		print(map1);
		Map<Path, List<Integer>> map2 = search(directFilePath, forGrep);
		print(map2);
	}
	private static Map<Path, List<Integer>> search(Path path, String chars){
		try (BufferedReader br = Files.newBufferedReader(path)) {
			String line;
			Map<String, List<Integer>> map = new HashMap<>();
			while ((line = br.readLine()) != null) {
				
				
			}
			return map;
		}
	}
	
	private static void print(Map<Path, List<Integer>> map) {
		for(Map.Entry<Path, List<Integer>> entry : map.entrySet()) {
			System.out.print(entry.getKey().toString() + " ");
			entry.getValue().stream()
							.forEach(e -> System.out.println(e + " "));
		}
	}
}
