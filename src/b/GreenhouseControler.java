package b;
//211ҳ
import java.util.*;

abstract class Event{
	private long eventTime;
	protected final long delayTime;//�ӳ�ʱ��
	public Event(long delayTime){
		this.delayTime=delayTime;
		start();//����Event����ʱ������start()����
	}
	public void start(){//��ȡ��ǰʱ�䣬�¼�ÿ�����������Ժ󣬶������и÷��������»�ȡ��ǰʱ��
		eventTime=System.nanoTime()+delayTime;
	}
	public boolean ready(){//�жϺ�ʱ��������action()�������˴��ǻ���ʱ���ж�
		return System.nanoTime()>=eventTime;
	}
	public abstract void action();//action()�����������о���ʱ�䣬��ͬ���¼��в�ͬ�Ĳ���
}

class Controller{
	private List<Event> eventList=new ArrayList<Event>();//List���ڴ�Ÿ���Event�¼���
	public void addEvent(Event c){//��List������¼�
		eventList.add(c);
	}
	public void run(){//ʱ��ִ��
		while(eventList.size()>0){//�����ж�List�������Ƿ�������
			for(Event e:new ArrayList<Event>(eventList))//���α��������е������¼�
				if(e.ready()){//����ʱ���ж��¼��Ƿ�ִ��
					System.out.println(e);//�����Ӧ���¼���ÿ���¼��ж���toString()������ʾ���¼���Ϣ��
					e.action();//ִ�ж�Ӧ���¼�
					eventList.remove(e);//��List�б����Ƴ����¼�
				}
		}
	}
}

class GreenhouseControls extends Controller{
	private boolean light=false;
	public class LightOn extends Event{//����,�ڲ���̳���Event�¼�������ʱ����Event�¼���ʼ��
		public LightOn(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//ִ�п��Ʋ���
			light=true;
		}
		public String toString(){//���������Ϣ
			return "Light is on";
		}
	}
	public class LightOff extends Event{//�ص�
		public LightOff(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//ִ�йصƲ���
			light=false;
		}
		public String toString(){//����ص���Ϣ
			return "Light is Off";
		}
	}
	private boolean water=false;
	public class WaterOn extends Event{//��ˮ��ͷ
		public WaterOn(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//ִ�п�ˮͷ����
			water=true;
		}
		public String toString(){
			return "Greenhouse water is on";
		}
	}
	public class WaterOff extends Event{//��ˮ��ͷ
		public WaterOff(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//ִ�й�ˮ��ͷ����
			water=false;
		}
		public String toString(){
			return "Greenhouse water is off";
		}
	}
	private String thermostat="Day";
	public class ThermostatNight extends Event{//ҹ��
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		public void action(){//ִ��ҹ�����
			thermostat="Night";
		}
		public String toString(){
			return "ThermostatDay on night setting";
		}
	}
	public class ThermostatDay extends Event{//����
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		public void action(){//ִ�а������
			thermostat="Day";
		}
		public String toString(){
			return "ThermostatDay on day setting";
		}
	}
	public class Bell extends Event{//����
		public Bell(long delayTime){
			super(delayTime);
		}
		public void action(){
			addEvent(new Bell(delayTime));
		}
		public String toString(){//ִ���������
			return "Bing!";
		}
	}
	public class Restart extends Event{//��������ϵͳ
		private Event[] eventList;		
		public Restart(long delayTime,Event[] eventList){
			super(delayTime);
			this.eventList=eventList;
			for(Event e:eventList)
				addEvent(e);
		}
		public void action(){//ִ����������ϵͳ��������������Event�����ж���������ӵ����ƿ����
			for(Event e:eventList){
				e.start();//ÿ���¼��������������»�ȡ��ǰʱ��
				addEvent(e);//ÿ���¼���ӵ������¼���
			}
			this.start();//��������ϵͳ�¼�ҲҪ���»�ȡ��ǰʱ��
			addEvent(this);//��������ϵͳ�¼�����������¼���
		}
		public String toString(){
			return "Restarting system";
		}
	}
	public static class Terminate extends Event{//�ر�ϵͳ
		public Terminate(long delayTime){
			super(delayTime);
		}
		public void action(){//�ر�ϵͳ����
			System.exit(0);
		}
		public String toString(){
			return "Terminating";
		}
	}
}


public class GreenhouseControler{
	public static void main(String[] args){
		GreenhouseControls gc=new GreenhouseControls();//�����������ҵĶ���
		gc.addEvent(gc.new Bell(900));//��������������������
		Event[] eventList={//һ�������˸����¼���Event����
				gc.new ThermostatNight(0),//�ⲿ�ഴ���˲�ͬ���¼�����Щ�ڲ����¼������ⲿ��ķ���Ȩ��
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400),
		};
		//��һ������������ϵͳ�Ĺ��캯�����������evenList�����е��¼�
		//�ڶ����������������ϵͳ����¼��������
		gc.addEvent(gc.new Restart(2000,eventList));
		if(args.length==1)//���main�����д����String��СΪ1����ӹر�ϵͳ�¼���ĩβ
			gc.addEvent(
					new GreenhouseControls.Terminate(
						new Integer(args[0])));
		gc.run();//gc����ִ�п��ƿ�ܵ�run��������ʼִ����Ӧ�Ĳ���
	}
}/*Bing!
ThermostatDay on night setting
Light is on
Light is Off
Greenhouse water is on
Greenhouse water is off
ThermostatDay on day setting
Restarting system
Terminating
*/

