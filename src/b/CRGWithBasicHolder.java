package b;
//405

class BasicHolder<T>{//set()������get()������Ϊȷ�е����ͣ���Subtype
	T element;
	void set(T arg){
		element=arg;
	}
	T get(){
		return element;
	}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}

class Subtype extends BasicHolder<Subtype>{}//�̳�һ���������ͣ��÷������ͽ��ܱ����������Ϊ����

public class CRGWithBasicHolder {
	public static void main(String[] args){
		Subtype s1=new Subtype();
		Subtype s2=new Subtype();
		s1.set(s2);
		Subtype s3=s1.get();
		s1.f();
		
	}
}
