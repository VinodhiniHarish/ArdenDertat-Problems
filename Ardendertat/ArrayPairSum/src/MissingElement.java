import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingElement {

	HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
	HashMap<Integer, Integer> map2 = new HashMap<Integer,Integer>();
	public void findMissingElement(int[] first,int[] second) {
		Arrays.sort(first);
		Arrays.sort(second);
		int i=0,j=0;
		while(i<first.length && j<second.length) {
			if(first[i] == second[j]) {
				i++;
				j++;
			}else {
				System.out.println("Missing element is "+ first[i]);
				i++;
				return;
			}
		}
	}
	
	
//Method 2: with Hash Tables
	public void findMissingElement2(int[] first,int[] second) {
		map1 = constructMap(first, map1);
		map2 = constructMap(second,map2);
		
		for(Map.Entry<Integer,Integer> m : map1.entrySet()) {
			if(map2.containsKey(m.getKey())) {
				if(map2.get(m.getKey()) != m.getValue()) {
					System.out.println("Missing Element is " + m.getKey());
					return;
				}
			}else {
				System.out.println("Missing Element is "+m.getKey());
				return;
			}
		}
	}
	
	public HashMap<Integer, Integer> constructMap(int[] a,HashMap<Integer,Integer> map) {
		for(int i=0;i<a.length;i++) {
			if(map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			}else {
				map.put(a[i], 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingElement m = new MissingElement();
		int[] first = {9,4,8,5,6,2,1,3,0,7};
		int[] second = {6,2,1,3,0,7,9,4,8};
		m.findMissingElement(first, second);
		m.findMissingElement2(first, second);
	}

}
