package b;

import java.util.*;

//227
public class CrossContainerIteration {
	public static void display(Iterator<String> it){
		int i=0;
		while(it.hasNext()){
			System.out.print(i+":"+it.next()+" ");
			i++;
		}
		System.out.println();
	}
	public static void main(String[] args){
		ArrayList<String> pets=new ArrayList<String>(Arrays.asList("Rat","Manx","Cymric","Pug","Pug"));
		LinkedList<String> petsLL=new LinkedList<String>(pets);
		HashSet<String> petHS=new HashSet<String>(pets);
		TreeSet<String> petTS=new TreeSet<String>(pets);
		display(pets.iterator());
		display(petsLL.iterator());
		display(petHS.iterator());
		display(petTS.iterator());
	}
}
