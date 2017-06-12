package b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
	public static void main(String[] args){
		if(args.length<2){
			System.out.println("No");
			System.exit(0);
		}
		System.out.println("Input:\""+args[0]+"\"");//��һ��Ϊ��Ҫ�������ַ���
		for(String arg:args){
			System.out.println("Regular expression:\""+arg+"\"");//�ڶ����Ϊ������ʽ
			Pattern p=Pattern.compile(arg);//��Pattern.compile()������������ʽ����Pattern����
			Matcher m=p.matcher(args[0]);//Pattern.matcher()�������������ַ������뵽Matcher������м���
			while(m.find()){
				System.out.println("Match\""+m.group()+"\" at positions "+m.start()+"-"+(m.end()-1));
			}
		}
	}
}
