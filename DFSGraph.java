public class DFSGraph {
	private int total;
	private String[] vertices;
	private int[][] matrix;

	public DFSGraph(int total, String[] vertices) {
		this.total = total;
		this.vertices = vertices;
		this.matrix = new int[total][total];
	}

	private void printMatrix() {
		System.out.println("---- 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 --");
		System.out.println("---- A - B - C - D - E - F - G - H - I - J --");
		for (int i = 0; i < this.total; i++) {
			System.out.print( i +" " + this.vertices[i] + "|");
			for (int j = 0; j < this.total; j++) {
				System.out.print(" " + this.matrix[i][j] + " " + "-");
			}
			System.out.println("\n");
		}
	}

	private void dfsRecursive(int i) {
		if (this.matrix[i][i] == 1) {
			return;
		}
		this.matrix[i][i] = 1;
		//System.out.print(this.vertices[i] + " ");	//if program want to traverse in preorder way, than put "print" here.
		for (int j = 0; j < this.total; j++) {
			if (i == j) {
				continue;
			}
			if (this.matrix[i][j] == 1) {
				dfsRecursive(j);
			}
		}
		System.out.print(this.vertices[i] + " ");		//program traverses in postorder way.
	}
	
	private void check(){
		for(int i = 0; i < total; i++){
			if(this.matrix[i][i] == 0){
				dfsRecursive(i);
			}
		}
	}

	private void graph() {		//20 edges
		this.matrix[0][1] = 1;
		this.matrix[0][3] = 1;
		this.matrix[0][4] = 1;
		
		this.matrix[1][2] = 1;
		this.matrix[1][3] = 1;
		
		this.matrix[2][0] = 1;		
		
		this.matrix[3][2] = 1;		
		
		this.matrix[4][6] = 1;
		this.matrix[4][3] = 1;		
		
		this.matrix[5][4] = 1;
		this.matrix[5][6] = 1;
		this.matrix[5][7] = 1;

		this.matrix[6][1] = 1;
		this.matrix[6][3] = 1;		
		
		this.matrix[7][3] = 1;
		this.matrix[7][4] = 1;
		this.matrix[7][6] = 1;
		
		this.matrix[8][6] = 1;
		this.matrix[8][9] = 1;
		
		this.matrix[9][0] = 1;
	}

	public static void main(String[] args) {
		String[] vertices = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		DFSGraph grf = new DFSGraph(10, vertices);
		grf.graph();
		grf.printMatrix();

		System.out.println("------ DFS Begin ------");
		grf.dfsRecursive(0);	//entry
		grf.check();
		System.out.println();
		System.out.println("------ DFS End ------");
		
	}

}