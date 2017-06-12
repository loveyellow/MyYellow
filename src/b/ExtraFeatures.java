package b;

class MyException2 extends Exception{
	private int x;
	public MyException2(){}
	public MyException2(String msg){super(msg);}
	public MyException2(String msg,int x){//自定义异常可以加入额外构造器和和成员
		super(msg);
		this.x=x;
	}
	public int val(){
		return x;
	}
	public String getMessage(){
		return "Detail Message: "+x+" "+super.getMessage();
	}
}

public class ExtraFeatures {
	public static void f() throws MyException2{
		System.out.println("f() Exception");
		throw new MyException2();
	}
	public static void g() throws MyException2{
		System.out.println("g() Exception");
		throw new MyException2("Exception in g()");
	}
	public static void h() throws MyException2{
		System.out.println("h() Exception");
		throw new MyException2("Exception in h()",47);
	}
	
	public static void main(String[] args){
		try{
			f();
		}
		catch(MyException2 e){
			e.printStackTrace(System.out);//Throwable是异常类型的根类，printStackTrace是其方法，打印方法调用处和异常抛出处序列
		}
		try{
			g();
		}
		catch(MyException2 e){
			e.printStackTrace(System.out);
		}
		try{
			h();
		}
		catch(MyException2 e){
			e.printStackTrace(System.out);
			System.out.println("e.val()="+e.val());
		}
	}
}
