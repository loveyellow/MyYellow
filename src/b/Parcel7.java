package b;
//197

public class Parcel7 {
	class MyContents implements Contents{//MyContentsʵ����Contents
		private int i=11;
		public int value(){
			return i;
		}
	}
	public Contents contents(){
		return new MyContents(); //contents()����������һ��MyContents���󣬲�������ת��ΪContents
	}
	public static void main(String[] args){
		Parcel7 p=new Parcel7();
		Contents c=p.contents();
	}
}
