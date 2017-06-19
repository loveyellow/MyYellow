package b;
//192

interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object[] items;
	private int next=0;
	public Sequence(int size){//�̶������С
		items=new Object[size];
	}
	public void add(Object x){//��ĩβ����µ�Object
		if(next<items.length)
			items[next++]=x;
	}
	private class SequenceSelector implements Selector{//�ڲ���ʵ��Selector�ӿڣ����������ģʽ
		private int i=0;
		public boolean end(){//��������Ƿ񵽴�ĩβ
			return i==items.length;
		}
		public Object current(){//���ʵ�ǰ����
			return items[i];
		}
		public void next(){//�ƶ��±굽Ϻһλ
			if(i<items.length)
				i++;
		}
	}
	public Selector selector(){//����һ���ڲ���
		return new SequenceSelector();
	}
	public static void main(String[] args){
		Sequence sequence=new Sequence(10);
		for(int i=0;i<10;i++)
			sequence.add(Integer.toString(i));//��ʼ���ⲿ������е�����
		Selector selector=sequence.selector();//�����ڲ������ָ��ӿڣ��ӿڵ���ʵ���ľ��巽��
		while(!selector.end()){
			System.out.print(selector.current()+" ");//����ⲿ��������Ԫ��
			selector.next();
		}
	}
}
