package b;
//197ҳ

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
		return new Wrapping(x){//�������ʺϻ��๹�����Ĳ���
			public int value(){
				return super.value()*47;
			}
		};
	}
	public static void main(String[] args){
		Parcel8 p=new Parcel8();
		Wrapping w=p.wrapping(10);
		System.out.println(w.value());//Wrapping����ƥ�䵽����ķ���
	}
}/*Output:
470*/