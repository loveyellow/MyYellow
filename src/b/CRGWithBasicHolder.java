package b;
//405

class BasicHolder<T>{//set()方法和get()方法都为确切的类型，即Subtype
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

class Subtype extends BasicHolder<Subtype>{}//继承一个泛型类型，该泛型类型接受本类的名字作为参数

public class CRGWithBasicHolder {
	public static void main(String[] args){
		Subtype s1=new Subtype();
		Subtype s2=new Subtype();
		s1.set(s2);
		Subtype s3=s1.get();
		s1.f();
		
	}
}
