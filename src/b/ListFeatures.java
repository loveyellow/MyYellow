package b;

import java.util.*;

public class ListFeatures {
	public static void main(String[] args){
		Random rand=new Random(47);
		List<String> pets=new ArrayList<String>(Arrays.asList("f","a","c","b","e","f"));
		System.out.println(pets);
		pets.add("g");
		System.out.println(pets);
		pets.remove("g");
		System.out.println(pets);
		String a=pets.get(1);
		System.out.println(a);
		System.out.println(pets.indexOf(a));
		System.out.println(pets.contains(a));
		pets.remove(a);
		System.out.println(pets);
		String b="c";
		System.out.println(pets.indexOf(b));
		pets.add(1, "a");
		System.out.println(pets);
		List<String> sub=pets.subList(1, 4);
		System.out.println(sub);
		System.out.println(pets.containsAll(sub));
		System.out.println("11111111"+pets);
		Collections.sort(sub);
		System.out.println("11111111"+pets);

		System.out.println(sub);
		System.out.println("11111111"+pets);

		System.out.println(pets.containsAll(sub));
		System.out.println("11111111"+pets);

		Collections.shuffle(sub,rand);
		System.out.println(sub);

		System.out.println(pets.containsAll(sub));
		List<String> copy=new ArrayList<String>(pets);
		System.out.println(pets);
		sub=new ArrayList<String>(Arrays.asList(pets.get(1),pets.get(4)));
		System.out.println(sub);
		System.out.println(copy);
        copy.removeAll(sub);
        System.out.println(sub);
        System.out.println(copy);
        System.out.println(pets);
        sub.add("1");
        System.out.println(sub);
	}
}
