package b;
//240

import java.rmi.activation.UnknownObjectException;
import java.util.Collection;
import java.util.Iterator;

class PetSequence{
	protected String[] pets=("Rat,Manx,Cymric,Mutt,Pug,Cymric,Pug,Manx").split(",");
}

public class NonCollectionSequence extends PetSequence{

	public static void display(Iterator<String> it){
		System.out.print("Iterator:");
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
//	public static void display(Collection<String> coll){
//		System.out.print("Collection:");
//		for(String e:coll)
//			System.out.print(e+" ");
//		System.out.println();
//	}
	
	public Iterator<String> iterator(){
		return new Iterator<String>(){
			private int index=0;
			public boolean hasNext() {
				return index<pets.length;
			}
			public String next() {
				return pets[index++];
			}
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args){ 
		NonCollectionSequence nc=new NonCollectionSequence();
		display(nc.iterator());
	}
}
