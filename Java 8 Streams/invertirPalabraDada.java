
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class invertirPalabraDada {
    public static void main(String[] args) {
        String palabraOriginal = "Hola";

        // Girar la palabra
        String palabraInvertida = invertirPalabra(palabraOriginal);

        // Imprimir la palabra invertida
        // salida: aloH
        System.out.println(palabraInvertida);
    }

    private static String invertirPalabra(String palabra) {
        // Usa IntStream para generar los índices en orden inverso
    		// Genera un stream de enteros en el rango [0, longitud de la palabra).
        return IntStream.range(0, palabra.length())
        		// Mapea cada índice i al carácter correspondiente en la palabra original en orden inverso
        				// obtiene el carácter desde el final de la palabra hacia el principio.
                .mapToObj(i -> palabra.charAt(palabra.length() - 1 - i))
                // Convierte cada carácter en una cadena utilizando el método estático valueOf de la clase String.
                .map(String::valueOf)
                //  Combina todas las cadenas resultantes en una sola cadena utilizando Collectors.joining()
                .collect(Collectors.joining());
    }
}

