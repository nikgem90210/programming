//package SeleniumTest.src;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//
//
//public class NullPointerExceptionTest extends SeleniumTest{
//	
//	private static final Logger logger     = LoggerFactory.getLogger(NullPointerExceptionTest.class);
//	private static final String NULL_POINTER_STRING="java.lang.NullPointerException";
//	
//	public  void testSelenium() throws Exception{
//		
//		try
//		{
//			String inputLine;
//			String tLine = null;
//			BufferedReader tbr = new BufferedReader(new FileReader("C:/Users/Nishant/Desktop/url.txt"));
//			tbr.readLine();
//			while((tLine = tbr.readLine())!= null){
//			URL url = new URL(tLine);
//			URLConnection connection = url.openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			boolean isExceptionFound = false;
//			while((inputLine = br.readLine()) != null){
//				if(inputLine.contains(NULL_POINTER_STRING)){
//					logger.info("Got null pointer exception: " + inputLine);
//					isExceptionFound=true;
//					break;
//				}
//						
//			}
//			br.close();
//			
//			logger.info("Processed URL: " + baseUrl + " status error found: " + isExceptionFound);
//			}
//		}catch(MalformedURLException e){
//			logger.error("Malformed URL Exception"+ e);
//		}catch(IOException e){
//			logger.error("IO Exception"+ e);
//		}
//		
//	}
//}
