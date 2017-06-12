package b;
//357


public class LinkedStack<T>{
	private static class Node<U>{
		U item;
		Node<U> next;//存有一个next用于存储下一个栈顶下一个元素
		Node(){
			item=null;
			next=null;
		}
		Node(U item,Node<U> next){
			this.item=item;
			this.next=next;
		}
		boolean end(){
			return item==null&&next==null;
		}
	}
	private Node<T> top=new Node<T>();//栈底为空，"末端哨兵"用来判断堆栈何时为空
	public void push(T item){//压栈：将item存入新的栈中，将上一个栈存入到当前新的堆栈中的next中，然后将top指向新的栈顶
		top=new Node<T>(item,top);
	}
	public T pop(){//出栈获取栈中的item元素
		T result=top.item;
		if(!top.end())//如果未接触到"末端哨兵"则将当前栈顶指向上一个堆栈，即将当前栈顶取出并移除
			top=top.next;
		return result;
	}
	public static void main(String[] args){
		LinkedStack<String> lss=new LinkedStack<String>();
		for(String e:"I love you forever!".split(" "))
			lss.push(e);
		String s=null;
		while((s=lss.pop())!=null)
			System.out.println(s);
	}
}
