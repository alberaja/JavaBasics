package Codility_ThreeLetters;


import testplexus.StatementPlexusCodility;

public class ThreeLetters {

//	https:// app.codility.com/programmers/trainings/5/three_letters/
//	Write a
//	function solution that,
//	given two
//	integers A
//	and B, returns
//	a string
//	containing exactly
//	A letters'a'
//	and exactly
//	B letters'b'
//	with no
//	three consecutive
//	letters being
//
//	the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).
//
//		Examples:
//
//		1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.
//
//		2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.
//
//		3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.
//
//		Assume that:
//
//		A and B are integers within the range [0..100];
//		at least one solution exists for the given A and B.
		
//	prueba de main
	public static void main(String[] args) {
		// 
		Solution solution = new Solution();

        System.out.println(solution.solution(5, 3)); // Example 1
        System.out.println(solution.solution(3, 3)); // Example 2
        System.out.println(solution.solution(1, 4)); // Example 3
	}

}
