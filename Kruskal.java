public class Kruskal{
	private int total;
	private String[] vertices;
	private int[][] matrix;
	private int[][] result;
	int  n1 = 0, n2 = 0;

	public Kruskal(int total, String[] vertices){
		this.total = total;
		this.vertices = vertices;
		this.matrix = new int[total][total];
		this.result =  new int[total][total];
	}

	private void printMatrix(){
		System.out.println("----  0  -  1  -  2  -  3  -  4  -  5  -  6  -  7  -  8  -  9  --");
		System.out.println("----  A  -  B  -  C  -  D  -  E  -  F  -  G  -  H  -  I  -  J  --");
		System.out.println();
		for (int i = 0; i < this.total; i++) {
			System.out.print( i +" " + this.vertices[i] + "|");
			for (int j = 0; j < this.total; j++) {
				if(this.matrix[i][j] <10){
					System.out.print("  " + this.matrix[i][j] + "  " + "-");
				}
				else{
					System.out.print(" " + this.matrix[i][j] + "  " + "-");
				}
			}
			System.out.println("\n");
		}
	}
	 
	private void graph(){
		this.matrix[0][1] = 1;
		this.matrix[0][5] = 3;
		this.matrix[0][8] = 6;
		this.matrix[0][9] = 16;
				
		this.matrix[1][0] = 1;
		this.matrix[1][2] = 9;
		this.matrix[1][3] = 20;
		this.matrix[1][5] = 11;
		this.matrix[1][6] = 8;
		
		this.matrix[2][1] = 9;
		this.matrix[2][3] = 5;
		this.matrix[2][7] = 13;
		
		this.matrix[3][1] = 20;
		this.matrix[3][2] = 5;
		this.matrix[3][4] = 19;
		this.matrix[3][5] = 10;
		this.matrix[3][8] = 2;
		
		this.matrix[4][3] = 19;
		this.matrix[4][5] = 14;
		this.matrix[4][7] = 4;
		
		this.matrix[5][0] = 3;
		this.matrix[5][1] = 11;
		this.matrix[5][3] = 10;
		this.matrix[5][4] = 14;
		this.matrix[5][6] = 18;
		
		this.matrix[6][1] = 8;		
		this.matrix[6][5] = 18;
		this.matrix[6][7] = 12;
		this.matrix[6][9] = 7;
		
		this.matrix[7][2] = 13;
		this.matrix[7][4] = 4;
		this.matrix[7][6] = 12;
		this.matrix[7][8] = 17;
		
		this.matrix[8][0] = 6;
		this.matrix[8][3] = 2;
		this.matrix[8][7] = 17;
		this.matrix[8][9] = 15;
		
		this.matrix[9][0] = 16;
		this.matrix[9][6] = 7;
		this.matrix[9][8] = 15;
	}
	private void kruskal(){
        
       int[] A = new int[total];
       boolean traverse_all_nodes = false;
       int n = 1;
       
       while(traverse_all_nodes == false){
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < total; i++){
                for(int j = i+1; j < total; j++) {
                    if(matrix[i][j] > 0 && matrix[i][j] < min){
                        
                        if (A[i] != A[j] || (A[i] == 0 && A[j] == 0)){
                            min = matrix[i][j];
                            n1 = i;
                            n2 = j;    
                        }                                            
                    }
                }
            }
            
        System.out.println(n1 + " ---- " + n2 + "      " + (char)(n1+65) + " ---- " + (char)(n2+65));
            
            
        this.result[n1][n2] = this.matrix[n1][n2];
        this.result[n2][n1] = this.matrix[n2][n1];
            
        if(A[n1] == 0 && A[n2] == 0){
            A[n1] = n;
            A[n2] = n;
            n++;
        }
        
        
        else {
        	if(A[n1] > 0 && A[n2] > 0){
        		int p = A[n2];
        		for(int m = 0; m < total; m++){
        			if(A[m] == p){
        				A[m] = A[n1];
        			}
        		}
        	}
            else{ 
            	if(A[n1] == 0 && A[n2] >0){
                    A[n1] = A[n2];
                }
            	else {
                    A[n2] = A[n1];
                }
            }
        }
        
        for(int i = 0; i < total; i++){
            if(A[i] != A[0]){
            	traverse_all_nodes = false;
                break;
            }
            else{
            	traverse_all_nodes = true;
            }
        }             
    } 
       
}  
        
	private void printMST(){
		System.out.println("----  0  -  1  -  2  -  3  -  4  -  5  -  6  -  7  -  8  -  9  --");
		System.out.println("----  A  -  B  -  C  -  D  -  E  -  F  -  G  -  H  -  I  -  J  --");
		System.out.println();
		for (int i = 0; i < this.total; i++){
			System.out.print( i +" " + this.vertices[i] + "|");
			for (int j = 0; j < this.total; j++){
				if(this.result[i][j] < 10){
					System.out.print("  " + this.result[i][j] + "  " + "-");
				}
				else{
					System.out.print(" " + this.result[i][j] + "  " + "-");
				}
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args){
		String[] vertices = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		Kruskal grf = new Kruskal(10, vertices);
		grf.graph();
		System.out.println("---------- Original Graph -------------");
		grf.printMatrix();
		System.out.println("------ Kruskal Algorithm Begin ------");
		grf.kruskal();
		System.out.println("------ Kruskal Algorithm End ------");
		System.out.println();
		System.out.println("-------------- Result MST -------------");
		grf.printMST();		
	}
}