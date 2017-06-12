package b;
//303

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PUBLIC_MEMBER;

public class StartEnd {
	public static String input=
			"As long as there is injustice, whenever a\n"+
			"Targathian baby cries out, wherever a distress\n"+
			"signal sounds among the starts ... We'll be there.\n"+
			"This fine ship, and this fine crew ...\n"+
			"Never give up! Never surrender!";
	private static class Display{
		private boolean regexPrinted=false;
		private String regex;
		public Display(String regex) {
			this.regex=regex;
		}
		void Display(String Messege){
			if(!regexPrinted){
				System.out.println(regex);//ͬһ��������ʽֻ���һ��
				regexPrinted=true;
			}
			System.out.println(Messege);//�����ǰƥ����ַ���
		}
	}
	static void examine(String s,String regex){
		Display d=new Display(regex);//ÿ�ν������µĶ���
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(s);
		while(m.find())//�������ַ���������λ�ö����ַ���
			d.Display("find() '"+m.group()+"' start="+m.start()+" end="+m.end());
		if(m.lookingAt())//ֻ����������ʽ��������ʼ���Ϳ�ʼƥ��ʱ�Ż�ɹ�����һ����ƥ�伴Ϊ�ɹ�
			d.Display("lookingAt() start="+m.start()+" end="+m.end());
		if(m.matches())//ֻ����������ʽ��������ʼ���Ϳ�ʼƥ��ʱ�Ż�ɹ���ȫ������ƥ��Ż�ɹ�
			d.Display("matches() start="+m.start()+" end="+m.end());
	}
	public static void main(String[] args){
		for(String in:input.split("\n")){
			System.out.println("input:"+in);
			for(String regex:new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"})//ereǰ����0���������ַ���ere��Ҳ����0�������ַ�
				examine(in, regex);
		}
	}
}
