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

public class CountCharacter {
	public static void main(String[] args) {
		Path filePath = Path.of(args[0]);
		List<String> characters = List.of("a", "b", "z", "あ");
		Map<String, Integer> map = search(filePath, characters);
		print(map);
	}

	private static Map<String, Integer> search(Path path, List<String> characters) throws IOException{
		try (BufferedReader br = Files.newBufferedReader(path)) {
			String line;
			Map<String, Integer> map = new HashMap<>();
			while ((line = br.readLine()) != null) {
				for (String c : characters) {
					List<String> charList = new ArrayList<>();
					if(line.equals(c)) {
						charList.add(c);
						map.put(c,charList.size());
					}
				}
			}
			return map;
		}
	}

	private static void print(Map<String, Integer> map) {
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.toString());
		}
	}
}
