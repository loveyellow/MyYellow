package b;
//341import org.junit.Test.None;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

interface Null{}

class Person{
	public final String first;
	public final String last;
	public final String address;
	public Person(String first,String last,String address){
		this.first=first;
		this.last=last;
		this.address=address;
	}
	public String toString(){
		return "Person: "+first+" "+last+" "+address+"\n"; 
	}
	public static class NullPerson extends Person implements Null{
		private NullPerson(){
			super("None", "None", "None");
		}
		public String toString(){
			return "NullPerson"+"\n";//如果为Person空对象就输出此信息，不用进行再次判断
		}
	}
	public static final Person NULL=new NullPerson();//用单例创建了一个静态final,属于类的方法并且不能修改
}

class Position{
	private String title;
	private Person person;
	public Position(String jobTitle,Person emplyee){
		title=jobTitle;
		person=emplyee;
		if(person==null)//如果传进来的person为空，则设置其为空对象
			person=Person.NULL;
	}
	public Position(String jobTitle){
		title=jobTitle;
		person=Person.NULL;//将person设置为空对象
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String newTitle){
		title=newTitle;
	}
	public Person getPerson(){
		return person;
	}
	public void setPerson(Person newPerson){
		person=newPerson;
		if(person==null)//如果传进来的person为空，则设置其为空对象
			person=Person.NULL;
	}
	public String toString(){
		return "Position: "+title+" "+person;
	}
}

public class Staff extends ArrayList<Position>{
	public void add(String title,Person person){
		add(new Position(title,person));
	}
	public void add(String... titles){
		for(String title:titles)
			add(new Position(title));
	}
	public Staff(String... titles){
		add(titles);
	}
	public boolean positionAvaiable(String title){
		for(Position position:this)
			if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL)//使用了单例创建空对象，所以可以使用"=="来判断
				return true;
		return false;
	}
	public void fillPosition(String title,Person hire){//在title对应的并且person为空对象的position中填入新的person对象
		for(Position position:this)
			if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL){
				position.setPerson(hire);
				return;
			}
		throw new RuntimeException("Position "+title+" not available");		
	}
	public static void main(String[] args){
		Staff staff=new Staff("ABC","DEF","GHI","JKL","MNO","MNO","MNO","PQR");//开始创建只含有title,Person都被设置为空对象
		staff.fillPosition("ABC", new Person("Me", "last", "The Top, Lonely At"));//根据Position对应的title将原先的Person空对象设置为含有信息的新的Person
		staff.fillPosition("GHI", new Person("Janet", "Planner", "The Brubs"));
		if(staff.positionAvaiable("MNO"))//判断Position中的某个title对应的Person是否仍未空对象
			staff.fillPosition("MNO" , new Person("Bob", "Coder", "Bright Light City"));
		System.out.println(staff);//输出staff中所有的Person，即使不存在的空对象也用单例创建了（静态的，属于Person类）
		staff.add("STU", new Person("I", "Love", "you"));//添加了含有title,Person的完整的Position对象
		System.out.println(staff);
	}
}
