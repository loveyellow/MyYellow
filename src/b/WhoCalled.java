package b;

public class WhoCalled {
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			for(StackTraceElement ste:e.getStackTrace())//getStackTrace()方法返回栈轨迹元素构成的数组
				System.out.println(ste.getMethodName());//打印方法调用序列
		}
	}
	static void g(){f();}
	static void h(){g();}
	
	public static void main(String[] args){
		f();
		System.out.println("----------------------------");
		g();
		System.out.println("----------------------------");
		h();
	}
}
