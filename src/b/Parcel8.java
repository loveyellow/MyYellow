package b;
//197页

class Wrapping{
	private int i;
	public Wrapping(int x){
		i=x;
	}
	public int value(){
		return i;
	}
}

public class Parcel8 {
	public Wrapping wrapping(int x){
		return new Wrapping(x){//传递了适合基类构造器的参数
			public int value(){
				return super.value()*47;
			}
		};
	}
	public static void main(String[] args){
		Parcel8 p=new Parcel8();
		Wrapping w=p.wrapping(10);
		System.out.println(w.value());//Wrapping引用匹配到子类的方法
	}
}/*Output:
470*/