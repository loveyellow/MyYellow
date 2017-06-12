package b;
//411

import java.util.ArrayList;
import java.util.List;


interface Processor<T,E extends Exception>{
	void process(List<T> resultCollector) throws E;//Processor接口中的process()方法添加相应的列表并抛出相应的异常
}

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>>{
	List<T> processAll()throws E{//调用本对象(ProcessRunner)内部实现processor接口的对象中的方法：process()方法，添加相应的元素到resultCollector列表中
		List<T> resultCollector=new ArrayList<>();
		for(Processor<T,E> processor:this)//逐个调用对象中的process()方法
			processor.process(resultCollector);
		return resultCollector;
	}
}

class Failure1 extends Exception{}

class Processor1 implements Processor<String,Failure1>{//实现processor接口，列表存入String类型，抛出Failure1类型异常
	static int count=3;
	public void process(List<String> resultCollector) throws Failure1{//process()方法用来向List添加String元素并抛出Failure1类型异常
		if(count-->1)
			resultCollector.add("Hep!");
		else
			resultCollector.add("Ho!");
		if(count<0)
			throw new Failure1();
	}
}

class Failure2 extends Exception{}

class Processor2 implements Processor<Integer,Failure2>{//实现processor接口，列表存入Integer类型，抛出Failure2类型异常
	static int count=3;
	public void process(List<Integer> resultCollector) throws Failure2{//process()方法用来向List添加Integer元素并抛出Failure2类型异常
		if(count--==0)
			resultCollector.add(47);
		else
			resultCollector.add(11);
		if(count<0)
			throw new Failure2();
	}
}

public class ThrowGenericException {
	public static void main(String[] args){
		ProcessRunner<String,Failure1> runner=new ProcessRunner<String,Failure1>();//创建ProcessRunner类对象，以ArrayList的形式存入了实现process接口的Processor1对象
		for(int i=0;i<3;i++)
			runner.add(new Processor1());//添加实现了process()接口类processor1的对象
		try{//调用了processAll()方法，该方法可能抛出异常，故要捕获
			System.out.println(runner.processAll());//通过processAll()方法调用每个processor1对象中的process方法来填充runner对象中List列表，并返回
		}catch(Failure1 e){
			System.out.println(e);
		}
		
		ProcessRunner<Integer,Failure2> runner2=new ProcessRunner<Integer,Failure2>();//创建ProcessRunner类对象，以ArrayList的形式存入了实现process接口的Processor2对象
		for(int i=0;i<3;i++)
			runner2.add(new Processor2());//添加实现了process()接口类processor2的对象
		try{
			System.out.println(runner2.processAll());
		}catch(Failure2 e){
			System.out.println(e);
		}
	}
}
