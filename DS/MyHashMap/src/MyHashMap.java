import java.util.*;
public class MyHashMap extends HashMap{
	
	HashMap<String, String> map = new HashMap<String,String>();
	//MyHashMap<String, String> map1 = new MyHashMap<String,String>();
	
	public void put(String key, String value) {
		key = preProcessKey(key);
		map.put(key, value);
	}
	
	public String get(String key) {
		key = preProcessKey(key);
		return map.get(key);
	}
	
	public String preProcessKey(String str) {
		str = str.toLowerCase();
		str = str.replace('e', 'a');
		str = str.replace('i', 'a');
		str = str.replace('o', 'a');
		str = str.replace('u', 'a');
		
		int[] ch = new int[256];
		String unique = "";
		
		int slow = 0, fast = slow+1;
		for(fast=slow+1;fast<str.length();fast++) {
			if(str.charAt(slow) != str.charAt(fast) && fast==str.length()-1) {
				unique += str.charAt(slow);
				
			}
		}
		return unique;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap m = new MyHashMap();
		m.put("akksa","Meow");
		m.put("aks","Whoof");
		System.out.println(m.get("akksa"));
		System.out.println(m.get("aks"));
		//m.get("aks","Knife");
		//m.
	//	System.out.println(m.get("Ceat"));
		
		
	}

}
