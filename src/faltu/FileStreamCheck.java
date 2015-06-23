package faltu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class FileStreamCheck {

	public static void main(String[] args) throws IOException{
		try{
			byte bWrite [] = {'1','2','3','4','5'};
			OutputStream os = new FileOutputStream("C:/Users/Nishant/Desktop/test.txt");
			for(int i=0 ; i < bWrite.length; i++)
			{
				os.write(bWrite[i] +10);	
				os.write('\n');
			}
			os.close();
			InputStream is = new FileInputStream("C:/Users/Nishant/Desktop/test.txt");
			int size = is.available();
			for(int i = 0 ; i<size ; i++)
			{
				System.out.print((char)is.read());
			}
			is.close();}
			catch(IOException e){
				System.out.println("Exception Occured");
			}
	}		
}