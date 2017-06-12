package b;

import java.util.*;

public class SetOfInteger {
	public static void main(String[] args){
		Random rand=new Random(47);
		Set<Integer> intest=new HashSet<Integer>();
		for(int i=0;i<10000;i++)
			intest.add(rand.nextInt(30)+(1<<16));
		Iterator<Integer> it=intest.iterator();
		while(it.hasNext())
			System.out.print(it.next()-(1<<16)+" ");
	}
}
