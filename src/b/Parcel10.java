package b;
//199

public class Parcel10 {
	public Destination destination(String dest,float price){
		return new Destination() {
			private int cost;
			{//����ʵ����ʼ��
				cost=Math.round(price);
				if(cost>100)
					System.out.println("Over budget!");
			}
			//������仰����ͨ�����룡
			//dest="newTasmania";
			private String label=dest;
			public String readLabel(){
				return label;
			}
		};
	}
	public static void main(String[] args){
		Parcel10 p=new Parcel10();
		Destination d=p.destination("Tasmania", 101.395F);
	}
}/*Output:
Over budget!*/
