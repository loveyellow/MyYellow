package b;
//319

import java.util.Random;

class Initable{
	static final int staticFinal=47;//编译器常量，不用初始化即可调用
	static final int staticFinal2=ClassInitialization.rand.nextInt(1000);//不是编译器常量，所以调用时必须初始化类
	static{
		System.out.println("Initializing Initable");
	}
}

class Initable2{
	static int staticNonFinal=147;//只是静态，非常量，所以读取之前必须分配空间并初始化，所以加载初始化了类
	static{
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal=74;
	static{
		System.out.println("Initializing Initable3");
	}
}

public class ClassInitialization {
	public static Random rand=new Random(47);
	public static void main(String[] args) throws ClassNotFoundException{
		Class initable=Initable.class;//.class语法不会对类进行初始化，所以未打印出static块中的语句
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		Class initable3=Class.forName("b.Initable3");//加载类并初始化
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
