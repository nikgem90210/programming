package faltu;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieReviewFetcher {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.imdb.com/title/tt0338526/");
		InputStream in = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String movieDetail = "";
		String line = null;
		while((line=br.readLine())!=null){
			movieDetail += line;
		}
		Pattern pattern = Pattern.compile("<p itemprop=\"description\">(.*?)</p>");
		Matcher matcher = pattern.matcher(movieDetail);
		if(matcher.find()){
			String detail = matcher.group(1);
			System.out.println(detail);
			FileWriter fw = new FileWriter("c:/Users/Nishant/Desktop/bb.txt");
			fw.write("http://www.imdb.com/title/tt0338526/");
			fw.write('\n');
			fw.write(detail);
			fw.flush();
			fw.close();
		}
	}

}
