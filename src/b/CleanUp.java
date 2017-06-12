package b;
//273

import java.io.*;

class InputFile{
	private BufferedReader in;
	public InputFile(String fname)throws Exception{//���캯������ʧ���׳��쳣
		try{
			in=new BufferedReader(new FileReader(fname));//���ļ������쳣����
		}catch(FileNotFoundException e){//��δ���ļ�ʱ�����쳣
			System.out.println("Coulud not open "+fname);
			throw e;
		}catch (Exception e) {//���ļ�������쳣��Ҫ�ر��ļ�
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful"); 
			}
			throw e;
		}finally {
			//����ر��ļ��������������˻���Ҫʹ��
		}
	}
	public String getLine(){//��ȡ�ļ���ÿһ��
		String s;
		try{
			s=in.readLine();//��ȡ�ļ�Ҳ���ܳ����쳣
		}catch(IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		return s;
	}
	public void dispose(){//�ر��ļ�
		try{
			in.close();//�ر��ļ�Ҳ���ܳ����쳣
			System.out.println("dispose() successful");
		}catch(IOException e){
			throw new RuntimeException("in.close failed");
		}
	}
}

public class CleanUp {
	public static void main(String[] args){
		try{
			InputFile in=new InputFile("F:/java/JSP/JSP����/b/src/b/CleanUp.java");
			try{
				String s;
				int i=1;
				while((s=in.getLine())!=null);//��ȡ�ļ������쳣
					//System.out.println(s);
			}catch(Exception e){
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();//��ȡ��ʹ���ļ����Ӧ�ùر��ļ�
			}
		}catch(Exception e){//�������ʱ�׳��쳣
			System.out.println("InputFile Construction failed");
		}
	}
}
