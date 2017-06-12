package b;
//382

import org.omg.CORBA.PUBLIC_MEMBER;

interface Factory1<T>{//工厂接口
	T create();//创建相应的对象
}


class Foo<T>{//调用不同的工厂方法，要求都实现了工厂接口
	T x;
	public <F extends Factory1<T>> Foo(F factory){
		x=factory.create();
	}
}

class IntegerFactory implements Factory1<Integer>{//创建Integer对象的工厂
	public Integer create(){
		return new Integer(0);
	}
}

class Widget{
	public static class Factory implements Factory1<Widget>{//创建Widget的工厂，是一个静态内部类
		public Widget create(){
			return new Widget();
		}
	}
}

public class FactoryConstraint {
	public static void main(String[] args){
		new Foo(new IntegerFactory());//创建Integer对象，引用赋值给Foo中的x
		new Foo(new Widget.Factory());
	}
}
