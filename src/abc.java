import java.util.Date;

import redis.clients.jedis.Jedis;

public class abc {

	
	public static void main(String[] args) {
		
		
		long date = System.currentTimeMillis();
		Date newDate = new Date(date);
		System.out.println(newDate);
		
		
//		Jedis jedis = new Jedis("localhost");
//		System.out.println("Server is running: "+jedis.ping());
		
		
		
		
		
		
		
		
//		String a = "<center><b>Lenovo A6000 plus offer!!</b></center><br><b>4G/3G Double Data offer for 2 months </b>"
//				+ "<br><b>Offer valid for the following data recharge amount (Rs) - 12 </b>"
//				+ "Offer valid on myPlan data booster(Rs) - 23 <br>"
//				+ "<b>please ensure to subscribe a valid data booster before claiming the offer"
//				+ "</b>Offer will be activated within 48hours, offer once activated cannot be reversed or re-claimed";
//		String b;
//		
//		String result = 
		
//		String a = "[dongle]";
//		a = a.replaceAll("\\[","");
//		a = a.replaceAll("\\]","");
//		
//		System.out.println(a);
		
//		String msisdn = "+919932106105";
//		
//		if(msisdn.startsWith("0")){
//    		String substring = msisdn.substring(1,msisdn.length());
//    		msisdn = "91" + substring;
//    	}else if (msisdn.startsWith("+91")) {
//    		String substring = msisdn.substring(1,msisdn.length());
//    		msisdn = substring;
//    	}else if (!msisdn.startsWith("+91") && !msisdn.startsWith("91")) {
//    		msisdn = "91" + msisdn;
//    	}
//		
//		System.out.println(msisdn);
		
	}
}
