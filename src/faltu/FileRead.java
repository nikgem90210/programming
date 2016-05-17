package faltu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) throws IOException {
		//File file = new File("C:/Users/Nishant/Desktop/Test.txt");
		//file.createNewFile();
//		FileWriter fw = new FileWriter("C:/Users/Nishant/Desktop/Test.txt");
//		fw.write("This\n is\n an\n example\n");
//		fw.flush();
//		fw.close();
//		FileReader fr = new FileReader("C:/Users/Nishant/Desktop/Test.txt");
//		char[] a = new char[50];
//		fr.read(a);
//		System.out.println(a);
//		fr.close();
		
		String filePath = "/tmp/offers_log";
		 
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
			br.close();
		}
		
	}

}
