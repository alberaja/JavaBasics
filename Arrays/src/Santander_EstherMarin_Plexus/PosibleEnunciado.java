package Santander_EstherMarin_Plexus;

public class PosibleEnunciado {

	static int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] >= X) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	static int solutionCorrejidoCgpt2cambios(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N; // Modificación 1 int r = N - 1;
		while (l < r) { // NO modifica nada. while (l < r) {
			int m = (l + r) / 2;
			System.out.println("m: " + m + ", r: " + r);
			if (A[m] >= X) {
				r = m; // Modificación 2 r = m - 1;
			} else {
				l = m + 1;
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	static int solutionCorrejidoCgpt3cambios(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}
		int l = 0;
		int r = N; // Modificación 1 int r = N - 1;
		while (l < r) { // NO modifica nada. while (l < r) {
			int m = (l + r) / 2;
			System.out.println("m: " + m + ", r: " + r);

			if (A[m] == X) { // if (A[m] >= X) {
				return m; // r = m; // Modificación 2 r = m - 1;
			} /*
				 * else { l = m + 1; }
				 */
			else if (A[m] < X) {
				l = m + 1;
			} else {
				r = m; // Cambio 3: No restamos 1 para incluir el elemento en la búsqueda
			}
		}
		if (A[l] == X) {
			return l;
		}
		return -1;
	}

	

}
