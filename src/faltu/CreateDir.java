package faltu;

import java.io.File;
import java.io.FileWriter;

public class CreateDir
{

	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter("C:/Users/Nishant/Desktop/test1.txt");
		String dirname = "C:/Program Files/Java/jdk1.7.0_45";
		File f = new File(dirname);
		if(f.isDirectory())
		{
			System.out.println("Directory of " + dirname);
	//		File s[] = f.listFiles();
			String s[] = f.list();
			for(int i=0 ; i<s.length; i++)
				{
				//File ff = s[i];
				//if(s[i].isDirectory()){
				File f1 = new File(dirname + "/" + s[i]);	
				if(f1.isDirectory())
				{
					System.out.println(s[i] + " is a Directory");
					fw.write(s[i] + " is a Directory");
					fw.write('\n');
				}
				else{
					System.out.println(s[i] + " is a File");
					fw.write(s[i] + " is a File");
					fw.write('\n');
				}
			}
		}
		else{
			System.out.println(f + " is not a Directory");
		}
		fw.flush();
		fw.close();
	}	
}