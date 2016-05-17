import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;


public class VParse {

	public static void main(String[] args) {
		
//		List<String> tagsList = new ArrayList<>();
//		
//		List<String> circleList = new ArrayList<>();
//		circleList.add("hp");
//		circleList.add("dl");
//		circleList.add("mp");
//		
//		for (String circle : circleList) {
//			StringBuilder builder = new StringBuilder();
//			builder.append("circle_" + circle);
//			tagsList.add(builder.toString());
//		}
//		
//		System.out.println(tagsList);
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("M H:m:s z");
		String format = sdf.format(new Date());
		
		System.out.println(new Date());
		
		Calendar cal = Calendar.getInstance();
		cal.clear(Calendar.DATE);
		
		Date truncatedDate = DateUtils.truncate(new Date(), Calendar.DATE);
		
		System.out.println(format);
		
		String as = "as";
		String a = "http://203.122.58.93/images/iiscandyac.jpg/"+as;
		System.out.println(a);
	}

}
