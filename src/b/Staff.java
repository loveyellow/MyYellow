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
			return "NullPerson"+"\n";//���ΪPerson�ն�����������Ϣ�����ý����ٴ��ж�
		}
	}
	public static final Person NULL=new NullPerson();//�õ���������һ����̬final,������ķ������Ҳ����޸�
}

class Position{
	private String title;
	private Person person;
	public Position(String jobTitle,Person emplyee){
		title=jobTitle;
		person=emplyee;
		if(person==null)//�����������personΪ�գ���������Ϊ�ն���
			person=Person.NULL;
	}
	public Position(String jobTitle){
		title=jobTitle;
		person=Person.NULL;//��person����Ϊ�ն���
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
		if(person==null)//�����������personΪ�գ���������Ϊ�ն���
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
			if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL)//ʹ���˵��������ն������Կ���ʹ��"=="���ж�
				return true;
		return false;
	}
	public void fillPosition(String title,Person hire){//��title��Ӧ�Ĳ���personΪ�ն����position�������µ�person����
		for(Position position:this)
			if(position.getTitle().equals(title)&&position.getPerson()==Person.NULL){
				position.setPerson(hire);
				return;
			}
		throw new RuntimeException("Position "+title+" not available");		
	}
	public static void main(String[] args){
		Staff staff=new Staff("ABC","DEF","GHI","JKL","MNO","MNO","MNO","PQR");//��ʼ����ֻ����title,Person��������Ϊ�ն���
		staff.fillPosition("ABC", new Person("Me", "last", "The Top, Lonely At"));//����Position��Ӧ��title��ԭ�ȵ�Person�ն�������Ϊ������Ϣ���µ�Person
		staff.fillPosition("GHI", new Person("Janet", "Planner", "The Brubs"));
		if(staff.positionAvaiable("MNO"))//�ж�Position�е�ĳ��title��Ӧ��Person�Ƿ���δ�ն���
			staff.fillPosition("MNO" , new Person("Bob", "Coder", "Bright Light City"));
		System.out.println(staff);//���staff�����е�Person����ʹ�����ڵĿն���Ҳ�õ��������ˣ���̬�ģ�����Person�ࣩ
		staff.add("STU", new Person("I", "Love", "you"));//����˺���title,Person��������Position����
		System.out.println(staff);
	}
}
