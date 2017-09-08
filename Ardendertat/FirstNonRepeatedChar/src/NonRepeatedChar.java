import java.util.*;
public class NonRepeatedChar {
	HashMap<Character, Integer> map = new HashMap<Character,Integer>();

	public void firstNonRepeatedChar(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		printLn();
		System.out.println("First Non Repeated Character");
		for(Map.Entry<Character, Integer> m: map.entrySet()) {
			if(m.getValue() == 1) {
				System.out.println(m.getKey());
				break;
			}
			
		}
	}
	
	public void printLn() {
		for(Map.Entry<Character, Integer> m: map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonRepeatedChar n = new NonRepeatedChar();
		n.firstNonRepeatedChar("acsffsfsfsdfdsfaazaaaaaaaaaaaa");
	}

}
