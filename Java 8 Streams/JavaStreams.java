import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class JavaStreams {
	public static void main(String[] args) throws IOException {
//		salida:
//			123456789
//			2: 6
//			2: 7
//			2: 8
//			2: 9
//
//			3: 10
//
//			4:Alberto
//			5:Sarah
//			5:Sarika
//			5:Shivika
//			6:44.0
//			7:al
//			7:ankit
//			7:amanda
//			8:Jackson Browne
//			8:Mumford and Sons
//			8:Rolling Stones
//			9:Arijit Singh
//			10:5 rows.
//			11:B  17  2.8
//			11:D  23  2.7
//			11:F  18  3.4
//			12:B  17
//			12:D  23
//			12:F  18
//			13:Total = 13.600000000000001
//			14:IntSummaryStatistics{count=7, sum=203, min=2, average=29,000000, max=88}
		
		
		// 1. Integer Stream
		IntStream
			.range(1, 10)
			.forEach(System.out::print);
		// 123456789
		// salto de linea
		System.out.println(); 
		
		// 2. Integer Stream with skip
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x -> System.out.println("2: "+ x));
//		mostrar del 5 en adelante
//		6
//		7
//		8
//		9
		System.out.println();
		
		// 3. Integer Stream with sum
		// secuencia de números enteros en el rango [1, 5)  = La secuencia generada será {1, 2, 3, 4}.
		// calcula la suma de los elementos en el stream.
		System.out.println( "3: "+
		IntStream
			.range(1, 5)
			.sum());
		System.out.println();
			
		// 4. Stream.of, sorted and findFirst
		// .sorted():   Ordena los elementos del stream en orden natural. En este caso, se ordenarán alfabéticamente.
//		.findFirst(): Devuelve el primer elemento del stream después de aplicar cualquier operación de ordenamiento o filtrado. En este caso, después de ordenar alfabéticamente, devuelve el primer nombre en orden alfabético.
//		.ifPresent(element -> System.out.println("4:" + element)): Verifica si hay algún elemento presente y, si es así, ejecuta el bloque de código proporcionado. En este caso, imprime el primer nombre (el menor en orden alfabético) precedido por "4:".
		Stream.of("Ava", "Aneri", "Alberto")
			.sorted()
			.findFirst()
//			.ifPresent(System.out::println);
			.ifPresent(element -> System.out.println("4:" + element));
			
		// 5. Stream from Array, sort, filter and print
		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
		Arrays.stream(names)	// same as Stream.of(names)
			.filter(x -> x.startsWith("S"))
			.sorted()
			//.forEach(System.out::println);
			.forEach(element -> System.out.println("5:" + element));
					
		// 6. average of squares of an int array
		Arrays.stream(new int[] {2, 4, 6, 8, 10})
			.map(x -> x * x)
			.average()
			//.ifPresent(System.out::println);
			.ifPresent(element -> System.out.println("6:" + element));
		
		// 7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people
			.stream()
			.map(String::toLowerCase)
			.filter(x -> x.startsWith("a"))
			//.forEach(System.out::println);
			.forEach(element -> System.out.println("7:" + element));
			
		// 8. Stream rows from text file, sort, filter, and print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands
			.sorted()
			.filter(x -> x.length() > 13)
			//.forEach(System.out::println);
			.forEach(element -> System.out.println("8:" + element));
		bands.close();
		
		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
			.filter(x -> x.contains("jit"))
			.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println("9:"+ x));
		
		// 10. Stream rows from CSV file and count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int)rows1
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.count();
		System.out.println("10:"+ rowCount + " rows.");
		rows1.close();
		
		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.forEach(x -> System.out.println("11:"+ x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();
		
		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
			.map(x -> x.split(","))
            .filter(x -> x.length == 3)
			.filter(x -> Integer.parseInt(x[1]) > 15)
			.collect(Collectors.toMap(
                x -> x[0],
                x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println("12:"+ key + "  " + map.get(key));
		}
			
		// 13. Reduction - sum
			// La operación de reducción consiste en sumar todos los elementos del stream y, en este caso, se inicia con un valor inicial de 0.0.
		double total = Stream.of(7.3, 1.5, 4.8)
				// El primer argumento (0.0) es el valor inicial, y la lambda (Double a, Double b) -> a + b especifica cómo combinar dos elementos del stream. En este caso, se están sumando los elementos.
			.reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("13:"+ "Total = " + total);
		
		// 14. Reduction - summary statistics
			// método summaryStatistics() para obtener un resumen estadístico sobre esos números.
			// El resultado es almacenado en una instancia de IntSummaryStatistics. Esta instancia contiene información estadística como el mínimo, máximo, suma, promedio y cantidad de elementos en el stream.
			// salida: 14:IntSummaryStatistics{count=7, sum=203, min=2, average=29,000000, max=88}
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
			.summaryStatistics();
		System.out.println("14:"+summary);
	}
}