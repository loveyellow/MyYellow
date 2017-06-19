package b;
//213页

class Egg2{
	private Yolk y=new Yolk();//先与构造器前初始化，调用内部类构造器
	protected class Yolk{
		public Yolk(){//内部类构造函数
			System.out.println("Egg2.Yolk()");
		}
		public void f() {//内部类f()方法
			System.out.println("Egg2.Yolk().f()");
		}
	}
	public Egg2(){//初始化之前，先初始化字段
		System.out.println("New Egg2()");
	}
	public void insertYolk(Yolk yy){//获取一个Yolk类或子类的引用
		y=yy;
	}
	public void g(){
		y.f();//调用y引用指向的类的f()方法
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
		insertYolk(new Yolk());//首先初始化父类BigEgg，然后调用本类中的Yolk类的构造函数，然后调用inserYolk()方法
	}
	public static void main(String[] args){
		Egg2 e2=new BigEgg2();//调用BigEgg2()构造器，向上转型为Egg2类
		e2.g();
	}
}/*Output:
Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk().f()
*/
