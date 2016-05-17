package entPra;

import java.util.TreeSet;

public class Recurssion {

	public static void main(String[] args) {
		System.out.println(permutation("ABC"));
	}

	private static TreeSet<String> permutation(String str) {

		TreeSet<String> perm = new TreeSet<String>();
		
		if(str == null){
			return null;
		}
		else if(str.length() == 0){
			return perm;
		}
		
		char initial = str.charAt(0);
		String remains = str.substring(0);
		TreeSet<String> permutation = permutation(remains);
		
		
		
		return perm;
	}

}
