package XMLParsing.src;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Sorting {

	public static void main(String[] args) {
		String url = "http://s3-ap-southeast-1.amazonaws.com/bsbnewscast/news.xml";
		try {
			List<News> newsList = getNewsFromUrl(url);
			for(int i=0;i<newsList.size();i++){
				News news = newsList.get(i);
				System.out.println(news.getId());
				System.out.println(news.getTitle());
				System.out.println(news.getPublishDate());
			}
			Comparator<News> comparator = new Comparator<News>() {

				@Override
				public int compare(News news1, News news2) {
					if(news1==null && news2==null){
						return 0;
					}
					if(news1==null){
						return -1;
					}
					if(news2==null){
						return 1;
					}
					if(news1.getPublishDate().getTime()>news2.getPublishDate().getTime()){
						return 1;
					}else if(news1.getPublishDate().getTime()<news2.getPublishDate().getTime()){
						return -1;
					}
					return 0;
				}
				
			};
			TreeSet<News> newsSet = new TreeSet<>(comparator );
			newsSet.addAll(newsList);
			for(News news:newsSet){
				System.out.println(news.getPublishDate());
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static List<News> getNewsFromUrl(String url) throws Exception
	{
		List<News> newsList = new ArrayList<>();
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
						newsList.add(news);
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
		return newsList;
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
	
	
}
