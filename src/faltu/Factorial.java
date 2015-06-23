package faltu;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Number For Factorial");
		n = scan.nextInt();
		int result = factorial(n);
		System.out.println(result);
		scan.close();
	}

	public static int factorial(int n) {
		int result = 1;
		for (int i = 1 ; i <= n ; i++){
			result = result * i;
		}
		return result;
	}

}
