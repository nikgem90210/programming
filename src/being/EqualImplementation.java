package being;

//public class EqualImplementation {
//
//	public static void main(String[] args) {
//
//		Student firstStudent = new Student(1, "Nik");
//		Student secondStudent = new Student(1, "Nik");
//		Student thirdStudent = new Student(1, "Nik");
//
//		System.out.println("Reflexive Test :- " + firstStudent.equal(firstStudent));
//
//		if(firstStudent.equal(secondStudent)){
//			System.out.println("Symmetric Test :- " + secondStudent.equal(firstStudent));
//		}
//
//		if(firstStudent.equal(secondStudent) && secondStudent.equal(thirdStudent)){
//			System.out.println("Transitive Test :- " + thirdStudent.equal(firstStudent));
//		}
//
//		if (firstStudent != null) {  
//			System.out.println("Null Test : " + firstStudent.equals(null));  
//
//		}  
//	}
//
//}


abstract class EqualImplementation{
	
	abstract void callme();
	
}
class B extends EqualImplementation{

	@Override
	void callme() {
		System.out.println("Priont");
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		b.callme();
	}
}
