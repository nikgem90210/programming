import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {

	public static void main(String[] args) {
		String regex = "Rs\\s*\\d*\\s*";
		String title = "Attractive Models @ Rs 50 /wk";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(title);
		while(matcher.find()) {
            System.out.println(matcher.group());
        }
	}
	
}
