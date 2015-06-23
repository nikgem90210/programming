package faltu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class WebScraper {
	public static String sendGetRequest(String endPoint,
			Map<String, String> params) {

		String result = null;

		if (endPoint.startsWith("http://") || endPoint.startsWith("https://")) {

			try {

				String urlStr = endPoint;

				if (!(params == null || params.isEmpty())) {

					urlStr += "?" + buildHTTPParameterString(params);

				}

				URL url = new URL(urlStr);

				URLConnection conn = url.openConnection();

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));

				StringBuilder sb = new StringBuilder();

				String line;

				while ((line = rd.readLine()) != null) {

					sb.append(line);

				}

				rd.close();

				result = sb.toString();

			}

			catch (MalformedURLException mex) {

				// logger.error( "URL not valid..." + endPoint,
				// mex.fillInStackTrace() );

				mex.printStackTrace();

			}

			catch (IOException iox) {

				// logger.error( "IOException while reading the response....",
				// iox.fillInStackTrace() );

				iox.printStackTrace();

			}

		}

		return result;

	}

	private static String buildHTTPParameterString(Map<String, String> params) {
		if (params == null) {
			return "";
		}

		StringBuilder result = new StringBuilder();

		for (String key : params.keySet()) {
			try {
				result = result.append(URLEncoder.encode(key, "UTF-8"))
						.append("=")
						.append(URLEncoder.encode(params.get(key), "UTF-8"))
						.append("&");
			} catch (UnsupportedEncodingException e) {
				// logger.error( "Unsupported encoding exception: ",
				// e.fillInStackTrace() );
			}
		}
		return result.toString().substring(0, result.length() - 1);
	}
	
	
	public static void main(String[] args){
		
		String ua = "AMOI N816 Linux/3.0.13 Android/4.0.4 Release/09.24.2012 Browser/AppleWebKit534.30 Profile/MIDP-2.0 Configuration/CLDC-1.1 Mobile Safari/534.30 Android 4.0.1;";
		Map<String,String> params = new HashMap<>();
		params.put("user-agent-string", ua);
		
		String str = sendGetRequest("http://tools.scientiamobile.com/", params);
		System.out.println(str);
	}
	
	
	
	
	
	
	
	
	
	
	
}
