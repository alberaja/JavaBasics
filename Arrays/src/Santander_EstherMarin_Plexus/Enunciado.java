package Santander_EstherMarin_Plexus;

public class Enunciado {

//	Enunciado codility
	static int enunciadoCodility(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] > X) {
				r = m - 1;
			} else {
				l = m;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

//	Enunciado codility
	static int solutionEnviada(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;		// NO modifico nada
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] >= X) {  // Modificación 1    if (A[m] > X) {
                r = m;		// Modificación 2		r = m - 1;
            } else {
                l = m+1;	// Modificación 3   l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	

}
