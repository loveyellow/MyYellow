package b;
//302

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
	static public final String POEM=
			"Twas brillig, and the slithy toves\n"+
			"I like milk and fruit\n"+
			"You like car and room\n"+
			"I can swim and play football, but you can't.";
	public static void main(String[] args){
		Matcher m=Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);//������ʽ��5�飬ƥ�����ÿ�е������������
		while(m.find()){
			for(int i=0;i<=m.groupCount();i++)//grouCount()�������ص��ǳ�0���������������Ŀ��������4��
				System.out.print("["+m.group(i)+"]");//�ֱ����0��4������ݣ�0��������ƥ�������
			System.out.println();
		}
//		Pattern p=Pattern.compile("^java",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
//		Matcher m=p.matcher(
//				"Java is good \njava"+
//				"Regular ex java eajava Java.");
//		while(m.find()){
//			System.out.println(m.group());
//		}
	}
}
