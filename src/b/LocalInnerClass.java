package b;
//214ҳ

interface Counter{
	int next();//���ڷ��������е���һ��ֵ
}

public class LocalInnerClass {
	private int count=0;
	Counter getCounter(final String name){
		class LocalCounter implements Counter{//�ֲ��ڲ��࣬�����ڷ�����
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
		return new Counter(){//�����ڲ���
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
		LocalInnerClass lic=new LocalInnerClass();//�����ⲿ�����
		Counter c1=lic.getCounter("Local inner");//ͨ���ⲿ�������÷��������ֲ��ڲ���
		Counter c2=lic.getCounter2("Anonymous inner");//ͨ���ⲿ����󴴽������ڲ���
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