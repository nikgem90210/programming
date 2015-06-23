package faltu;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonParse {
	
	private static final String fileName = "/Users/nishant/Desktop/parse.json";

	public static void main(String[] args) {

		JSONParser jsonParser = new JSONParser();
		
		try{
			
			List<String> dataList = new ArrayList<String>();
			
			FileReader fileReader = new FileReader(fileName);
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			String name = (String) jsonObject.get("Name");
			dataList.add(name);
			String company = (String) jsonObject.get("Comapany");
			dataList.add(company);
			String siteName = (String) jsonObject.get("Site Name");
			dataList.add(siteName);
			long members = (long) jsonObject.get("Members");
			String url = (String) jsonObject.get("URL");
			dataList.add(url);
			
			List<String> clientList = new ArrayList<String>();
			JSONArray jsonArray = (JSONArray) jsonObject.get("Client");
			if(jsonArray != null && jsonArray.size() >0){
				clientList.addAll(jsonArray);
			}
//			System.out.println(dataList);
			Map<List<String>, List<String>> list = new HashMap<>();
			
			list.put(dataList, clientList);
			System.out.println(list);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
