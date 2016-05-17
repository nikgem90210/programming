package XMLParsing.src;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.*;

import org.w3c.dom.*;


public class ParsingXml {

	public static void main(String[] args) throws Exception
	{
		String url = "http://s3-ap-southeast-1.amazonaws.com/bsbnewscast/news.xml";
		try
		{
			FileWriter fw = new FileWriter("C:/Users/Nishant/Desktop/XML Read.rtf");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(url);
			
			System.out.println("ROOT ELEMENT --> " + doc.getDocumentElement().getNodeName());
			System.out.println("====================================");
			
			NodeList listOfNews = doc.getElementsByTagName("news");
			for (int i = 0 ; i < listOfNews.getLength() ; i++)
			{
				Node newsNode = listOfNews.item(i);
				NodeList itemList = newsNode.getChildNodes();
				for(int j = 0 ; j < itemList.getLength() ; j++)
				{
					Node itemNode = itemList.item(j);
					System.out.println(itemNode);
					if(itemNode instanceof Element)
					{
						Element child = (Element) itemNode;
						String Id = getValue("id",child);
						String ShortTitle = getValue("short_title",child);
						String Title = getValue("title",child);
						String PublishDate = getValue("publish_date",child);
						String LastUpdate = getValue("last_update",child);
						String Place = getValue("place",child);
						String Keywords = getValue("keywords",child);
						String Url = getValue("url",child);
						String Category = getValue("category",child);
						String Synopsis = getValue("synopsis",child);
						News news = new News();
						news.setId(Id);
						news.setTitle(Title);
						news.setShortTitle(ShortTitle);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
						Date pdate = sdf.parse(PublishDate);
						news.setPublishDate(pdate);
						serializeNewsToFile(news, "C:/Users/Nishant/Desktop/serialised-data-"+j+".txt");
					}
				}
			}
			
		//	System.out.println("Number of News --> " + listOfNews.getLength());
			fw.flush();
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String getValue(String tag , Element element)
	{
		NodeList tagNodeList = element.getElementsByTagName(tag);
		Node tagNode = tagNodeList.item(0);
		if(tagNode==null){
			return "";
		}
		NodeList tagChildNodeList = tagNode.getChildNodes();
		for(int i = 0 ; i < tagChildNodeList.getLength() ; i++)
		{
			Node node = tagChildNodeList.item(i);
			if(node.getNodeType()==Node.TEXT_NODE || node.getNodeType()==Node.CDATA_SECTION_NODE)
			{
				String nodeValue = node.getNodeValue();
				return nodeValue;
			}
		}
		return "";
	}
	
	public static void serializeNewsToFile(News news, String filePath){
		try 
		{
			FileOutputStream out = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(news);
			oos.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}