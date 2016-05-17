package XMLParsing.src;


import java.util.Arrays;

public class ArrayListIterator{
	public static void main(String[] args)
	{
		int[] num = {14,146,87,89,156};
		Arrays.sort(num);
		int i=0;
		for(Integer temp: num){
		System.out.println("fruits " + ++i + " : " + temp);
		}
	}
}