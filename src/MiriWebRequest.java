import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MiriWebRequest {

	public static void main(String[] args) throws Exception{
		
		BufferedReader tbr = new BufferedReader(new FileReader("C:/Users/Nishant/Desktop/ram.csv"));
		String tline = null;
		tbr.readLine();
		FileWriter fw = new FileWriter("C:/Users/Nishant/Desktop/result.csv");
		fw.write("ua,release_date,brand_name,model_name,width,height,ajax_support_javascript");
		fw.write('\n');
		while((tline=tbr.readLine())!=null){
			List<String> list = processLine(tline);
			if(list.size()>0){
				String uaStr = list.get(0);
				HttpClient httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet("http://www.ducis.net/Ddr");

				httpget.addHeader("Ddr-User-Agent", uaStr); 

						try {
							HttpResponse response = httpclient.execute(httpget);
							int statusCode = response.getStatusLine().getStatusCode();
							if (statusCode == 200){             
								HttpEntity entity = response.getEntity();
								if (entity != null) {
									InputStream instream = entity.getContent();
									BufferedReader br = new BufferedReader(new InputStreamReader(instream));
									String line = null;
									String userLine = '"'+uaStr+'"'+",";
									while((line=br.readLine())!=null){
										String[] sarr = line.split(",");
										Map<String,String> map = new HashMap<>();
										for(String s:sarr){
											if(s.indexOf(':') == -1){
												continue;
											}
											String key = s.substring(0, s.indexOf(':'));
											String val = s.substring(s.indexOf(':')+1);
											map.put(key, val);
										}
										String releaseDate = map.get("\"release_date\"");
										userLine += releaseDate;
										userLine += ",";
										String vendor = map.get("\"vendor\"");
										userLine += vendor;
										userLine += ",";
										String marketing_name = map.get("\"marketing_name\"");
										userLine += marketing_name;
										userLine += ",";
										String displayWidth = map.get("\"displayWidth\"");
										userLine += displayWidth;
										userLine += ",";
										String displayHeight = map.get("\"displayHeight\"");
										userLine += displayHeight;
										userLine += ",";
										String ajax_support_getelementbyid = map.get("\"ajax_support_getelementbyid\"");
										userLine += ajax_support_getelementbyid;
										System.out.println(line);
										
										fw.write(userLine);
										fw.write('\n');	
									}						
									
								}/*System.out.println("status Code == 200");*/               
							} else if (statusCode == 204){
								System.out.println("statusCode == 204");
							} else  {
								System.out.println("Error code <> 200, 204");
							}
						} catch (ClientProtocolException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
			}
		}
		fw.close();
		tbr.close();
	}
	private static List<String> processLine(String line) {
		List<String> list = new ArrayList<>();
		String word = "";
		boolean quoteOpen = false;
		for(char c: line.toCharArray()){
			switch(c){
			case ',':
				if(!quoteOpen){
					list.add(word);
					word = "";
				}else{
					word += c;
				}
				break;
			case '"' :
				quoteOpen = !quoteOpen;   // to distinguish between starting comma and ending comma
				break;
				default:
					word += c;
			}
		}
		list.add(word);
		return list;
	}
}