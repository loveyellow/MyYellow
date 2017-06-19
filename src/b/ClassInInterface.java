package b;
//202ҳ

public interface  ClassInInterface {
	void howdy();
	static class Test implements ClassInInterface{
		public void howdy(){
			System.out.println("Howdy");
		}
	}
	public static void main(String[] args){
		new Test().howdy();
	}
}/*Output:
Howdy
*/