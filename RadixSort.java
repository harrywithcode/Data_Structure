public class RadixSort{
	public static void sort(int[] A, int digit){
		int n = 1;
		int[][] temp = new int[10][A.length];
		int[] same = new int[10];
		
		for(int b = 0; b < digit; b++){
			for(int i = 0;i < A.length;i++){
				int x = (A[i]/n)%10;
				temp[x][same[x]] = A[i];
				same[x]++;
			}
	      
			int k = 0;
			for(int i = 0;i < 10;i++){
				if(same[i] != 0){
					for(int j = 0;j < same[i];j++){
						A[k] = temp[i][j];
						k++;
					}				    
				}
				same[i] = 0;
			}
			n=n*10;
		}
	}
	public static void main(String[] args){
		int[] data = {1934,1834,1000,8422,5043,4930,3745,2940,3634,2849,3440,9999,9998,1000,2353};
		sort(data,4);
		for(int i = 0;i < data.length;i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
