package XMLParsing.src;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class DOMXmlUrlParsing {

	public static void main(String[] args) throws Exception
	{
		String url = "http://s3-ap-southeast-1.amazonaws.com/bsbnewscast/news.xml";
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);
			
			System.out.println("Root Element--> " + doc.getDocumentElement().getNodeName());
			
			NodeList itemNodeList = doc.getElementsByTagName("item");
			System.out.println("=============================================");
			for (int i = 0 ; i < itemNodeList.getLength() ; i++)
			{
				Node itemNode = itemNodeList.item(i);
				if (itemNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element child = (Element) itemNode;				
					System.out.println("ID--> " + getValue("id",child));
					System.out.println("TITLE--> " + getValue("title",child));
					System.out.println("Short-Title--> " + getValue("short_title",child));
//					System.out.println("LINK--> " + getValue("link",child));
//					System.out.println("DESCRIPTION--> " + getValue("description",child));
					System.out.println("\n");
//					NodeList childList = child.getElementsByTagName("title");
//					Element idElem = (Element) childList.item(0);
//					Node idNode = idElem.getChildNodes().item(0);
//					System.out.println("TITLE--> " +idNode.getNodeValue());
//					System.out.println("\n");		
//					
//					Node item = (Node) childList.item(0);
					
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String getValue(String tag, Element element)
	{
		NodeList tagNodeList = element.getElementsByTagName(tag);
		if(tagNodeList==null){
			return "";
		}
		Node tagNode = tagNodeList.item(0);
		if(tagNode==null){
			return "";
		}
		NodeList tagChildNodeList = tagNode.getChildNodes();
		for(int i=0;i<tagChildNodeList.getLength();i++){
			Node node = tagChildNodeList.item(i);
			if(node.getNodeType()==Node.TEXT_NODE||node.getNodeType()==Node.CDATA_SECTION_NODE){
				String nodeValue = node.getNodeValue();
				return nodeValue;
			}
		}
		return "";
	}
}	
	
	
	
	
	