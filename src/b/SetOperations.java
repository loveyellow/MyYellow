package b;
//232
import java.util.*;

public class SetOperations {
	public static void main(String[] args){
		Set<String> set1=new HashSet<String>();
		Collections.addAll(set1,"A,B,C,D,E,F,G,H,I,J,K,L".split(","));
		set1.add("M");
		System.out.println(set1.contains("M"));
		System.out.println(set1.contains("N"));
		Set<String> set2=new HashSet<String>();
		Collections.addAll(set2, "A,B,C,G".split(","));
		System.out.println(set1.containsAll(set2));
		set1.remove("G");
		System.out.println(set1.containsAll(set2));
		set1.removeAll(set2);
		System.out.println(set1);
		Collections.addAll(set1, "X,Y,Z".split(","));
		System.out.println(set1);
	}
}
