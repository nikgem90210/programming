package faltu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteStreamTest {

	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the stream");
//		char[] charArray = br.readLine().toCharArray();
//		for(char c:charArray){
//			bOut.write(c);
//		}
		bOut.write(br.readLine().getBytes());
		byte[] b = bOut.toByteArray();
		System.out.println("Print the Content");
		for(int i=0 ; i<b.length ; i++)
		{
			System.out.println((char)b[i] + "  ");
		}
		int x;
		ByteArrayInputStream bInput = new ByteArrayInputStream(b);
		System.out.println("Character to UPPERCASE");
		while((x=bInput.read())!=-1){
			System.out.print(Character.toUpperCase((char)x));
		}
		bInput.close();
		
	}

}
	