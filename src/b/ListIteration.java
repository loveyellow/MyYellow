package b;
//228
import java.util.*;

public class ListIteration {
	public static void main(String[] args){
		List<String> pets=new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g"));
		ListIterator<String> it=pets.listIterator();
		while(it.hasNext()){
			System.out.print(it.next()+","+it.nextIndex()+","+it.previousIndex()+"; ");
		}
		System.out.println();
		System.out.println(pets);
		it=pets.listIterator(5);
		while(it.hasNext()){
			System.out.println(it.next());
			it.set("p");
		}
		System.out.println(pets);
	}
}
