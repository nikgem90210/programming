package faltu;

import java.util.Scanner;

public class Compare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first number");
		int n1 = scan.nextInt();
		System.out.println("Enter second number");
		int n2 = scan.nextInt();
		scan.close();
		if(n1 > n2){
			System.out.println("1 is greater");
		}
		else if (n1 < n2) {
			System.out.println("2 is greater");
		}
		else {
			System.out.println("equal");
		}
	}

}
