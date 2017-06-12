package b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//336

public class ShowMethod {
	public ShowMethod(int i) {	}
	public void t(){}
	public String c(String e){
		return e;
	}
	public static void main(String[] args) throws ClassNotFoundException{
//结果在编译时是不可知的，所有方法签名都是在执行时被提出来的，反射使得能够创建一个完全未知的对象，并调用此对象的方法
		Class<?> c=Class.forName("b.ShowMethod");
		Method[] methods=c.getMethods();//获取Method方法
		Constructor[] ctors=c.getConstructors();//获取构造函数
		for(Method e:methods)
			System.out.println(e);
		for(Constructor ctor:ctors)
			System.out.println(ctor);
	}
}