package b;
//206ҳ

interface Incrementable{//Incrementable�к���һ��increment()����
	void increment();
}

class Callee1 implements Incrementable{//Callee1��ʵ����Incrementable�ӿ�
	private int i=0;
	public void increment(){
		i++;
		System.out.println(i);
	}
}

class MyIncrement{//MyIncrement���д������Լ���increment()����
	public void increment(){
		System.out.println("Other operation");
	}
	static void f(MyIncrement mi){
		mi.increment();
	}
}

class Callee2 extends MyIncrement{//Callee2��̳���MyIncrement�࣬ӵ���˲�ͬ��increment()����
	private int i=0;
	public void increment(){
		super.increment();
		i++;
		System.out.println(i);
	}
	private class Closure implements Incrementable{//�ڲ���ʵ����Incrementable�ӿڣ�ӵʵ���˸ýӿ��е�increment()����
		public void increment(){
			Callee2.this.increment();
		}
	}
	Incrementable getCallbackReference(){//�����ڲ���Closure�Ķ���
		return new Closure();
	}
}

class Caller{
	private Incrementable callbackReference;//����Incrementable����
	Caller(Incrementable cbh){//���췽���У�Ҫ�����Incrementable���͵�����
		callbackReference=cbh;
	}
	void go(){
		callbackReference.increment();//Incrementable�����Զ�������Ӧ��increment()����
	}
}

public class Callbacks {
	public static void main(String[] args){
		Callee1 c1=new Callee1();
		Callee2 c2=new Callee2();
		MyIncrement.f(c2);//�����Լ�MyIncrement�еķ���
		Caller caller1=new Caller(c1);//Caller���캯��Ҫ��Incrementable���͵Ľӿ�
		Caller caller2=new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}/*Output:
Other operation
1
1
2
Other operation
2
Other operation
3
*/
