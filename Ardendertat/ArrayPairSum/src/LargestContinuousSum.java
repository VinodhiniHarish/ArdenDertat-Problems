
public class LargestContinuousSum {

	public void largestContinuousSum(int[] a) {
		int max = -999999999;int sum =0,prevSum=0;
		for(int i=0;i<a.length-1;i++) {
			sum  = a[i];
			for(int j=i+1;j<a.length;j++) {
				sum = sum + a[j];
				if(max < sum) {
					max = sum;
				}
			}
			sum = 0;
		}
		System.out.println("Largest Continous Sum is "+ max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-40,1,40,-50,1,50,-20,1,20,0,0 };
		LargestContinuousSum l = new LargestContinuousSum();
		l.largestContinuousSum(a);
	}

}
