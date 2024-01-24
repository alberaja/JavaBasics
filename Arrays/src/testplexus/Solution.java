package testplexus;

public class Solution {

	public  int solution(int[] A, int X) {
		
		        int N = A.length;
		        if (N == 0) {
		            return -1;
		        }
		        int l = 0;
		        int r = N - 1;
		        while (l < r) {
		            int m = (l + r) / 2;
		            // change 1
		            if (A[m] == X) {
		            	return m;
		            }  // change 2
		            if (A[m] > X) {
		                r = m -1; 
		            } else {
			            // change 3
		                l = m + 1; 
		            }
		        }
//		        if (A[l - 1] == X) {
//		            return l;
//		        }
//		        Original
//		        if (A[l] == X) {
//		            return l;
//		        }
		        return -1;	    

    }
}
