package b;

public class WhoCalled {
	static void f(){
		try {
			throw new Exception();
		} catch (Exception e) {
			for(StackTraceElement ste:e.getStackTrace())//getStackTrace()��������ջ�켣Ԫ�ع��ɵ�����
				System.out.println(ste.getMethodName());//��ӡ������������
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
