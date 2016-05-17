import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HBOLogMigration {

	public static void main(String[] args) {
		
		int date;
		String urlFormat = "http://s3-ap-southeast-1.amazonaws.com/logfet-bsbportal/dop/offers_log-%s.gz";
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 8, 19);
		Date currentDate = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while(calendar.getTimeInMillis() < currentDate.getTime()){
			System.out.println(String.format(urlFormat, sdf.format(calendar.getTime())));
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		

	}

}
