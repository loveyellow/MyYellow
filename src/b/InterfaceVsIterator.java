package b;
//239

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterfaceVsIterator {
	public static void display(Iterator<String> it){
		System.out.print("Iterator:");
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	public static void display(Collection<String> coll){
		System.out.print("Collection:");
		for(String e:coll)
			System.out.print(e+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
				List<String> petList=Arrays.asList("Rat","Manx","Cymric","Mutt","Pug","Cymric","Pug","Manx");
		Set<String> petSet=new HashSet<String>(petList);
		Map<String, String> petMap=new LinkedHashMap<String,String>();
		String[] names=("Ralph,Eric,Robin,Lacey,Britney,Sam,Spot,Fluffy").split(",");
		String[] pets=("Rat,Manx,Cymric,Mutt,Pug,Cymric,Pug,Manx").split(",");
		for(int i=0;i<names.length;i++)
			petMap.put(names[i], pets[i]);
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
		InterfaceVsIterator.display(petList.iterator());
	}
}
