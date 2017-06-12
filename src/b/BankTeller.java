package b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

//370

interface Generator<T>{//泛型接口，生成器用来生产对象
	T next();//一般只定义一个方法用来生产对象
}

class Genetators{//用来填充一个Collection
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
		for(int i=0;i<n;i++)
			coll.add(gen.next());//next()方法是生成器用来生成对象的
		return coll;
	}
}

class Customer{
	private static long counter=1;
	private final long id=counter++;//记录当前对象创建数量
	private Customer(){}//私有构造器，所以不能直接创建对象
	public String toString(){
		return "Customer "+id;
	}
	public static Generator<Customer> generator(){
		return new Generator<Customer>() {//创建匿名内部类，必须实现Generator中的next方法
			public Customer next() {//next()方法用来生成对象
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
	public static Generator<Teller> generator=new Generator<Teller>(){//其实不需要多个Generator对象，所以这里仅仅创建一个Generator对象
		public Teller next(){//next()方法用来生成对象
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
		Genetators.fill(line, Customer.generator(), 15);//向line中添加15个Customer对象
		List<Teller> tellers=new ArrayList<Teller>();
		Genetators.fill(tellers, Teller.generator, 4);//向tellers中添加4个Teller对象
		for(Customer c:line)
			serve(tellers.get(rand.nextInt(tellers.size())),c);
	}
}
