import org.joda.time.DateTime;

public class JsoupTest {
	
	public static void main(String[] args) {
//		DateTime lastWeek = new DateTime().minusDays(7);
//		System.out.println(lastWeek.getMillis());
		
		int hash = 17;
		
		String productId = "74134";
		String partnerName = "MobileTashan";
		String imageUrl = "http://203.122.58.93/images/ALTHVC1.jpg";
		
		
		hash = hash * 31 + productId.hashCode();
		hash = hash * 31 + partnerName.hashCode();
		hash = hash * 31 + imageUrl.hashCode();
		System.out.println(hash*0xfffffff);
		
	}
	
}
