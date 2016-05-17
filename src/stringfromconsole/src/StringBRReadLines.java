package stringfromconsole.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
public class StringBRReadLines {
	public static void main(String args[]) throws IOException
	{
		URL url = new URL("http://www.imdb.com/title/tt0411477");
		InputStream in = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		/*String[] temp = str.split("-");
		for(int i = 0 ; i < temp.length ; i++)
			System.out.println(temp[i]);*/
		String line = null;
		while((line=br.readLine())!=null){
			if(line.indexOf("<div class=\"titlePageSprite star-box-giga-star\">")!=-1){
				String rating = line.substring(line.indexOf('>')+1,line.lastIndexOf('<'));
				System.out.println("This movie has" +rating+ "rating");
				break;
			}
		}
		
	}
}			