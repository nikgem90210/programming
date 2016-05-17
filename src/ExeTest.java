import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

//public class ExeTest {
//    public static void main(String[] args) throws InterruptedException {
//    	long start = System.currentTimeMillis();
//    	long end = start + 60*1000; // 60 seconds * 1000 ms/sec
//        String url = "http://www.google.com";
//
//        if(Desktop.isDesktopSupported()){
//            Desktop desktop = Desktop.getDesktop();
//            try {
//                desktop.browse(new URI(url));
//                Thread.sleep(1000);
//                desktop.
////                while (System.currentTimeMillis() < end)
////            	{
////            	    
////            	}
//            } catch (IOException | URISyntaxException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }else{
//            Runtime runtime = Runtime.getRuntime();
//            try {
//                runtime.exec("xdg-open " + url);
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//}

public class ExeTest {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date parse = formatter.parse("20151029");
		Date truncate = DateUtils.truncate(parse, java.util.Calendar.DAY_OF_MONTH);
		
//		Long date = new Long(truncate.getTime());
		System.out.println("date " + truncate);
		
		System.out.println("asjndask "+truncate.getTime());
		
		
		
//		while(true){
//			try {
//				Process p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://www.google.com\"");
//				Thread.sleep(1000);
//				p.destroy();
//				System.out.println("Return value was " + p.waitFor());
//			} catch (Exception e) {}
//		}
	}
	
}