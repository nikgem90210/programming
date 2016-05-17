package XMLParsing.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CSVReader {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Nishant/Desktop/1.csv"));
		String line = null;
		while((line=br.readLine())!=null){
			processLine(line);
			extractModel(line);
		}
		br.close();
		
	}
	private static void processLine(String line) {
		String word = "";
		boolean quoteOpen = false;
		for(char c: line.toCharArray()){
			switch(c){
			case ',':
				if(!quoteOpen){
//					System.out.println(word);
					word = "";
				}else{
					word += c;
				}
				break;
			case '"' :
				word += c;
				quoteOpen = !quoteOpen;   // to distinguish between starting comma and ending comma
				break;
				default:
					word += c;
			}
		}
//		System.out.println(word);
	}
	public static void extractModel(String line)
	{
//		Pattern pattern = Pattern.compile("; ([a-zA-Z0-9_\\-]+( [a-zA-Z0-9_\\-]+)?) Build", Pattern.CASE_INSENSITIVE);
		Pattern pattern = Pattern.compile("; ([^;]+?) Build", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(line);
		if(matcher.find())
		{
			String match = matcher.group(1);
			System.out.println("match = "+match);
		}
	}

}
