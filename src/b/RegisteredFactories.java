package b;
//332

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


interface Factory<T> {//使用泛型工厂，在每种具体实例中返回不同的类型
	T create();
}

class Part{
	public String toString(){
		return getClass().getSimpleName();
	}
	static List<Factory <? extends Part>> partFactioies=new ArrayList<Factory <? extends Part>>();//创建静态List容器，用于存取Factory类型对象，该类型继承自Part
	static{//添加继承自Part类中实现了Factory的静态内部类对象到List中
		partFactioies.add(new FuelFileter.Factory1());
		partFactioies.add(new AirFilter.Factory1());
		partFactioies.add(new CabinAirFilter.Factory1());
		partFactioies.add(new OilFilter.Factory1());
		partFactioies.add(new FanBelt.Factory1());
		partFactioies.add(new PowerSteeringBelt.Factory1());
		partFactioies.add(new GeneratorBelt.Factory1());
	}
	private static Random random=new Random(47);
	public static Part createRadom(){//每次中List中随机选取对象调用相应create方法创建新对象
		int n=random.nextInt(partFactioies.size());
		return partFactioies.get(n).create();
	}
}

class Filter extends Part{}

class FuelFileter extends Filter{
	public static class Factory1 implements Factory<FuelFileter>{
		public FuelFileter create(){
			return new FuelFileter();
		}
	}
}

class AirFilter extends Filter{
	public static class Factory1 implements Factory<AirFilter>{
		public AirFilter create(){
			return new AirFilter();
		}
	}
}


class CabinAirFilter extends Filter{
	public static class Factory1 implements Factory<CabinAirFilter>{
		public CabinAirFilter create(){
			return new CabinAirFilter();
		}
	}
}

class OilFilter extends Filter{
	public static class Factory1 implements Factory<OilFilter>{
		public OilFilter create(){
			return new OilFilter();
		}
	}
}

class Belt extends Part{}

class FanBelt extends Belt{
	public static class Factory1 implements Factory<FanBelt>{
		public FanBelt create(){
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt{
	public static class Factory1 implements Factory<GeneratorBelt>{
		public GeneratorBelt create(){
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt{
	public static class Factory1 implements Factory<PowerSteeringBelt>{
		public PowerSteeringBelt create(){
			return new PowerSteeringBelt();
		}
	}
}

public class RegisteredFactories {
	public static void main(String[] args){
		for(int i=0;i<10;i++)
			System.out.println(Part.createRadom());
	}
}
