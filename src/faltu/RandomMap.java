package faltu;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class RandomMap {

	public static void main(String[] args) {

		HashMap<String , Integer> valueMap = new HashMap<String , Integer>();
		valueMap.put("Nik", 10);
		valueMap.put("viv", 11);
		valueMap.put("ran", 15);
		valueMap.put("asd", 13);
		valueMap.put("sdg", 14);
		valueMap.put("ocx", 12);
		
//		for (String key : valueMap.keySet()){
//			System.out.println(key);
//		}
		
//		for(Iterator<String> itr=valueMap.keySet().iterator();itr.hasNext();){
//			System.out.println(itr.next());
//		}
		
//		for(Map.Entry<String, Integer> val : valueMap.entrySet()){
//			System.out.println(val.getValue());
//		}
		
		  Set<String> keyset= valueMap.keySet();
		int randomIndex = new Random().nextInt(keyset.size());
		String randomKey = keyset.toArray(new String[keyset.size()])[randomIndex];
		System.out.println(valueMap.get(randomKey));
		
	}

}
