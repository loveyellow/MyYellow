package b;
//340
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.BlockingDeque;


class MethodSelector implements InvocationHandler{
	private Object proxied;//��������ڵ�ʵ��
	public MethodSelector(Object proxied){
		this.proxied=proxied;
	}
	public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
		if(method.getName().equals("interesting"))//ÿ�δ��ݽ����Ĵ�������жϵ�ǰ�����Ƿ�Ϊ"interesting"
			System.out.println("Proxy detected the interesting method");
		return method.invoke(proxied, args);//�����������ת��������ı�������󣬲�������Ӧ�Ĳ���
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
		SomeMethod proxy=(SomeMethod) Proxy.newProxyInstance(//Proxy.newProxyInstance()���Դ�����̬����
				SomeMethod.class.getClassLoader(), //һ�����������ѡ���Ѿ������صĶ�������������
				new Class[]{SomeMethod.class},//һ���ô���������
				new MethodSelector(new Implementation()));//InvocationHandle�ӿڵ�һ��ʵ��
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
}
