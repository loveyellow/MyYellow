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
	public Destination destination(String s){//ͨ���ⲿ�෽�������ڲ�����󣬲�����ת��
		return new PDestination(s);
	}
	public Contents contents(){
		return new PContents();
	}
	public static void main(String[] args){
		Parcel4 p=new Parcel4();
		Destination c=p.destination("Tasmania");//����ת��ΪDestination�ӿ�
		Contents d=p.contents();
		//����ʹ���������ַ�������ΪPContents�ڲ���Ϊ˽�е�
		//Parcel4.PContents pc=p.new PContents(); 
	}
}
