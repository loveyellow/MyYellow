package b;
//197

public class Parcel7 {
	class MyContents implements Contents{//MyContents实现了Contents
		private int i=11;
		public int value(){
			return i;
		}
	}
	public Contents contents(){
		return new MyContents(); //contents()方法返回了一个MyContents对象，并且向上转型为Contents
	}
	public static void main(String[] args){
		Parcel7 p=new Parcel7();
		Contents c=p.contents();
	}
}
