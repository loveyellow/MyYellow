package b;
//357


public class LinkedStack<T>{
	private static class Node<U>{
		U item;
		Node<U> next;//����һ��next���ڴ洢��һ��ջ����һ��Ԫ��
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
	private Node<T> top=new Node<T>();//ջ��Ϊ�գ�"ĩ���ڱ�"�����ж϶�ջ��ʱΪ��
	public void push(T item){//ѹջ����item�����µ�ջ�У�����һ��ջ���뵽��ǰ�µĶ�ջ�е�next�У�Ȼ��topָ���µ�ջ��
		top=new Node<T>(item,top);
	}
	public T pop(){//��ջ��ȡջ�е�itemԪ��
		T result=top.item;
		if(!top.end())//���δ�Ӵ���"ĩ���ڱ�"�򽫵�ǰջ��ָ����һ����ջ��������ǰջ��ȡ�����Ƴ�
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
