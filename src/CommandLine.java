import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public class CommandLine {
//	public static void main(String args[]){
//		for(int i=0; i< args.length; i++)
//		{
//			System.out.println("args [" + i + "]: " + args[i]);
//		}
//	}
	
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Jane");
		names.add("Adam");
		names.add("Tom");
		
	    String result = Joiner.on(",").join(names);
	    
	    try {
			FileWriter writer = new FileWriter("/Users/admin/Desktop/test.csv");
			writer.append(result);
			
			writer.flush();
		    writer.close();
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println(result);
		
	}

}
