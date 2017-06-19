package b;
//199

public class Parcel10 {
	public Destination destination(String dest,float price){
		return new Destination() {
			private int cost;
			{//带有实例初始化
				cost=Math.round(price);
				if(cost>100)
					System.out.println("Over budget!");
			}
			//下面这句话不能通过翻译！
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
