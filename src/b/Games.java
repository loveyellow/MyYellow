package b;
//201页

interface Game{
	boolean move();
}
interface GameFactory{
	Game getGame();
}

class Checkers implements Game{
	private Checkers(){}//构造器为private，不能直接创建对象
	private int moves=0;
	private static final int MOVES=3;
	public boolean move(){
		System.out.println("Checkers move "+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory=new GameFactory() {//单一的工厂对象
		public Game getGame(){
			return new Checkers();
		}
	};
}

class Chess implements Game{
	private Chess(){}//构造器为private，不能直接创建对象
	private int moves=0;
	private static final int MOVES=4;
	public boolean move(){
		System.out.println("Chess move "+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory=new GameFactory() {//单一的工厂对象
		public Game getGame(){
			return new Chess();
		}
	};
}

public class Games {
	public static void playGame(GameFactory factory){//不同的工厂对象生成不同的具体类的对象
		Game s=factory.getGame();//GameFactory接口调用相应的getGame()方法返回不同的Game对象后向上转型
		while(s.move());//Game接口自动找到相应实现类的move()方法
	}
	public static void main(String[] args){
		playGame(Checkers.factory);//传入Checkers类中的中工厂对象
		playGame(Chess.factory);//闯入Chess类中的工厂对象
	}
}/*Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3*/
