package b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
	public static void main(String[] args){
		if(args.length<2){
			System.out.println("No");
			System.exit(0);
		}
		System.out.println("Input:\""+args[0]+"\"");//第一项为需要检索的字符串
		for(String arg:args){
			System.out.println("Regular expression:\""+arg+"\"");//第二项后为正则表达式
			Pattern p=Pattern.compile(arg);//用Pattern.compile()方法将正则表达式生成Pattern对象
			Matcher m=p.matcher(args[0]);//Pattern.matcher()方法将检索的字符串传入到Matcher对象进行检索
			while(m.find()){
				System.out.println("Match\""+m.group()+"\" at positions "+m.start()+"-"+(m.end()-1));
			}
		}
	}
}
