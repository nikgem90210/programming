package faltu;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLDOMParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String xmlUrl = "http://cricket.hosted.stats.com/static_data/xmls/tracker/1869_tracker.xml";
		
		String content = getContent(xmlUrl);
		
			ByteArrayInputStream is = new ByteArrayInputStream(content.getBytes("UTF-8"));
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse("http://cricket.hosted.stats.com/static_data/xmls/tracker/1869_tracker.xml");
			
			NodeList nl = doc.getChildNodes();
			
			System.out.println(nl.item(0));
			
	}
	
	private static String getContent(String filepath) {
		String content = "";
		String line = null;
		HttpGet get = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(filepath);
			HttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				InputStream inputStream = response.getEntity().getContent();
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(inputStream));
				while ((line = bufferedReader.readLine()) != null) {
					content += line;
					content += '\n';
				}
				return content;
			}
		}

		catch (FileNotFoundException e) {
			System.err.println("exception in finding list " + e.getMessage());
		} catch (IOException e) {
			System.err.println("exception in finding list " + e.getMessage());
		} finally {
			if (get != null) {
				get.releaseConnection();
			}
		}
		return null;
	}
	
}
