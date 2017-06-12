package b;

import java.util.ArrayList;
import java.util.List;

//321

class CountedInteger{
	private static long counter;
	private final long id=counter++;
	public String toString(){
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type=type;
	}
	public List<T> create(int nElements){
		List<T> result=new ArrayList<>();
		try {
			for(int i=0;i<nElements;i++)
				result.add(type.newInstance());//������Ĭ�ϵ��޲ι�����
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return result;
	}
	public static void main(String[] args){
		FilledList<CountedInteger> f1=new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(f1.create(15));
	}
}
