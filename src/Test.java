
public class Test {


	public static void main(String[] args) {
		
		Screen.print();
		
	}
	
	
}


class Screen {
	
	public static void print() {
		System.out.println("Static method from Parent class");
	}
	
}

class ColorScreen extends Screen{
	
	public static void print(){
		System.out.println("Overridden static method in Child Class in Java");
    }
	
}
	

