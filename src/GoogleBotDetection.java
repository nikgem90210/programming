import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
	 
	public class GoogleBotDetection {
	 
		public static void main(String[] args) throws Exception {
	 
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("abcdefg.com");
			request.setHeader("user-agent", "fake googlebot");
			HttpResponse response = client.execute(request);
			System.out.println(response);
		}
	 
}
