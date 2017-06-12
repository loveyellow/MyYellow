package b;
//261

import java.lang.reflect.Field;


class DynamicFieldsException extends Exception{}//DynamicFieldsException�쳣

public class DynamicFields {
	private Object[][] fields;
	public DynamicFields(int initialSize){//��ʼ��fields���飬��ʼ������main�о���
		fields=new Object[initialSize][2];
		for(int i=0;i<initialSize;i++)
			fields[i]=new Object[]{null,null};
	}
	public String toString(){//ת��Ϊ�ַ�����ÿ������ַ�������Ӧ��ֵ
		StringBuilder result=new StringBuilder();
		for(Object[] obj:fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result .append("\n");
		}
		return result.toString();
	}
	private int hasFiled(String id){//������idֵ��ȵ��ַ�����ţ�û���򷵻�-1
		for(int i=0;i<fields.length;i++)
			if(id.equals(fields[i][0]))
				return i;
		return -1;
	}
	private int getFiledNumber(String id) throws NoSuchFieldException{//��ȡ��idֵ��ȵı�ţ�û�����׳��쳣
		int fieldNum=hasFiled(id);
		if(fieldNum==-1)
			throw new NoSuchFieldException();
		return fieldNum;
	}
	private int makeField(String id){//��ԭ���黹��Ϊ��ʱ��д���ַ����������ַ�����ţ�������ֵ�����µ��������鵱��
		for(int i=0;i<fields.length;i++)
			if(fields[i][0]==null){
				fields[i][0]=id;
				return i;
			}
		Object[][] tmp=new Object[fields.length+1][2];//��ǰ����������������е�����
		for(int i=0;i<fields.length;i++)
			tmp[i]=fields[i];
		for(int i=fields.length;i<tmp.length;i++)
			tmp[i]=new Object[]{null,null};
		fields=tmp;
		return makeField(id);
	}
	public Object getField(String id)throws NoSuchFieldException{//��ȡ��id�ַ�����ȵ�valueֵ
		return fields[getFiledNumber(id)][1];
	}
	public Object setField(String id,Object value)throws DynamicFieldsException{//����field�����ַ����Լ�����ֵ����һ�У�
		if(value==null){//����������valueΪ�գ������׳��쳣
			DynamicFieldsException dfe=new DynamicFieldsException();//�½��Զ����쳣����
			dfe.initCause(new NullPointerException());//��NullPointerException�쳣����̶��׳���ʹ��initCause()�����׳��µ��쳣ʱ��¼�쳣��
			throw dfe;
		}
		int fieldNumber=hasFiled(id);
		if(fieldNumber==-1)//�������в�����idֵʱ������µ��ַ�����������
			fieldNumber=makeField(id);
		Object result=null;
		try {
			result=getField(id);//��ȡ��ǰid�ַ�����valueֵ��Ҫ����벶��NoSuchFieldException�쳣
		} catch (Exception e) {
			throw new RuntimeException();//����NoSuchFieldException�쳣���׳��µ��쳣RunTimeException
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
			df.setField("number3", 11);//����µ����飬��ʱ�Ѵ��������С3���̶����ʱ�ᶯ̬�Զ�������е�������
			System.out.println(df);
			System.out.println(df.getField("d"));//��Ҫ����NoSuchFieldException�쳣
			Object field=df.setField("d", null);//����valueΪ�ջ���setField()�������׳��쳣
		}catch(NoSuchFieldException e){
			e.printStackTrace(System.out);
		}catch (DynamicFieldsException e) {//����ʹ��setField()�������ܻ��׳����쳣
			e.printStackTrace(System.out);
		}
	}
}
