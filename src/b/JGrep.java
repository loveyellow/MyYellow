package b;
//308

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JGrep {
	public static void main(String[] args){
		Pattern p=Pattern.compile(args[1]);
		int index=0;
		Matcher m=p.matcher("");
		String[] a=new String[]{"public class JGrep","public static void main(String[] args)"};
		for(String line:a){
			m.reset(line);//利用reset方法每次添加一行，避免循环创建对象，有一定的性能优化
			System.out.println(line);
			while(m.find())
				System.out.println(index++ +":"+m.group()+": "+m.start());
		}
	}
}
