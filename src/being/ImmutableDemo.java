package being;

import java.util.Date;

public class ImmutableDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		IAmImmutable iAmImmutable = IAmImmutable.getInstance(1, "Nishant", new Date());
		System.out.println("ID :- " + iAmImmutable.getId() +"\n"+ "Name :- " +iAmImmutable.getName() +"\n"+"Date :- "+iAmImmutable.getCurrentDate());
		
		iAmImmutable.getCurrentDate().setDate(23);
		System.out.println("ID :- " + iAmImmutable.getId() +"\n"+ "Name :- " +iAmImmutable.getName() +"\n"+"Date :- "+iAmImmutable.getCurrentDate());
		
	}

}
