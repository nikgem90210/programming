package faltu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBRReadline {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("Enter Lines Of Text");
		System.out.println("Enter 'end' to exit");
		do{
	    
		str = br.readLine();
		
		int index = str.indexOf("end");
		if (index == -1){
			System.out.println(str);
		}else{
			System.out.println(str.substring(0, index));
		}
		
		
		}
		while(str.indexOf("end")!=-1);

	}

}			
				
				
		/*String[] temp = str.split("-");
		for(int i = 0 ; i < temp.length ; i++)
			System.out.println(temp[i]);*/
		
		/*String line = null;
		while((line=br.readLine())!=null){
			if(line.indexOf("<div class=\"titlePageSprite star-box-giga-star\">")!=-1){
				String rating = line.substring(line.indexOf('>')+1,line.lastIndexOf('<'));
				System.out.println(rating);
				break;
}
}*/

	
