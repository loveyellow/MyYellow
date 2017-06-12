package b;

import javax.print.attribute.standard.PrinterState;

//252

class MyException extends Exception{
	public MyException(){}
	public MyException(String msg){super(msg);}
}

public class FullConstructors {
	public static void f() throws MyException{
		System.out.println("f() Exception");
		throw new MyException();
	}
	public static void g() throws MyException{
		System.out.println("g() Exception");
		throw new MyException("Exception in g()");
	}
	
	public static void main(String[] args){
		try{
			f();
		}
		catch(MyException e){
			e.printStackTrace(System.out);//Throwable是异常类型的跟类，printStackTrace是其方法，打印方法调用处和异常抛出处序列
		}
		try{
			g();
		}
		catch(MyException e){
			e.printStackTrace(System.out);
		}
	}
}
