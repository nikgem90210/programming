package Methodcalling.src;

public class TestMax {
	
	public static int max(int num1,int num2)
	{
		int result;
		if (num1 > num2)
		{
			result = num1;
		}
		else
		result = num2;
		return result;
	}
	public static void main(String args[])
	{
		int x =5;
		int y =10;
		int z = max(x,y);
		System.out.println("The maximum number between " + x + " and " + y + " is " +z);
	}
}
