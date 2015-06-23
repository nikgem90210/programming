package faltu;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class FileSave {

	public static void main(String[] args) throws Exception{
        URL url = new URL("http://images.mid-day.com/2012/dec/Kareena-Kapoor_20.jpg");
        InputStream in = url.openStream();
        FileOutputStream fos = new FileOutputStream("kareen.jpg");
        byte[] buffer = new byte[1024];
        int i=0;
        while((i=in.read(buffer))>0){
            fos.write(buffer, 0, i);
        }
        fos.flush();
        fos.close();
    }

}
