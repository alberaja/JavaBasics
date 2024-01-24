package Codility_ThreeLetters;

public class Solution {

	public  String solution(int A, int B) {
		
		StringBuilder result = new StringBuilder();
        char aChar = 'a';
        char bChar = 'b';

        while (A > 0 || B > 0) {
            // Check which character to append based on the count and previous characters
            if (A > B) {
                if (result.length() >= 2 && result.charAt(result.length() - 1) == aChar && result.charAt(result.length() - 2) == aChar) {
                    result.append(bChar);
                    B--;
                } else {
                    result.append(aChar);
                    A--;
                }
            } else {
                if (result.length() >= 2 && result.charAt(result.length() - 1) == bChar && result.charAt(result.length() - 2) == bChar) {
                    result.append(aChar);
                    A--;
                } else {
                    result.append(bChar);
                    B--;
                }
            }
        }

        return result.toString();   

    }
}
