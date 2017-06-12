package b;


class b{
	b(int marker){
		System.out.println("b"+marker);
	}
	void f1(int marker){
		System.out.println("f1"+marker);
	}
}

class Table{
	static b b1=new b(1);
	Table(){
		System.out.println("Table()");
		b2.f1(1);
	}
	void f2(int marker){
		System.out.println("f2"+marker);
	}
	static b b2=new b(2);
}

class c{
	b b3=new b(3);
	static b b4=new b(4);
	c(){
		System.out.println("c");
		b4.f1(2);
	}
	void f3(int marker){
		System.out.println("f3"+marker);
	}
	static b b5=new b(5);
}

public class StaticInitialization {
	public static void main(String[] args){
		System.out.println("Cra");
		new c();
		System.out.println("Bra");
		new c();
		table.f2(1);
		c.f3(1);
	}
	static Table table=new Table();
	static c c=new c();
}
