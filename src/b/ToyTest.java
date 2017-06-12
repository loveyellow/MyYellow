package b;
//316

interface HasBatteries{}
interface Wateriproof{}
interface Shoots{}

class Toy{
	Toy(){}
	Toy(int i){}
}

public class ToyTest extends Toy implements HasBatteries,Wateriproof,Shoots{
	static void printInfo(Class cc){
		System.out.println("Class name:"+cc.getName()+" is interface? ["+cc.isInterface()+"]");//getName()��������ȫ�޶�����isInterface()ȷ���Ƿ�Ϊ�ӿ�
		System.out.println("Simple name:"+cc.getSimpleName());//simple()������������������
		System.out.println("Canonical name:"+cc.getCanonicalName());//Canonical()��������ȫ�޶���
	}
	public static void main(String[] args){
		Class c=null;
		try {
			c=Class.forName("b.ToyTest");//������������ʹ��ȫ�޶���(��������)
		} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			System.exit(1);
		};
		printInfo(c);
		for(Class p:c.getInterfaces())//getInterfaces()������ȡ��Ӧ�ӿ�����
			printInfo(p);
		Class up=c.getSuperclass();//getSuperclass()��ȡ����
		Object o=null;
		try {
			o=up.newInstance();//�������ô���ʵ���õ�Object���ã�����ָ��up���õĶ���
		} catch (InstantiationException e) {
			System.out.println("Cannot instactiate");//�޷�ʵ����
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");//�޷�����
			System.exit(1);
		}
		printInfo(o.getClass());
	}
}
