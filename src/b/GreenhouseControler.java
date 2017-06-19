package b;
//211页
import java.util.*;

abstract class Event{
	private long eventTime;
	protected final long delayTime;//延迟时间
	public Event(long delayTime){
		this.delayTime=delayTime;
		start();//创建Event对象时，调用start()方法
	}
	public void start(){//获取当前时间，事件每次重新启动以后，都能运行该方法，重新获取当前时间
		eventTime=System.nanoTime()+delayTime;
	}
	public boolean ready(){//判断何时可以运行action()方法，此处是基于时间判断
		return System.nanoTime()>=eventTime;
	}
	public abstract void action();//action()方法在子类中具体时间，不同的事件有不同的操作
}

class Controller{
	private List<Event> eventList=new ArrayList<Event>();//List用于存放各个Event事件类
	public void addEvent(Event c){//向List中添加事件
		eventList.add(c);
	}
	public void run(){//时间执行
		while(eventList.size()>0){//首先判断List容器中是否还有容器
			for(Event e:new ArrayList<Event>(eventList))//依次遍历容器中的所有事件
				if(e.ready()){//基于时间判断事件是否执行
					System.out.println(e);//输出对应的事件（每个事件中都有toString()方法显示该事件信息）
					e.action();//执行对应的事件
					eventList.remove(e);//从List列表中移除该事件
				}
		}
	}
}

class GreenhouseControls extends Controller{
	private boolean light=false;
	public class LightOn extends Event{//开灯,内部类继承了Event事件，创建时调用Event事件初始化
		public LightOn(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//执行开灯操作
			light=true;
		}
		public String toString(){//输出开灯信息
			return "Light is on";
		}
	}
	public class LightOff extends Event{//关灯
		public LightOff(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//执行关灯操作
			light=false;
		}
		public String toString(){//输出关灯信息
			return "Light is Off";
		}
	}
	private boolean water=false;
	public class WaterOn extends Event{//开水龙头
		public WaterOn(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//执行开水头操作
			water=true;
		}
		public String toString(){
			return "Greenhouse water is on";
		}
	}
	public class WaterOff extends Event{//关水龙头
		public WaterOff(long dealyTime){
	    	super(dealyTime);
	    }
		public void action(){//执行关水龙头操作
			water=false;
		}
		public String toString(){
			return "Greenhouse water is off";
		}
	}
	private String thermostat="Day";
	public class ThermostatNight extends Event{//夜晚
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		public void action(){//执行夜晚操作
			thermostat="Night";
		}
		public String toString(){
			return "ThermostatDay on night setting";
		}
	}
	public class ThermostatDay extends Event{//白天
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		public void action(){//执行白天操作
			thermostat="Day";
		}
		public String toString(){
			return "ThermostatDay on day setting";
		}
	}
	public class Bell extends Event{//响铃
		public Bell(long delayTime){
			super(delayTime);
		}
		public void action(){
			addEvent(new Bell(delayTime));
		}
		public String toString(){//执行响铃操作
			return "Bing!";
		}
	}
	public class Restart extends Event{//重新启动系统
		private Event[] eventList;		
		public Restart(long delayTime,Event[] eventList){
			super(delayTime);
			this.eventList=eventList;
			for(Event e:eventList)
				addEvent(e);
		}
		public void action(){//执行重新启动系统操作：将本对象Event数组中对象重新添加到控制框架中
			for(Event e:eventList){
				e.start();//每个事件重新启动，重新获取当前时间
				addEvent(e);//每个事件添加到控制事件中
			}
			this.start();//重新启动系统事件也要重新获取当前时间
			addEvent(this);//重新启动系统事件添加至控制事件中
		}
		public String toString(){
			return "Restarting system";
		}
	}
	public static class Terminate extends Event{//关闭系统
		public Terminate(long delayTime){
			super(delayTime);
		}
		public void action(){//关闭系统操作
			System.exit(0);
		}
		public String toString(){
			return "Terminating";
		}
	}
}


public class GreenhouseControler{
	public static void main(String[] args){
		GreenhouseControls gc=new GreenhouseControls();//创建控制温室的对象
		gc.addEvent(gc.new Bell(900));//首先向框架中添加响铃对象
		Event[] eventList={//一个包含了各种事件的Event数组
				gc.new ThermostatNight(0),//外部类创建了不同的事件，这些内部类事件具有外部类的访问权限
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new WaterOn(600),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400),
		};
		//第一步，重新启动系统的构造函数向框架中添加evenList中所有的事件
		//第二步，添加重新启动系统这个事件到框架中
		gc.addEvent(gc.new Restart(2000,eventList));
		if(args.length==1)//如果main方法中传入的String大小为1则添加关闭系统事件到末尾
			gc.addEvent(
					new GreenhouseControls.Terminate(
						new Integer(args[0])));
		gc.run();//gc对象执行控制框架的run方法，开始执行相应的操作
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

