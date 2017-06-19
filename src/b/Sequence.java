package b;
//192

interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object[] items;
	private int next=0;
	public Sequence(int size){//固定数组大小
		items=new Object[size];
	}
	public void add(Object x){//在末尾添加新的Object
		if(next<items.length)
			items[next++]=x;
	}
	private class SequenceSelector implements Selector{//内部类实现Selector接口，迭代器设计模式
		private int i=0;
		public boolean end(){//检查序列是否到达末尾
			return i==items.length;
		}
		public Object current(){//访问当前对象
			return items[i];
		}
		public void next(){//移动下标到虾一位
			if(i<items.length)
				i++;
		}
	}
	public Selector selector(){//返回一个内部类
		return new SequenceSelector();
	}
	public static void main(String[] args){
		Sequence sequence=new Sequence(10);
		for(int i=0;i<10;i++)
			sequence.add(Integer.toString(i));//初始化外部类对象中的数组
		Selector selector=sequence.selector();//创建内部类对象，指向接口，接口调用实例的具体方法
		while(!selector.end()){
			System.out.print(selector.current()+" ");//输出外部类数组中元素
			selector.next();
		}
	}
}
