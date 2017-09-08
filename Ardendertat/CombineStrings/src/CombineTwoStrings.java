import java.util.*;
public class CombineTwoStrings {

	public void combineStrings(String str1, String str2,String str3) {
		boolean isCombination = true;
		if((str1.length()+ str2.length()) != str3.length()){
			System.out.println("String3 is NOT a combination of String 1 and String2");
			isCombination = false;
		}else {
			int i=0,j=0,k=0;
			while(i<str1.length() && j<str2.length()) {
				if(str3.charAt(k)==str1.charAt(i)) {
					i++;
					k++;
				}else if(str3.charAt(k) == str2.charAt(j)) {
					j++;
					k++;
				}else {
					System.out.println("String3 is NOT a combination of String 1 and String2");
					isCombination = false;
				}
			}
			while(i<str1.length()) {
				if(str3.charAt(k) == str1.charAt(i)) {
					i++;
					k++;
				}
			}
			while(j<str2.length()) {
				if(str3.charAt(k) == str2.charAt(j)) {
					j++;
					k++;
				}
			}
		}
		
		if(isCombination) {
			System.out.println("String3 is a valid combination of String 1 and String 2");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombineTwoStrings c = new CombineTwoStrings();
		String str1 = "abc",str2 = "def", str3 = "dabecf";
		c.combineStrings(str1, str2, str3);
	}

}
