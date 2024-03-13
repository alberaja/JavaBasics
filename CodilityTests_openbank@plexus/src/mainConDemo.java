import java.util.Arrays;

public class mainConDemo {

	public static <E> void main(String[] args) {
		int[] A = { 1, 2, 3 };
		try {
			int demo = solution(A);
			System.out.println("demo: " + demo);

			
			
			String result1 = test1("aba");
			System.out.println("salida1: " + result1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int solution(int[] A) {
		Arrays.sort(A); // Ordena el arreglo A en orden ascendente

		int smallestPositive = 1;
		for (int num : A) {
			// Ignora los números negativos y cero
			if (num <= 0)
				continue;

			// Si encontramos el siguiente número positivo en la secuencia
			// actual, actualizamos smallestPositive
			if (num == smallestPositive)
				smallestPositive++;
			// Si encontramos un número mayor que smallestPositive,
			// significa que hemos encontrado el número más pequeño que falta
			else if (num > smallestPositive)
				break;
		}

		return smallestPositive;
	}

	public static String test1(String S) {
//		 HashMap<String, Integer> name = new HashMap();
//		 for(var i=0; i< S.length(); i++) {
//			 if (name.get(S[i])) {
//				
//			}
//		 }
//		return 0;
		
	        // Creamos un arreglo para contar la frecuencia de cada caracter
	        int[] freq = new int[26]; // Suponiendo que solo estamos considerando letras del alfabeto inglés
	        
	        // Convertimos la cadena a minúsculas para hacer el conteo de manera insensible a mayúsculas y minúsculas
	        //String lowerCaseS = S.toLowerCase();
	        
	        // Contamos la frecuencia de cada caracter en la cadena
	        for (char c : S.toCharArray()) {
	            if (Character.isLetter(c)) { // Ignoramos los caracteres que no sean letras
	                freq[c - 'a']++; // Incrementamos la frecuencia del caracter
	            }
	        }
	        
	        // Buscamos el primer caracter que ocurre dos veces
	        for (char c : S.toCharArray()) {
	            if (Character.isLetter(c) && freq[c - 'a'] == 2) { // Si encontramos un caracter que ocurre dos veces, lo devolvemos
	                return String.valueOf(c);
	            }
	        }
	        
	        // Si no se encontró ningún caracter que ocurra dos veces, devolvemos una cadena vacía
	        return "";
	    }
	
	
}
