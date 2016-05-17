package XMLParsing.src;

////import java.util.regex.*;
////public class PatternMatcher {
////
////	public static void main(String[] args) 
////	{
////		Pattern pattern = Pattern.compile("en-us",Pattern.CASE_INSENSITIVE);
////		Matcher matcher = pattern.matcher("Mozilla/5.0 (Linux; U; Android 2.2.2; en-us; GFIVE A57 Build/S21) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1,Android,mobile");
////		while(matcher.find())
////		{
////			System.out.println("found the text " + matcher.group() + " Starting at " + matcher.start()+ " Ending at " + matcher.end());
////		}
////
////
////	}
////
////}
//
//
//import java.io.*;
//
//public class PatternMatcher 
//{
//    public static void main(String args[]) 
//    {
//        String s,str,substr;
//        int extract,start,len,check;
//
//        try{
//            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Enter String : ");
//            System.out.flush();
//            str=obj.readLine();
//            len=str.length();
//
//            System.out.print("Enter Starting position to extract characters  : ");
//            System.out.flush();
//            s=obj.readLine();
//            start=Integer.parseInt(s);
//      //      start=start-1;
//            if(start<0 || start>len)
//            {
//                 System.out.println("INVALID POSITION");
//                 System.exit(1);
//            }
//
//            System.out.print("Enter how many characters you want to extract: ");
//            System.out.flush();
//            s=obj.readLine();
//            extract=Integer.parseInt(s);
//            check=extract+start;
//            if(check<0 || check>len )
//            {
//                 System.out.println("TRYING TO EXTRACT INVALID POSITION");
//                 System.exit(1);
//            }
//        
//           substr=str.substring(start,check);
//           System.out.println("\nEXTRACTED STRING IS "+substr);
//         }
//    catch(Exception e) {}
//
//
//    }
//}

import java.util.regex.*; 

	public class PatternMatcher 
	{ 
		public static void main(String[] args) { 
		String s = "The quick brown fox jumps over the lazy dog"; 
		int start, end; 

		// Demo 1: Build a pattern+matcher to find the word before jumps. 
		Pattern pattern = Pattern.compile("\\w+(\\s+)jumps\\b",Pattern.CASE_INSENSITIVE); 
		Matcher matcher = pattern.matcher(s); 
		if (matcher.find()) { 
			start = matcher.start(); 
			end = matcher.end(); // or end = matcher.start(1);
			String word = s.substring(start, end); 
			System.out.println("Found " + word + " at index " + start); 
		} 
		else System.out.println("Not found.");

		s = "Buddy jumps and then jumps again and finally jumps some more."; 
		matcher.reset(s); 
		System.out.println("\nIn: " + s); 
		start = 0; 
		end=0; 
		while(matcher.find(end)) { 
			start = matcher.start(); 
			end = matcher.end(); 
			String word = s.substring(start, end); 
			System.out.println("Found " + word + " at index " + start); 
		} 
		if (start < 0) System.out.println("Not found."); 
		} 
}






