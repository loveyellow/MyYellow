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
//����ڱ���ʱ�ǲ���֪�ģ����з���ǩ��������ִ��ʱ��������ģ�����ʹ���ܹ�����һ����ȫδ֪�Ķ��󣬲����ô˶���ķ���
		Class<?> c=Class.forName("b.ShowMethod");
		Method[] methods=c.getMethods();//��ȡMethod����
		Constructor[] ctors=c.getConstructors();//��ȡ���캯��
		for(Method e:methods)
			System.out.println(e);
		for(Constructor ctor:ctors)
			System.out.println(ctor);
	}
}