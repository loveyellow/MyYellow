package b;
//259

public class Rethrowing {
	public static void f() throws Exception{
		System.out.println("Exception from f()");
		throw new Exception("f() Exception");
	}
	public static void g() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;// 重新抛出异常后，原来printStackTrace中的栈轨迹不会被修改，所以在重新抛出的接受点：main中仍然打印的为原异常对象信息
		}
	}
	public static void h() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();//填入新的栈信息到printStackTrace()方法中，原来的异常信息会丢失
		}
	}
	
	public static void main(String[] args){
		try {
			g();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		
		try {
			h();
		} catch (Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
}
