package b;
//245 Arrays.asList()方法被封装到相应的构造器时，利用Collections.shuffle()方法修改的是对数组的音乐，未修改数组，所以原数组不会改变。

import java.util.*;

public class ModifyingArraysAsList {
	public static void main(String[] args){
		Random random=new Random(47);
		Integer[] ia={1,2,3,4,5,6,7,8,9,10};
		List<Integer> list1=new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println(list1);
		Collections.shuffle(list1,random);
		System.out.println(list1);
		System.out.println(Arrays.toString(ia));
		List<Integer> list2=Arrays.asList(ia);
		System.out.println(list2);
		Collections.shuffle(list2,random);
		System.out.println(list2);
		System.out.println(Arrays.toString(ia));
	}
}
