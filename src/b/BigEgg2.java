package b;
//213ҳ

class Egg2{
	private Yolk y=new Yolk();//���빹����ǰ��ʼ���������ڲ��๹����
	protected class Yolk{
		public Yolk(){//�ڲ��๹�캯��
			System.out.println("Egg2.Yolk()");
		}
		public void f() {//�ڲ���f()����
			System.out.println("Egg2.Yolk().f()");
		}
	}
	public Egg2(){//��ʼ��֮ǰ���ȳ�ʼ���ֶ�
		System.out.println("New Egg2()");
	}
	public void insertYolk(Yolk yy){//��ȡһ��Yolk������������
		y=yy;
	}
	public void g(){
		y.f();//����y����ָ������f()����
	}
}

public class BigEgg2 extends Egg2{
	public class Yolk extends Egg2.Yolk{
		public Yolk(){
			System.out.println("BigEgg2.Yolk()");
		}
		public void f(){
			System.out.println("BigEgg2.Yolk().f()");
		}
	}
	public BigEgg2(){
		insertYolk(new Yolk());//���ȳ�ʼ������BigEgg��Ȼ����ñ����е�Yolk��Ĺ��캯����Ȼ�����inserYolk()����
	}
	public static void main(String[] args){
		Egg2 e2=new BigEgg2();//����BigEgg2()������������ת��ΪEgg2��
		e2.g();
	}
}/*Output:
Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk().f()
*/
