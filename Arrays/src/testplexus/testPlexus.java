package testplexus;

class testPlexus {
	
	 public static void main(String[] args) {
	        

	        // Ejemplo de uso
//	        int[] A = {1, 2, 3, 4, 4, 4, 5, 6};
//	        int X = 4;	       
	        
	        int[] A = {1, 2, 5, 9, 9};
	        int X = 5;
	        
	        StatementPlexusCodility statement = new StatementPlexusCodility();
	        int resultCodility = statement.solution(A, X);
	        System.out.println("resultCodility: " +resultCodility);
	        
	        
	        Solution solution = new Solution();
	        int result = solution.solution(A, X);

	        System.out.println("result: " +result);
//	        if (result[0] == -1) {
//	            System.out.println("No se encontró ninguna ocurrencia de " + X);
//	        } else {
//	            System.out.print("Ocurrencias de " + X + " en las posiciones: ");
//	            for (int position : result) {
//	                System.out.print(position + " ");
//	            }
//	            System.out.println();
//	        }
	    }
	
    
}
