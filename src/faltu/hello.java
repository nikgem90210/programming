package faltu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hello {
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();

		list.add("ravi");

		list.add("kant");

		list.add("soni");

		// Iterate to disply : result will be as ---     ravi kant soni

		for (String name : list) {
			System.out.println(name);
		}

		//Now call this method

		Collections.reverse(list);

		// iterate and print index wise : result will be as ---     soni kant ravi

		for (String name : list) {
			System.out.println(name);
		}
	}
}
