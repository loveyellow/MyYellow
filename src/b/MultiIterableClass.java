package b;
//244

import java.util.*;

public class MultiIterableClass extends IterableClass{
	public Iterable<String> reversed(){
		return new Iterable<String>() {
			public Iterator<String> iterator() {
				System.out.println("222222222222222");
				return new Iterator<String>() {
					int current=words.length-1;
					public boolean hasNext() {
						return current>-1;
					}
					public String next() {
						return words[current--];
					}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public Iterable<String> randomized(){
		return new Iterable<String>() {
			public Iterator<String> iterator() {
					List<String> shuffled=new ArrayList<String>(Arrays.asList(words));
					Collections.shuffle(shuffled,new Random(47));
					return shuffled.iterator();
			}
		};
		
	}
	
	public static void main(String[] args){
		MultiIterableClass mic=new MultiIterableClass();
		for(String e:mic.reversed())
			System.out.print(e+" ");
		System.out.println();
		for(String e:mic.randomized())
			System.out.print(e+" ");
		System.out.println();
		for(String e:mic)
			System.out.print(e+" ");
	}
}
