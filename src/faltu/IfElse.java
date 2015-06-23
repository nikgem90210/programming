package faltu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfElse {

	public static void main(String[] args) throws IOException {
		char grade;
		int c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The number");
		c = Integer.parseInt(br.readLine());
		if (c >= 90) {
            grade = 'A';
        } else if (c >= 80) {
            grade = 'B';
        } else if (c >= 70) {
            grade = 'C';
        } else if (c >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
	
	}

}
