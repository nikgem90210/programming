package faltu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test {
	public static void main(String[] args) throws Exception{
		try
		{
			String inputLine ;
			BufferedReader tbr = new BufferedReader(new FileReader("C:/Users/Nishant/Desktop/url.txt"));
			String tLine = tbr.readLine();
			String[] TLINE = tLine.split(",");
//			while(TLINE!=null){
			for(String urlString : TLINE){
				URL url = new URL(urlString);
				URLConnection conn = url.openConnection();
				boolean isException = false;
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while((inputLine = br.readLine())!=null){
					if(inputLine.contains("execption")){
						System.out.println("Exception" + inputLine);
						isException = true;
						break;
					}
				}
				System.out.println(urlString + " " + isException);
			}
			tbr.close();
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
