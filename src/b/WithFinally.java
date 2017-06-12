package b;

class Switch{
	private boolean state=false;
	public boolean read(){return state;}
	public void on(){state=true;System.out.println(this);}
	public void off(){state=false;System.out.println(this);}
	public String toString(){
		return state?"On":"Off";
	}
	public static void f()throws OnOffException1,OnOffException2{
		//throw new OnOffException1();
	}
}

class OnOffException1 extends Exception{}
class OnOffException2 extends Exception{}


public class WithFinally{
	static Switch sw=new Switch();
	public static void main(String[] args){
		try {
			sw.on();
			Switch.f();
		} catch (OnOffException1 e) {
			System.out.println("OnOffException1");
		}catch (OnOffException2 e) {
			System.out.println("OnOffException2");
		}finally {
			sw.off();//无论抛出异常与否，一定会被执行
		}
	}
}
