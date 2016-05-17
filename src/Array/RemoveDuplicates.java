package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class RemoveDuplicates {

	public static void main(String[] args) {
	
//		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
//
//		ArrayList<Integer> primes = new ArrayList<Integer>();
//		
//		primes.add(2); 
//		primes.add(3); 
//		primes.add(5); 
//		primes.add(7); //duplicate 
//		primes.add(7); 
//		primes.add(11);
//		System.out.println("fresh arraylist element "+primes);
//		
//		linkedHashSet.addAll(primes);
//		System.out.println("fresh linkedhashset element without duplicates"+linkedHashSet);
//		
//		primes.clear();
//		System.out.println("cleared array list "+primes);
//		primes.addAll(linkedHashSet);
//		System.out.println("new array list without duplicates"+primes);
		
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		primes.add(2);
		primes.add(5);
		primes.add(3);
		primes.add(7);
		primes.add(5); 
		primes.add(7); //duplicate 
		primes.add(7);
		primes.add(7);
		primes.add(11);
		primes.add(11);
		System.out.println("fresh arraylist element "+primes);
		int len = primes.size();
		for (int i = 0; i < len; i++) {
			Integer x = primes.get(i);
			for(int j=i+1;j<len;j++){
				if(x.equals(primes.get(j))){
					System.out.println(x + "removed");
					primes.remove(j);
					i--;
					len--;
				}
			}
			
		}
		
		System.out.println("new array list "+ primes);
		
//		for (Integer integer : primes) {
//			if(primes.contains(integer)){
//				primes.remove(integer);						//Concurrent Modification Exception
//			}
//			else{
//				continue;
//			}
//		}
	}
}