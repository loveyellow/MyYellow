package b;
//214页

interface Counter{
	int next();//用于返回序列中的下一个值
}

public class LocalInnerClass {
	private int count=0;
	Counter getCounter(final String name){
		class LocalCounter implements Counter{//局部内部类，定义在方法中
			public LocalCounter(){
				System.out.println("LocalCounter()");
			}
			public int next(){
				System.out.print(name);
				return count++;
			}
		}
		return new LocalCounter();
	}
	Counter getCounter2(final String name){
		return new Counter(){//匿名内部类
			{
				System.out.println("Counter()");
			}
			public int next(){
				System.out.print(name);
				return count++;
			}
		};
	}
	public static void main(String[] args){
		LocalInnerClass lic=new LocalInnerClass();//创建外部类对象
		Counter c1=lic.getCounter("Local inner");//通过外部类对象调用方法创建局部内部类
		Counter c2=lic.getCounter2("Anonymous inner");//通过外部类对象创建匿名内部类
		for(int i=0;i<5;i++)
			System.out.println(c1.next());
		for(int i=0;i<5;i++)
			System.out.println(c2.next());
	}
}/*Output:
LocalCounter()
Counter()
Local inner0
Local inner1
Local inner2
Local inner3
Local inner4
Anonymous inner5
Anonymous inner6
Anonymous inner7
Anonymous inner8
Anonymous inner9*/