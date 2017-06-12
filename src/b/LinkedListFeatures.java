package b;
//229
import java.util.*;

public class LinkedListFeatures {
	public static void main(String[] args){
		LinkedList<String> pets=new LinkedList<String>(Arrays.asList("a","b","c","e","f"));
		System.out.println(pets);
		System.out.println("first:"+pets.getFirst());
		System.out.println("element:"+pets.element());
		System.out.println("peek:"+pets.peek());
		System.out.println("remove:"+pets.remove());
		System.out.println("removefirst:"+pets.removeFirst());
		System.out.println("poll:"+pets.poll());
		System.out.println(pets);
		pets.addFirst("g");
		System.out.println("add first:"+pets);
		pets.add("h");
		System.out.println("add:"+pets);
		pets.offer("i");
		System.out.println("offer:"+pets);
		pets.addLast("j");
		System.out.println("addlast:"+pets);
		pets.removeLast();
		System.out.println(pets);
	}
}
