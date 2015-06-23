package faltu;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class alphaOrder {

	public static void main(String[] args) throws IOException
    {
		int count = 0;
		String line = null;
		File file = new File("C:/Users/Nishant/Desktop/test1.txt");
		Scanner scanner = new Scanner(file);
		Set<String> set = new TreeSet<>();
		while(scanner.hasNextLine())
		{
			line = scanner.nextLine();
			set.add(line);
		}
		for(String s:set){
			System.out.print("\n"+s);
		}
		scanner.close();
//		System.out.println("\n" + count + "contacts in records");
    }
}