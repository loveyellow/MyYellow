package b;

import java.util.*;

public class PetMap {
	public static void main(String[] args){
		Map<String,Integer> petMap=new HashMap<String,Integer>();
		petMap.put("My cat", 1);
		petMap.put("My dog", 2);
		petMap.put("My Hamster",3);
		System.out.println(petMap);
		Integer a=petMap.get("My cat");
		System.out.println(a);
		System.out.println(petMap.containsKey("My cat"));
		System.out.println(petMap.containsValue(a));
	}
}
