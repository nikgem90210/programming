package faltu;

import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonCreate {
	
		private static final String fileName = "/Users/nishant/Desktop/parse.txt";
	
	 	@SuppressWarnings("unchecked")
		public static void  main(String[] args) {
			
	 		JSONObject jsonObject = new JSONObject();
	 		
	 		jsonObject.put("Name", "Nishant Pant");
	 		jsonObject.put("Company", "Bharti SoftBank");
	 		jsonObject.put("URL", "http://www.nik.com/");
	 		jsonObject.put("Site Name", "Nishant");
	 		jsonObject.put("Members", 3);
	 		
	 		JSONArray jsonArray = new JSONArray();
	 		
	 		jsonArray.add("Vivek");
	 		jsonArray.add("Ranjan");
	 		jsonArray.add("Piyush");
	 		
	 		jsonObject.put("Client", jsonArray);
	 		
	 		try{
	 			FileWriter fw = new FileWriter(fileName);
	 			fw.write(jsonObject.toJSONString());
	 			fw.flush();
	 			fw.close();
	 			
	 		}
	 		catch(Exception e){
	 			e.printStackTrace();
	 		}
	 		if (!fileName.isEmpty()){
	 			System.out.println("Success");
	 		}
	 		
		}
	
}
