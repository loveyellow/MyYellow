package b;


//205ҳ

class D{}
abstract class E{}
class Z extends D{//�ⲿ�˼̳���D��
	E makeE(){//
		return new E(){};//�����ڲ���̳���E�࣬���ⲿ��ʵ���˶��ؼ̳�
	}
}

public class MultiImplementation {
	static void takesD(D d){}//����D�༰�����������
	static void takesE(E e){}//����E�༰�����������
	public static void main(String[] args){
		Z z=new Z();
		takesD(z);
		takesE(z.makeE());
	}
}