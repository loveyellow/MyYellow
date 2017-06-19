package b;
//206页

interface Incrementable{//Incrementable中含有一个increment()方法
	void increment();
}

class Callee1 implements Incrementable{//Callee1类实现了Incrementable接口
	private int i=0;
	public void increment(){
		i++;
		System.out.println(i);
	}
}

class MyIncrement{//MyIncrement类中创建了自己的increment()方法
	public void increment(){
		System.out.println("Other operation");
	}
	static void f(MyIncrement mi){
		mi.increment();
	}
}

class Callee2 extends MyIncrement{//Callee2类继承了MyIncrement类，拥有了不同的increment()方法
	private int i=0;
	public void increment(){
		super.increment();
		i++;
		System.out.println(i);
	}
	private class Closure implements Incrementable{//内部类实现了Incrementable接口，拥实现了该接口中的increment()方法
		public void increment(){
			Callee2.this.increment();
		}
	}
	Incrementable getCallbackReference(){//产生内部类Closure的对象
		return new Closure();
	}
}

class Caller{
	private Incrementable callbackReference;//存入Incrementable引用
	Caller(Incrementable cbh){//构造方法中，要求接受Incrementable类型的引用
		callbackReference=cbh;
	}
	void go(){
		callbackReference.increment();//Incrementable引用自动调用相应的increment()方法
	}
}

public class Callbacks {
	public static void main(String[] args){
		Callee1 c1=new Callee1();
		Callee2 c2=new Callee2();
		MyIncrement.f(c2);//调用自己MyIncrement中的方法
		Caller caller1=new Caller(c1);//Caller构造函数要求Incrementable类型的接口
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
