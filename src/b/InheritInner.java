package b;
//212页

class WithInner{
	class Inner{
		public Inner(int i) {}//带有参数的构造函数
	}
}

public class InheritInner extends WithInner.Inner{
	//public InheritInner(){} 不能使用该构造器，因为没有获取父类外部类的引用
	public InheritInner(WithInner wi) {
		wi.super(1);//调用父类构造器时，需要一个符合父类构造器的参数
	}
	public static void main(String[] args){
		WithInner wi=new WithInner();
		InheritInner i1=new InheritInner(wi);
	}
}
