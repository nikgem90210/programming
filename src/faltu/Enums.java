package faltu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public enum Enums{

	PHOTOS("photos", "4-P-A"),
	VIDEOS("videos", "4-V-A"),
	MOVIES("movies", "4-M-A"),
	STARS("stars", "4-S-A"),
	NEWS("news", "4-N-A"),
	CRICKET("cricket", "4-C-A"),
	TOPTEN("t10", "4-T-A");

	private String propertyName;
	private String analyticsId;

	private Enums(String propertyName, String analyticsId)
	{

		this.propertyName = propertyName;
		this.analyticsId = analyticsId;

	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getAnalyticsId() {
		return analyticsId;
	}
	public void setAnalyticsId(String analyticsId) {
		this.analyticsId = analyticsId;
	}


	private static Map<String, String> valueMap = new HashMap<String, String>();
	
	static {
		for(Enums propertyData : Enums.values()){
			valueMap.put(propertyData.getPropertyName(), propertyData.getAnalyticsId() );
		}
	}

	
//	public static String getProperty(Map<String, Enums> map, Object anal ){
//		for(String property : valueMap.keySet()){
//			if(map.get(property).equals(anal)){
//				return property;
//			}
//		}
//		return null;
//	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter The Value");
	    String anal= scan.nextLine();

		for(String property : valueMap.keySet()){
			if(valueMap.get(property).equals(anal)){
				System.out.println(property);
			}
		}
	}

}










