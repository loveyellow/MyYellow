package b;
//195ҳ


public class Parcel5{
	public Destination destination(String s){
		class PDestination implements Destination{//�ڲ����ڷ�����
			private String label;
			private PDestination(String whereTo){
				label=whereTo;
			}
			public String readLabel(){
				return label;
			}
		}
		return new PDestination(s);//ֻ���ڷ����������ڲſ���ʹ���������ڵ��ڲ���
	}
	public static void main(String[] args){
		Parcel5 p=new Parcel5();
		Destination d=p.destination("Tasmania");
	}
}
