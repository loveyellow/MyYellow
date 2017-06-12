package b;
//340
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.BlockingDeque;


class MethodSelector implements InvocationHandler{
	private Object proxied;//存入具体借口的实现
	public MethodSelector(Object proxied){
		this.proxied=proxied;
	}
	public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
		if(method.getName().equals("interesting"))//每次传递进来的代理对象判断当前方法是否为"interesting"
			System.out.println("Proxy detected the interesting method");
		return method.invoke(proxied, args);//将具体的请求转发给具体的被代理对象，并传入相应的参数
	}
}

interface SomeMethod{
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethod{
	public void boring1(){
		System.out.println("boring1");
	}
	public void boring2(){
		System.out.println("boring2");
	}
	public void interesting(String arg){
		System.out.println("interesting "+arg);
	}
	public void boring3(){
		System.out.println("boring3");
	}
}

public class SelectingMethods {
	public static void main(String[] args){
		SomeMethod proxy=(SomeMethod) Proxy.newProxyInstance(//Proxy.newProxyInstance()可以创建动态代理
				SomeMethod.class.getClassLoader(), //一个类加载器（选择已经被加载的对象的类加载器）
				new Class[]{SomeMethod.class},//一个该代理期望的
				new MethodSelector(new Implementation()));//InvocationHandle接口的一个实现
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
}
