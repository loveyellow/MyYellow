package b;

import java.util.*;
//226
public class SimpleIteration {
	public static void main(String[] args){
		List<String> pets=new ArrayList<String>(Arrays.asList("a","b","c","d","e","f"));
		Iterator<String> it=pets.iterator();
		int i=0;
		while(it.hasNext()){
			System.out.print(i+":"+it.next()+" ");
			i++;
		}
		System.out.println();
		for(String e:pets)
			System.out.print(e);
		System.out.println();
		it=pets.iterator();
		for(i=0;i<5;i++){
			it.next();
			it.remove();
		}
		System.out.println(pets);
	}
	
}
