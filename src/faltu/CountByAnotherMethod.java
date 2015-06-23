package faltu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountByAnotherMethod {
	public static void main(String args[]) throws IOException
	{
		System.out.println ("Counting Words");  
	       FileReader fr = new FileReader ("C:/Users/Nishant/Desktop/count.txt");        
	       BufferedReader br = new BufferedReader(fr);     
	       String line = br.readLine();
	       int count = 0;
	       while (line != null) {
//	          String []parts = line.split(" ");
//	          for( String w : parts)
	          {
	            count++;        
	          }
	          line = br.readLine();
	          br.close();
	       }         
	       System.out.println(count);
	}
}
//int count = 0;
//File file = new File("C:/Users/Nishant/Desktop/count.txt");
//Scanner scan = new Scanner(new FileReader(file));
//while (scan.hasNext())
//{
//	System.out.println(scan.next());			
//	count++;
//}
//scan.close();
//System.out.println("Number of Words " + count);