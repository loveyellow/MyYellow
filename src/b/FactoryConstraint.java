package b;
//382

import org.omg.CORBA.PUBLIC_MEMBER;

interface Factory1<T>{//�����ӿ�
	T create();//������Ӧ�Ķ���
}


class Foo<T>{//���ò�ͬ�Ĺ���������Ҫ��ʵ���˹����ӿ�
	T x;
	public <F extends Factory1<T>> Foo(F factory){
		x=factory.create();
	}
}

class IntegerFactory implements Factory1<Integer>{//����Integer����Ĺ���
	public Integer create(){
		return new Integer(0);
	}
}

class Widget{
	public static class Factory implements Factory1<Widget>{//����Widget�Ĺ�������һ����̬�ڲ���
		public Widget create(){
			return new Widget();
		}
	}
}

public class FactoryConstraint {
	public static void main(String[] args){
		new Foo(new IntegerFactory());//����Integer�������ø�ֵ��Foo�е�x
		new Foo(new Widget.Factory());
	}
}
