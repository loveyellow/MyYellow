package b;
//411

import java.util.ArrayList;
import java.util.List;


interface Processor<T,E extends Exception>{
	void process(List<T> resultCollector) throws E;//Processor�ӿ��е�process()���������Ӧ���б��׳���Ӧ���쳣
}

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>>{
	List<T> processAll()throws E{//���ñ�����(ProcessRunner)�ڲ�ʵ��processor�ӿڵĶ����еķ�����process()�����������Ӧ��Ԫ�ص�resultCollector�б���
		List<T> resultCollector=new ArrayList<>();
		for(Processor<T,E> processor:this)//������ö����е�process()����
			processor.process(resultCollector);
		return resultCollector;
	}
}

class Failure1 extends Exception{}

class Processor1 implements Processor<String,Failure1>{//ʵ��processor�ӿڣ��б����String���ͣ��׳�Failure1�����쳣
	static int count=3;
	public void process(List<String> resultCollector) throws Failure1{//process()����������List���StringԪ�ز��׳�Failure1�����쳣
		if(count-->1)
			resultCollector.add("Hep!");
		else
			resultCollector.add("Ho!");
		if(count<0)
			throw new Failure1();
	}
}

class Failure2 extends Exception{}

class Processor2 implements Processor<Integer,Failure2>{//ʵ��processor�ӿڣ��б����Integer���ͣ��׳�Failure2�����쳣
	static int count=3;
	public void process(List<Integer> resultCollector) throws Failure2{//process()����������List���IntegerԪ�ز��׳�Failure2�����쳣
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
		ProcessRunner<String,Failure1> runner=new ProcessRunner<String,Failure1>();//����ProcessRunner�������ArrayList����ʽ������ʵ��process�ӿڵ�Processor1����
		for(int i=0;i<3;i++)
			runner.add(new Processor1());//���ʵ����process()�ӿ���processor1�Ķ���
		try{//������processAll()�������÷��������׳��쳣����Ҫ����
			System.out.println(runner.processAll());//ͨ��processAll()��������ÿ��processor1�����е�process���������runner������List�б�������
		}catch(Failure1 e){
			System.out.println(e);
		}
		
		ProcessRunner<Integer,Failure2> runner2=new ProcessRunner<Integer,Failure2>();//����ProcessRunner�������ArrayList����ʽ������ʵ��process�ӿڵ�Processor2����
		for(int i=0;i<3;i++)
			runner2.add(new Processor2());//���ʵ����process()�ӿ���processor2�Ķ���
		try{
			System.out.println(runner2.processAll());
		}catch(Failure2 e){
			System.out.println(e);
		}
	}
}
