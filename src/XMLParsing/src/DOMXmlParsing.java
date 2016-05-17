package XMLParsing.src;

//import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
//import org.w3c.*;
import org.w3c.dom.*;


public class DOMXmlParsing {

	public static void main(String[] args) throws Exception 
	{
		try
		{
			File file = new File("C:/Users/Nishant/Desktop/sample.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			System.out.println("Root Element --> " + doc.getDocumentElement().getNodeName());
			NodeList bookNodeList = doc.getElementsByTagName("book");
			System.out.println("================================");
			for (int i = 0 ; i < bookNodeList.getLength() ; i++)
			{
				Node bookNode = bookNodeList.item(i);
				if (bookNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element child = (Element) bookNode;
					String author = getChildElementValue(child, "author");
					String title = getChildElementValue(child, "title");
					String price = getChildElementValue(child, "price");
					System.out.println("\nAuthor = "+author+"\n Title = "+title+"\n Price = "+price+"$");
//					Element titleElement = (Element) titleList.item(0);
//					System.out.println("Title List --> " + titleElement);
//					if(titleElement == null)
//						continue;
					
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getChildElementValue(Element parentElem, String childElemName)
	{
		NodeList childList =parentElem.getElementsByTagName(childElemName).item(0).getChildNodes();
		
		Node item = childList.item(0);
		return item.getNodeValue();
	}

}
