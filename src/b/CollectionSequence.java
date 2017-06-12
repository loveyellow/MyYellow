package b;
//240

import java.util.*;

public class CollectionSequence extends AbstractCollection<String>{
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
	
	private String[] pets=("Rat,Manx,Cymric,Mutt,Pug,Cymric,Pug,Manx").split(",");
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index=0;
			public String next() {
				return pets[index++];
			}
			public boolean hasNext() {
				return index<pets.length;
			}
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	public int size() {
		return pets.length;
	}
	
	public static void main(String[] args){
		CollectionSequence c=new CollectionSequence();
		display(c);
		display(c.iterator());
	}
}
