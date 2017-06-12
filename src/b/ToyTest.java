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
		System.out.println("Class name:"+cc.getName()+" is interface? ["+cc.isInterface()+"]");//getName()方法产生全限定名，isInterface()确定是否为接口
		System.out.println("Simple name:"+cc.getSimpleName());//simple()产生不含包名的类名
		System.out.println("Canonical name:"+cc.getCanonicalName());//Canonical()方法产生全限定名
	}
	public static void main(String[] args){
		Class c=null;
		try {
			c=Class.forName("b.ToyTest");//方法参数必须使用全限定名(包含包名)
		} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			System.exit(1);
		};
		printInfo(c);
		for(Class p:c.getInterfaces())//getInterfaces()方法获取相应接口引用
			printInfo(p);
		Class up=c.getSuperclass();//getSuperclass()获取父类
		Object o=null;
		try {
			o=up.newInstance();//利用引用创建实例得到Object引用，但是指向up引用的对象
		} catch (InstantiationException e) {
			System.out.println("Cannot instactiate");//无法实例化
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");//无法访问
			System.exit(1);
		}
		printInfo(o.getClass());
	}
}
