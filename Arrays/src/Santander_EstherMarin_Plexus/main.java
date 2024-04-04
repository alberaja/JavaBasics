package Santander_EstherMarin_Plexus;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {

//		Ensayo de AJA
		
		int[] A = { 1, 2, 5, 9, 9 };
		int X = 5;

//		System.out.println("PosibleEnunciado: " + PosibleEnunciado.solution(A, X)); // Example 1
		System.out.println("solutionCorrejidoCgpt: " + PosibleEnunciado.solutionCorrejidoCgpt2cambios(A, X)); // Example 2
			System.out.println("si no existe X en A debe dar -1");
		System.out.println("solutionCorrejidoCgpt para X=6: " + PosibleEnunciado.solutionCorrejidoCgpt2cambios(A, 6)); // Example 2
		
		
		//pruebas extra aja	
		int[] Aja = { 1, 2, 5, 9, 9 };
				System.out.println("pruebas extra aja: solutionCorrejidoCgpt3cambios()" + PosibleEnunciado.solutionCorrejidoCgpt3cambios(Aja, 9));
		
		
//		----> Enunciado codility 04/04/2024
		int[] ACod = { 1, 2, 5, 9, 9 };
		int Xcod = 5;
		System.out.println("-------Enunciado codility-------");
		System.out.println("Enunciado codility: " + PosibleEnunciado.enunciadoCodility(ACod, Xcod));
		
		System.out.println("solutionEnviada 04/04/2024: " + PosibleEnunciado.solutionEnviada(ACod, Xcod));
		
//		----> Enunciado codility para Tests 04/04/2024
		System.out.println("Enunciado codility para Tests 04/04/2024");
		List<Integer> list= new ArrayList<>();
		int i=0;
		while(i<5) {
			i++;
			list.add(i);
		}
		System.out.println("list="+ list);
		
		System.out.println("valor de Func recursiva:  testMath()="+ testMath(4));
	}
	
	public static long testMath(Integer in) {
		if (in == 0) {
			return 1L;
		}
		return in * testMath(in-1);
	}

}
