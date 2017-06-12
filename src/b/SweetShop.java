package b;
//315

class Candy{
	static{System.out.println("Candy");}
}

class Gum{
	static{System.out.println("Gum");}
}

class Cookie{
	static{System.out.println("Cookie");}
	
}

public class SweetShop {
	public static void main(String[] args){
		System.out.println("main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("b.Gum");//Class类的静态成员，获取对象引用，如果类未被加载则第一次加载类，此时static会被执行
			
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		System.out.println("After creating Gum");
		new Cookie();
		System.out.println("After creating Cookie");
	}
}
