
public class MatrixRegionSum {
	
	public void findMartrixRegSum(int[][] a, int[] top, int[] bottom) {
		int sum = 0;
		for(int i=top[0];i<=bottom[1];i++) {
			for(int j=top[1]; j<=bottom[0];j++) {
				System.out.print(a[i][j] + " ");
				sum += a[i][j];
			}
			System.out.println("\n");
		}
		System.out.println("Sum of all the above sub matrix is : " + sum);
	}
	
	//Method 2: Precomuting Sum
	public void precomuteMatrixSum(int[][] a) {
		int[] top= { 0,0 };
		int[] bottom = {a.length-1,a.length-1};
		int[] leftCol = {0, 0};
		int[] rightCol = {0, a[0].length};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixRegionSum m = new MatrixRegionSum();
		int[][] a = {
				{12,15,17,18,19,20},
				{31,32,33,34,35,36},
				{41,42,43,44,45,46},
				{52,53,54,55,56,57},
				{61,62,63,64,65,66},
				{71,72,73,74,75,76},
				{1,2,3,4,5,6}
		};
		int[] top= {1,1};
		int[] bottom = {3,3};
		m.findMartrixRegSum(a, top, bottom);
	}

}
