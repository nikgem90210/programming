package faltu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class CSVParser {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		String csvFile = "/Users/nishant/Downloads/popcopy";
		String line = "";

		Map<String, List<Integer>> valueMap = new HashMap<String, List<Integer>>();
		String[] headers ={""};

		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		int count=0;
		while((line = br.readLine()) != null){
			String[] row = line.split(",");
			if(count==0){

				headers=row;
				for(int i=0;i<row.length;i++){
					valueMap.put(row[i], Collections.EMPTY_LIST);
				}
			}
			else{

				for(int i=0;i<row.length;i++){
					int value;
					if(StringUtils.isBlank(row[i])){
						value=0;
					}
					else
					{
						value=Integer.parseInt(row[i]);
					}
					List<Integer>valueList= new ArrayList<Integer>(valueMap.get(headers[i]));
					valueList.add(value);
					valueMap.put(headers[i], valueList);
				}
			}
			count++;
		}
		for(Iterator<String>itr=valueMap.keySet().iterator();itr.hasNext();){
			String key=itr.next();
			System.out.println("key :"+ key +" value :" + valueMap.get(key));
		}
	}
}

//BufferedReader br = new BufferedReader(new FileReader(csvFile));
//while((line = br.readLine()) != null){
//	String data[] = line.split(",");
//    System.out.println("DATA [year= " + data[0] + " , make="  
//      + data[1] + " , model=" + data[2] + " , description="  
//      + data[3] + " , price=" + data[4] + "]");  
//}