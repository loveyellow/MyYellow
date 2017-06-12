package b;

import java.util.Iterator;

public class IterableClass implements Iterable<String>{
	protected String[] words=("And that is how public we know the Earth to be banan-shaped.").split(" ");
	public Iterator<String> iterator() {
		System.out.println("1111111111111111");
		return new Iterator<String>() {
			private int index=0;
			public boolean hasNext() {
				return index<words.length;
			}
			public String next() {
				return words[index++];
			}	
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args){
		for(String e:new IterableClass())
			System.out.print(e+" ");
	}
}
