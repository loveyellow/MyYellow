package b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

//370

interface Generator<T>{//���ͽӿڣ�������������������
	T next();//һ��ֻ����һ������������������
}

class Genetators{//�������һ��Collection
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++)
			coll.add(gen.next());//next()�������������������ɶ����
		return coll;
	}
}

class Customer{
	private static long counter=1;
	private final long id=counter++;//��¼��ǰ���󴴽�����
	private Customer(){}//˽�й����������Բ���ֱ�Ӵ�������
	public String toString(){
		return "Customer "+id;
	}
	public static Generator<Customer> generator(){
		return new Generator<Customer>() {//���������ڲ��࣬����ʵ��Generator�е�next����
			public Customer next() {//next()�����������ɶ���
				return new Customer();
			}
		};
	}
}

class Teller{
	private static long counter=1;
	private final long id=counter++;
	private Teller(){}
	public String toString(){
		return "Teller "+id;
	}
	public static Generator<Teller> generator=new Generator<Teller>(){//��ʵ����Ҫ���Generator�������������������һ��Generator����
		public Teller next(){//next()�����������ɶ���
			return new Teller();
		}
	};
}

public class BankTeller {
	public static void serve(Teller t,Customer c){
		System.out.println(t+" serves "+c);
	}
	public static void main(String[] args){
		Random rand=new Random(47);
		Queue<Customer> line=new LinkedList<Customer>();
		Genetators.fill(line, Customer.generator(), 15);//��line�����15��Customer����
		List<Teller> tellers=new ArrayList<Teller>();
		Genetators.fill(tellers, Teller.generator, 4);//��tellers�����4��Teller����
		for(Customer c:line)
			serve(tellers.get(rand.nextInt(tellers.size())),c);
	}
}
