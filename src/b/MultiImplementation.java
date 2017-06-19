package b;


//205页

class D{}
abstract class E{}
class Z extends D{//外部了继承了D类
	E makeE(){//
		return new E(){};//匿名内部类继承了E类，与外部类实现了多重继承
	}
}

public class MultiImplementation {
	static void takesD(D d){}//接受D类及其子类的引用
	static void takesE(E e){}//接受E类及其子类的引用
	public static void main(String[] args){
		Z z=new Z();
		takesD(z);
		takesE(z.makeE());
	}
}