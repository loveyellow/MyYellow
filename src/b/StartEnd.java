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
				System.out.println(regex);//同一个正则表达式只输出一次
				regexPrinted=true;
			}
			System.out.println(Messege);//输出当前匹配的字符串
		}
	}
	static void examine(String s,String regex){
		Display d=new Display(regex);//每次建立了新的对象
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(s);
		while(m.find())//可以在字符串的任意位置定义字符串
			d.Display("find() '"+m.group()+"' start="+m.start()+" end="+m.end());
		if(m.lookingAt())//只有在正则表达式与输入的最开始处就开始匹配时才会成功，第一部分匹配即为成功
			d.Display("lookingAt() start="+m.start()+" end="+m.end());
		if(m.matches())//只有在正则表达式与输入的最开始处就开始匹配时才会成功，全部输入匹配才会成功
			d.Display("matches() start="+m.start()+" end="+m.end());
	}
	public static void main(String[] args){
		for(String in:input.split("\n")){
			System.out.println("input:"+in);
			for(String regex:new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"})//ere前任意0个或多个词字符，ere后也任意0个或多个字符
				examine(in, regex);
		}
	}
}
