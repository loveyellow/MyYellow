package b;
//243
import java.util.*;

public class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current=size()-1;
					public boolean hasNext() {
						return current>-1;
					}
					public T next() {
						return get(current--);
					}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public static void main(String[] args){
		ReversibleArrayList<String> ral=new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for(String e:ral)
			System.out.print(e+" ");
		System.out.println();
		for(String e:ral.reversed())
			System.out.print(e+" ");
	}
}
