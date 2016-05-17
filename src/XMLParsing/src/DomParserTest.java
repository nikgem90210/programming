package XMLParsing.src;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;


public class DomParserTest {

	public static void main(String[] args) throws Exception{
		
		String url = "http://s3-ap-southeast-1.amazonaws.com/bsbnewscast/news.xml";
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);
			System.out.println("Root Element " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("got "+nList.getLength()+" items");
			for (int i=0 ; i < nList.getLength() ; i++)
			{
				Node node = nList.item(i);
				if (node instanceof Element)
				{
				Element child = (Element) node;
				NodeList titleList = child.getElementsByTagName("title");
				Element titleElem = (Element) titleList.item(0);
				System.out.println("titleElem = "+ titleElem);
				if(titleElem == null)
					continue;
				NodeList childNodes = titleElem.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++){
					Node item = childNodes.item(j);
					if((item.getNodeType()==Node.CDATA_SECTION_NODE)||(item.getNodeType()==Node.TEXT_NODE)){
						System.out.println("title = "+item.getNodeValue());
					}
				}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
