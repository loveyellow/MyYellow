package b;
//287

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	public String toString(){
		return "InfiniteRecursion"+"    "+super.toString()+"\n";//���ֱ�ӵ���this,this��ָ��toString�������������ݹ�
	}
	public static void main(String[] args){
		List<InfiniteRecursion> v=new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++)
			v.add(new InfiniteRecursion());
		System.out.println(v);
	}
}