package XMLParsing.src;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class DeserialiseTest {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/Users/Nishant/Desktop/serialised-data-0.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object object = ois.readObject();
		News news = (News)object;
		System.out.println(news.getId());
		System.out.println(news.getTitle());
		System.out.println(news.getPublishDate());
		ois.close();
	}

}
