package faltu;
import java.io.IOException;


public class FileHide {  
    public static void main(String[] args) throws InterruptedException, IOException{  
        try {  
        	if(System.getProperty("os.name").contains("Windows")) {
        	Process p = Runtime.getRuntime().exec("attrib -h C:/nik/h.txt");  
            p.waitFor();
            System.out.println("Success");
        	}
//            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  
//            String line = null;  
//            while ((line = in.readLine()) != null) {  
//                System.out.println(line);  
              
        } catch (IOException e) {  
            e.printStackTrace(); 
            
        }  
    }  
}  


//public static void hide(File src) throws InterruptedException, IOException 
//{
//
//    if(System.getProperty("os.name").contains("Windows"))
//    {
//        Process p = Runtime.getRuntime().exec("attrib +h " + src.getPath());
//        p.waitFor();
//    }
//    else
//    {
//        src.renameTo(new File(src.getParent()+ "." +src.getName()));
//    }
//}
//}