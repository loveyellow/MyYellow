package b;
//195页


public class Parcel5{
	public Destination destination(String s){
		class PDestination implements Destination{//内部类在方法中
			private String label;
			private PDestination(String whereTo){
				label=whereTo;
			}
			public String readLabel(){
				return label;
			}
		}
		return new PDestination(s);//只有在方法作用域内才可以使用作用域内的内部类
	}
	public static void main(String[] args){
		Parcel5 p=new Parcel5();
		Destination d=p.destination("Tasmania");
	}
}
