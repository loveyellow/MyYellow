package b;
//245 Arrays.asList()��������װ����Ӧ�Ĺ�����ʱ������Collections.shuffle()�����޸ĵ��Ƕ���������֣�δ�޸����飬����ԭ���鲻��ı䡣

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
