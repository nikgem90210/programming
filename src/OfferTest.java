import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class OfferTest {

	public static void main(String[] args) throws ParseException {

		Date truncate = DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
		long currentTimemilis = truncate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = (sdf.format(currentTimemilis)).toString();
		System.out.println(date);
		
		Date timeStamp = sdf.parse(date);
		System.out.println(timeStamp.getTime());
		
		
		System.out.println(System.currentTimeMillis());
		
//		thirdClause = QueryBuilder.eq("requested_date", timeStamp.getTime());
		
		
	}

}
