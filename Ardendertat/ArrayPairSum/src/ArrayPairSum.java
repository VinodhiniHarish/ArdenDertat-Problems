import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayPairSum {
	
	public void arrayPairSum(int[] a, int k) {
		Arrays.sort(a);
		int left=0, right = a.length-1;
		int sum = 0;
		while(left<right) {
			sum = a[left] + a[right];
			if(sum == k) {
				System.out.println(a[left] + " " + a[right]);
				left++;
			}else if(sum < k) {
				left++;
			}else {
				right--;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayPairSum a = new ArrayPairSum();
		int[] arr = {1, 1, 2, 3, 4};
		a.arrayPairSum(arr, 4);
	}

}
