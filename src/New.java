import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class New {

	public void getPricePoints(String s){
		String pattern = "\\(Rs\\)\\s*-+\\s*\\d*(\\s*,\\s*\\d*)*";
		//Pattern p1 = Pattern.compile("data recharge amount \\(Rs\\)\\s*-+\\s*[0-9,\\s*]*");
		//Pattern p1 = Pattern.compile("data boosters worth \\(Rs\\)\\s*-+\\s*[0-9,\\s*]*");
		//Pattern p1 = Pattern.compile("data recharge amount "+pattern);
		Pattern p1 = Pattern.compile(pattern);
		Matcher m = p1.matcher(s);
		
		while(m.find()){
			
			System.out.println(m.group());
			System.out.println("start Index:"+m.start());
			System.out.println("end Index:"+m.end());
		}
	}
	
//	public String[] getCsvColumns(String filePath){
//		CSVReader cr = null ;
//		String[] columns=null;
//		try {
//			cr = new CSVReader(new FileReader(filePath));
//			columns = cr.readNext();
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e) {
//			System.out.println("Not able to read file exception is coming");
//		}finally{
//			try {
//				cr.close();
//			} catch (IOException e) {
//				System.out.println("Exception while closing stream");
//			}
//		}	
//		return columns;	
//	}
	public void readCsvFile(String filePath){

		CSVReader cr = null;
		CSVWriter cw = null;
		String[] lineArray;
		
		try {
			cr = new CSVReader(new FileReader(filePath));
			cw = new CSVWriter(new FileWriter("/Users/nishant/Desktop/HBOUpdated.csv"));
			System.out.println("Reading csv file at"+filePath);
			int i = 1;
			String[] columns = cr.readNext();
			cw.writeNext(columns);
			System.out.println(Arrays.toString(columns));
			while((lineArray = cr.readNext())!=null){
				System.out.println("Line"+i+":");
				System.out.println("---------------------------------");
				System.out.println(lineArray[7]);
				lineArray[7] = getUpdatedLine(lineArray[7],lineArray[lineArray.length-2],lineArray[lineArray.length-1]);
				System.out.println("Writing New Line into file");
				System.out.println(lineArray[7]);
				cw.writeNext(lineArray);
				i++;
			}
			System.out.println("Read complete");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Not able to read file exception is coming");
		}finally{
			try {
				cr.close();
				cw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
	}
	private String getUpdatedLine(String string, String prepaidPricePoints, String postPaidPricePoints) {

		String pattern = "\\(Rs\\)\\s*-+\\s*\\d*(\\s*,\\s*\\d*)*";
		//Pattern p1 = Pattern.compile("data recharge amount \\(Rs\\)\\s*-+\\s*[0-9,\\s*]*");
		//Pattern p1 = Pattern.compile("data boosters worth \\(Rs\\)\\s*-+\\s*[0-9,\\s*]*");
		//Pattern p1 = Pattern.compile("data recharge amount "+pattern);
		Pattern p1 = Pattern.compile(pattern);
		Matcher m = p1.matcher(string);
		StringBuilder sb = new StringBuilder(string);
		System.out.println("String is "+ string);
		System.out.println("Length of the string is "+string.length());
		int offset = 0;
		if(m.find()){
			System.out.println(m.group());
			System.out.println("start Index:"+m.start());
			System.out.println("end Index:"+m.end());
			System.out.println(prepaidPricePoints);
			sb.replace(m.start(),m.end(),"(Rs) "+prepaidPricePoints);
			offset = prepaidPricePoints.length() -(m.end()-m.start()+1);
		}
		if(m.find()){
			System.out.println(m.group());
			System.out.println("offset:"+offset);
			System.out.println(m.start()+offset);
			System.out.println(m.end()+offset);
			System.out.println(postPaidPricePoints);
			sb.replace(m.start()+offset,m.end()+offset+1,"(Rs) "+postPaidPricePoints);
		}
		return sb.toString();
	}

	public void readFile(String filePath){
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader(filePath));
			System.out.println("Reading csv file at"+filePath);
			int i = 1;
			br.readLine();
			while((line = br.readLine())!=null){
				System.out.println("Line"+i+":");
				System.out.println("---------------------------------");
				System.out.println(line);
				getPricePoints(line);
				i++;
			}
			System.out.println("Read complete");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Not able to read file exception is coming");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	private static void printList(List<String> myList) {
        for (String string : myList) {
            System.out.println(string);
        }
    }
	public static void main(String[] args){
		//System.out.println(Pattern.matches("[amn]", "amn"));
//		New r = new New();
//		r.readCsvFile("/Users/nishant/Downloads/Micromax E471.csv");

		        List<String> myList = new ArrayList<String>();
		        myList.add("one");
		        myList.add("two");
		        myList.add("three");
		        myList.add("four");
		        myList.add("five");

		        System.out.println("Inserted in 'order': ");
		        printList(myList);
		        System.out.println("\n");
		        System.out.println("Inserted out of 'order': ");

		        // Clear the list
		        myList.clear();

		        myList.add("four");
		        myList.add("five");
		        myList.add("one");
		        myList.add("two");
		        myList.add("three");

		        printList(myList);
	}
}
