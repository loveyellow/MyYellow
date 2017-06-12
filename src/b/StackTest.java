package b;
//230
import java.util.*;

//class Stack<T>{
//	private LinkedList<T> storage=new LinkedList<T>();
//	public void push(T v){storage.addFirst(v);}
//	public T peek(){return storage.getFirst();}
//	public T pop(){return storage.removeFirst();}
//	public boolean emty(){return storage.isEmpty();}
//	public String toString(){return storage.toString();}
//}

public class StackTest {
	public static void main(String[] args){
//		Stack<String> stack=new Stack<String>();
//		for(String s:"My dog has fleas".split(" "))
//			stack.push(s);
//		while(!stack.emty())
//			System.out.print(stack.pop()+" ");
		java.util.Stack<String> stack2=new java.util.Stack<String>();
		for(String s:"My dog has fleas".split(" "))
			stack2.push(s);
		while(!stack2.empty())
			System.out.print(stack2.pop()+" ");
	}
}
