import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.bytecode.opencsv.CSVReader;


public class Parse {

	private static final String RUPEECONSTANT = "(Rs) - ";
	
	public static void main(String[] args) throws IOException {
		
		String circleFromFileToBeChanged = null;
		String circleFromFile = null;
		Map<String, String> circleVsPrepositionMap = new HashMap<>();
		String preposition = null;
		String prepaidPP = null;
		String postPaidPP = null;
		Set<String> circleFromFileToBeChangedSet = new HashSet<>();
		
		HashMap<String, HashMap<String, String>> circleToPricePointMapping = new HashMap<>();
		
		FileReader fileReader1 = new FileReader("/Users/nishant/Downloads/Samsung A5.csv");
		@SuppressWarnings("resource")
		CSVReader pricePointToBeChangedFileReader = new CSVReader(fileReader1, ',', '"', 1);
		String[] nextLineOfTheFileToBeChanged = null;
		
		while ((nextLineOfTheFileToBeChanged = pricePointToBeChangedFileReader.readNext())!= null) {
			if (nextLineOfTheFileToBeChanged != null) {
				circleFromFileToBeChanged = nextLineOfTheFileToBeChanged[1];
				preposition = nextLineOfTheFileToBeChanged[7];
				circleVsPrepositionMap.put(circleFromFileToBeChanged, preposition);
				circleFromFileToBeChangedSet.add(circleFromFileToBeChanged);
	         }
		}
		
		FileReader fileReader2 = new FileReader("/Users/nishant/Desktop/PP.csv");
		@SuppressWarnings("resource")
		CSVReader getPricePointFromFileReader = new CSVReader(fileReader2, ',', '"', 1);
		String[] nextLineOfPPFile = null;
		while ((nextLineOfPPFile = getPricePointFromFileReader.readNext())!= null) {
			if (nextLineOfPPFile != null) {
				circleFromFile = nextLineOfPPFile[0];
				prepaidPP = nextLineOfPPFile[1];
				postPaidPP = nextLineOfPPFile[2];
				HashMap<String, String> pricePointValue = new HashMap<>();
				pricePointValue.put(prepaidPP,postPaidPP);
 				circleToPricePointMapping.put(circleFromFile, pricePointValue);
			}
		}
		
		
		for (String circleFromMap : circleToPricePointMapping.keySet()) {

			if (circleVsPrepositionMap.containsKey(circleFromMap)) {

				HashMap<String, String> pricePointMap = circleToPricePointMapping.get(circleFromMap);
				for (Entry<String, String> entry : pricePointMap.entrySet()) {
					String prepaidPricePoints = entry.getKey();
					String postpaidPricePoints = entry.getValue();
					String prep = circleVsPrepositionMap.get(circleFromMap);
					System.out.println(circleFromMap);
//					System.out.println(prep);
					String updatedLine = getUpdatedLine(prep, prepaidPricePoints, postpaidPricePoints);
					System.out.println("Updated preposition for circle is " +'\n'+ updatedLine);
				}
			}
		}
	}
	
	private static String getUpdatedLine(String title, String prepaidPricePoints, String postPaidPricePoints) {

		String pattern = "\\(Rs\\)\\s*-+\\s*\\d*(\\s*,\\s*\\d*)*";
		Pattern p1 = Pattern.compile(pattern);
		Matcher m = p1.matcher(title);
		StringBuilder sb = new StringBuilder(title);
//		System.out.println("Length of the string is "+sb.length());
		int offset = 0;
		if(m.find()){
//			System.out.println(m.group());
//			System.out.println("start Index:"+m.start());
//			System.out.println("end Index:"+m.end());
			prepaidPricePoints=prepaidPricePoints.replaceAll("(,)*$", "");
			sb.replace(m.start(),m.end(),RUPEECONSTANT+prepaidPricePoints);
			offset = prepaidPricePoints.length() -(m.end()-m.start()+1);
		}
		if(m.find()){
//			System.out.println(m.group());
//			System.out.println("offset:"+offset);
//			System.out.println(m.start()+offset);
//			System.out.println(m.end()+offset);
			postPaidPricePoints=postPaidPricePoints.replaceAll("(,)*$", "");
			sb.replace(m.start()+offset,m.end()+offset+8,RUPEECONSTANT+postPaidPricePoints);
		}
		return sb.toString();
	}
}