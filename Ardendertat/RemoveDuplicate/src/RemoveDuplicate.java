import java.util.*;
public class RemoveDuplicate {
	
	public void removeDuplicate(String str) {
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		ArrayList<Character> arrList = new ArrayList<Character>();
		
		for(int i=0;i<str.length();i++) {
			if(!set.contains(str.charAt(i))) {
				set.add(str.charAt(i));
				arrList.add(str.charAt(i));
			}
		}
		Iterator<Character> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicate r = new RemoveDuplicate();
		r.removeDuplicate("tree traversal");
	}

}
