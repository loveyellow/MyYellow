package b;
//261

import java.lang.reflect.Field;


class DynamicFieldsException extends Exception{}//DynamicFieldsException异常

public class DynamicFields {
	private Object[][] fields;
	public DynamicFields(int initialSize){//初始化fields数组，初始化数量main中决定
		fields=new Object[initialSize][2];
		for(int i=0;i<initialSize;i++)
			fields[i]=new Object[]{null,null};
	}
	public String toString(){//转化为字符串，每行输出字符串及相应的值
		StringBuilder result=new StringBuilder();
		for(Object[] obj:fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result .append("\n");
		}
		return result.toString();
	}
	private int hasFiled(String id){//返回与id值相等的字符串编号，没有则返回-1
		for(int i=0;i<fields.length;i++)
			if(id.equals(fields[i][0]))
				return i;
		return -1;
	}
	private int getFiledNumber(String id) throws NoSuchFieldException{//获取与id值相等的编号，没有则抛出异常
		int fieldNum=hasFiled(id);
		if(fieldNum==-1)
			throw new NoSuchFieldException();
		return fieldNum;
	}
	private int makeField(String id){//当原数组还有为空时，写入字符串并返回字符串编号，否则将新值加入新的行添到数组当中
		for(int i=0;i<fields.length;i++)
			if(fields[i][0]==null){
				fields[i][0]=id;
				return i;
			}
		Object[][] tmp=new Object[fields.length+1][2];//当前数组已满，添加新行到数组
		for(int i=0;i<fields.length;i++)
			tmp[i]=fields[i];
		for(int i=fields.length;i<tmp.length;i++)
			tmp[i]=new Object[]{null,null};
		fields=tmp;
		return makeField(id);
	}
	public Object getField(String id)throws NoSuchFieldException{//获取与id字符串相等的value值
		return fields[getFiledNumber(id)][1];
	}
	public Object setField(String id,Object value)throws DynamicFieldsException{//设置field数组字符串以及它的值（仅一行）
		if(value==null){//不允许设置value为空，否则抛出异常
			DynamicFieldsException dfe=new DynamicFieldsException();//新建自定义异常对象
			dfe.initCause(new NullPointerException());//将NullPointerException异常插入继而抛出，使用initCause()方法抛出新的异常时记录异常链
			throw dfe;
		}
		int fieldNumber=hasFiled(id);
		if(fieldNumber==-1)//当数组中不存在id值时，添加新的字符串到数组中
			fieldNumber=makeField(id);
		Object result=null;
		try {
			result=getField(id);//获取当前id字符串中value值，要求必须捕获NoSuchFieldException异常
		} catch (Exception e) {
			throw new RuntimeException();//捕获NoSuchFieldException异常后，抛出新的异常RunTimeException
		}
		fields[fieldNumber][1]=value;
		return result;
	}
	
	public static void main(String[] args){
		DynamicFields df=new DynamicFields(3);
		System.out.println(df.fields.length);
		System.out.println(df);
		try{
			df.setField("d", "A value of d");
			df.setField("number", 47);
			df.setField("number2", 48);
			System.out.println(df);
			df.setField("d", "A new value of d");
			df.setField("number3", 11);//添加新的数组，此时已大于数组大小3，继而添加时会动态自动添加新行到数组中
			System.out.println(df);
			System.out.println(df.getField("d"));//需要捕获NoSuchFieldException异常
			Object field=df.setField("d", null);//设置value为空会在setField()方法中抛出异常
		}catch(NoSuchFieldException e){
			e.printStackTrace(System.out);
		}catch (DynamicFieldsException e) {//捕获使用setField()方法可能会抛出的异常
			e.printStackTrace(System.out);
		}
	}
}
