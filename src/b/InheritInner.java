package b;
//212ҳ

class WithInner{
	class Inner{
		public Inner(int i) {}//���в����Ĺ��캯��
	}
}

public class InheritInner extends WithInner.Inner{
	//public InheritInner(){} ����ʹ�øù���������Ϊû�л�ȡ�����ⲿ�������
	public InheritInner(WithInner wi) {
		wi.super(1);//���ø��๹����ʱ����Ҫһ�����ϸ��๹�����Ĳ���
	}
	public static void main(String[] args){
		WithInner wi=new WithInner();
		InheritInner i1=new InheritInner(wi);
	}
}
