package b;
//202ҳ


public class Parcel11 {
	public static class ParcelContents implements Contents{
		private static int i=11;
		public int value(){
			return i;
		}
	}
	public static ParcelContents contents(){
		return new ParcelContents();
	}
	public static void main(String[] args){
		Contents c=contents();
	}
}
