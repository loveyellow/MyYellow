package b;
//201ҳ

interface Game{
	boolean move();
}
interface GameFactory{
	Game getGame();
}

class Checkers implements Game{
	private Checkers(){}//������Ϊprivate������ֱ�Ӵ�������
	private int moves=0;
	private static final int MOVES=3;
	public boolean move(){
		System.out.println("Checkers move "+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory=new GameFactory() {//��һ�Ĺ�������
		public Game getGame(){
			return new Checkers();
		}
	};
}

class Chess implements Game{
	private Chess(){}//������Ϊprivate������ֱ�Ӵ�������
	private int moves=0;
	private static final int MOVES=4;
	public boolean move(){
		System.out.println("Chess move "+moves);
		return ++moves!=MOVES;
	}
	public static GameFactory factory=new GameFactory() {//��һ�Ĺ�������
		public Game getGame(){
			return new Chess();
		}
	};
}

public class Games {
	public static void playGame(GameFactory factory){//��ͬ�Ĺ����������ɲ�ͬ�ľ�����Ķ���
		Game s=factory.getGame();//GameFactory�ӿڵ�����Ӧ��getGame()�������ز�ͬ��Game���������ת��
		while(s.move());//Game�ӿ��Զ��ҵ���Ӧʵ�����move()����
	}
	public static void main(String[] args){
		playGame(Checkers.factory);//����Checkers���е��й�������
		playGame(Chess.factory);//����Chess���еĹ�������
	}
}/*Output:
Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3*/
