import java.util.*;
public class Anagrams {

	public void findAnagrams(String str1, String str2) {
		str1 = str1.replaceAll("[^a-zA-Z]+", "");
		str2 = str2.replaceAll("[^a-zA-Z]+", "");
		System.out.println("String after removind special char " + str1 +" "+ str2);
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if(str1.length() != str2.length()) {
			System.out.println("Strings are not anagrams");
		}else {
			StringBuffer buff = new StringBuffer(str2);
			for(int i=0;i<str1.length();i++) {
				char ch = str1.charAt(i);
				if(str2.indexOf(ch)!=-1) {
					str2 = str2.substring(0, str2.indexOf(ch)) + str2.substring(str2.indexOf(ch)+1, str2.length());
				}else {
					System.out.println("Strings are not anagrams");
					return;
				}
			}
		}
		if(str2.length() == 0) {
			System.out.println("Strings are anagrams");
		}
	} 
	
	
	//Method2: with Hash Tables
	public void findAnagrams2(String str1, String str2) {
		str1 = str1.replaceAll("[^a-zA-Z]+", "");
		str2 = str2.replaceAll("[^a-zA-Z]+", "");
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		boolean isAnagram = true;
		for(int i=0;i<str1.length();i++) {
			if(map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
			}else {
				map.put(str1.charAt(i), 1);
			}
		}
		
		for(int i=0;i<str2.length();i++) {
			if(map.containsKey(str2.charAt(i))) {
				int n = map.get(str2.charAt(i));
				if(n >0)
					map.put(str2.charAt(i),n-1);
				else {
					System.out.println("Strings are not anagrams");
					isAnagram = false;
					return;
				}
					
			}else {
				System.out.println("Strings are not anagrams");
				isAnagram = false;
				return;
			}
		}
		
		for(Map.Entry<Character,Integer> m : map.entrySet()) {
			if(m.getValue()!=0) {
				System.out.println("Strings are not anagrams");
				isAnagram = false;
				return;
			}
		}
		if(isAnagram) {
			System.out.println("The given Strings are anagrams");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a = new Anagrams();
		String str1 = "Eleven :plus, two";
		String str2 = "Tw,e,l.ve; plus one";
//		a.findAnagrams(str1, str2);
		a.findAnagrams2(str1, str2);
	}

}
