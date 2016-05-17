package passbyvalue.src.passbyvalue;

public class TestPassByValue {
	public static void main(String args[])
	{
		int num1 = 3;
		int num2 = 7;
		System.out.println("Before swap method, num1 is "+ num1 +" num2 is " + num2);
		swap(num1, num2);
		System.out.println("After swap method, num1 is "+ num2 +" num2 is " + num1);
	}
	public static void swap(int x, int y)
	{
		System.out.println("\tInside the swap method");
	      System.out.println("\t\tBefore swapping x is " + x
	                           + " y is " + y);
		int temp = x;
		x = y; 
		y = temp;
		System.out.println("\t\tAfter swapping x is " + x + " y is " + y);
	}

}
