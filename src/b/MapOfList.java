package b;
//235

import java.util.*;

public class MapOfList {
	public static Map<String,List<Integer>> 
	  petPeople=new HashMap<String,List<Integer>>();
	static{
		petPeople.put("Dawn",Arrays.asList(1,2,3,4));
		petPeople.put("Kate", Arrays.asList(2,2));
		petPeople.put("Marilyn",Arrays.asList(15));
		petPeople.put("Luke", Arrays.asList(10,11));
	}
	public static void main(String[] args){
		System.out.println("People:"+petPeople.keySet());
		System.out.println("Pet:"+petPeople.values());
		for(String e:petPeople.keySet()){
			System.out.println("People "+e+"has:");
			for(Integer a:petPeople.get(e)){
				System.out.print("   "+a+" ");
				}
			System.out.println();
		}
	}
}
