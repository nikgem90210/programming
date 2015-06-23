package faltu;
//
//public class print {
//
//	public static void main(String[] args) 
//	{
//		int i;
//		for (i = 2013 ; i>=1900 ; i--)
//		{
//			System.out.println("askdhkas");
//		}
//	}
//}

import java.util.*;

public class print {

   @SuppressWarnings("unchecked")
public static void main(String args[]) {
      // create a hash set
      LinkedHashSet hs = new LinkedHashSet();
      // add elements to the hash set
      hs.add("B");
      hs.add("A");
      hs.add("D");
      hs.add("B");
      hs.add("A");
      hs.add("A");
      hs.add("A");
      hs.add("A");
      hs.add("E");
      hs.add("C");
      hs.add("F");
      System.out.println(hs);
   }
}