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
			throw e;// �����׳��쳣��ԭ��printStackTrace�е�ջ�켣���ᱻ�޸ģ������������׳��Ľ��ܵ㣺main����Ȼ��ӡ��Ϊԭ�쳣������Ϣ
		}
	}
	public static void h() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside h(),e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();//�����µ�ջ��Ϣ��printStackTrace()�����У�ԭ�����쳣��Ϣ�ᶪʧ
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
