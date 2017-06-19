package b;


interface Destination{
	String readLabel();
}
interface Contents{
	int value();
}
public class Parcel4 {
	private class PContents implements Contents{
		private int i=11;
		public int value(){
			return i;
		}
	}
	protected class PDestination implements Destination{
		private String label;
		public PDestination(String whereTo) {
			label=whereTo;
		}
		public String readLabel(){
			return label;
		}
	}
	public Destination destination(String s){//通过外部类方法创建内部类对象，并向上转型
		return new PDestination(s);
	}
	public Contents contents(){
		return new PContents();
	}
	public static void main(String[] args){
		Parcel4 p=new Parcel4();
		Destination c=p.destination("Tasmania");//向上转型为Destination接口
		Contents d=p.contents();
		//不能使用下面这种方法，因为PContents内部类为私有的
		//Parcel4.PContents pc=p.new PContents(); 
	}
}
