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
		Matcher m=Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);//正则表达式共5组，匹配的是每行的最后三个单词
		while(m.find()){
			for(int i=0;i<=m.groupCount();i++)//grouCount()方法返回的是除0组外的其他分组数目，这里是4组
				System.out.print("["+m.group(i)+"]");//分别输出0到4组的内容，0组是整个匹配的内容
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
