package b;
//190

public class Parcel2 {
	
	class Contents{
		private int i=11;
		public int value(){
			return i;
		}
	}
	
	class Destination{
		private String label;
		public Destination(String whereTo) {
			label=whereTo;
		}
		String readLabel(){
			return label;
		}
	}
	
	public Contents contents(){//外部类的方法，返回一个内部类对象
		return new Contents();
	}
	
	public void ship(String dest){
		Contents c=new Contents();
		Destination d=new Destination(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args){
		Parcel2 p=new Parcel2();
		p.ship("Tasmania");
		Parcel2 q=new Parcel2();
		Parcel2.Contents c=q.contents();//利用外部类的对象访问外部类方法，返回内部类的对象
	}
}/*Output:
Tasmania*/
