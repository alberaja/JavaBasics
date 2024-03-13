import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	

	//1: funcion que dado 1 string retorne a single-character string: the letter that occurs twice
	public String solution1ok(String S) {
	        Map<String, Integer> charCounts = new HashMap<>();

	        for (int i = 0; i < S.length(); i++) {
	            String currentChar = String.valueOf(S.charAt(i));
	            if (charCounts.containsKey(currentChar)) {
	                return currentChar;
	            } else {
	                charCounts.put(currentChar, 1);
	            }
	        }
	        return null;
	    }
	
	public String solution2ok(String S) {
	        char[] chars = S.toCharArray();

	        Map<Character, Long> frequencyMap = S.chars()
	                .mapToObj(c -> (char) c)
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	        for (char c : chars) {
	            if (frequencyMap.get(c) == 2) {
	                return Character.toString(c);
	            }
	        }

	        return "";
		}
}
