package b;
//273

import java.io.*;

class InputFile{
	private BufferedReader in;
	public InputFile(String fname)throws Exception{//构造函数构造失败抛出异常
		try{
			in=new BufferedReader(new FileReader(fname));//打开文件会有异常可能
		}catch(FileNotFoundException e){//还未打开文件时出现异常
			System.out.println("Coulud not open "+fname);
			throw e;
		}catch (Exception e) {//打开文件后出现异常需要关闭文件
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful"); 
			}
			throw e;
		}finally {
			//这里关闭文件不合理，构造完了还需要使用
		}
	}
	public String getLine(){//获取文件的每一行
		String s;
		try{
			s=in.readLine();//读取文件也可能出现异常
		}catch(IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		return s;
	}
	public void dispose(){//关闭文件
		try{
			in.close();//关闭文件也可能出现异常
			System.out.println("dispose() successful");
		}catch(IOException e){
			throw new RuntimeException("in.close failed");
		}
	}
}

public class CleanUp {
	public static void main(String[] args){
		try{
			InputFile in=new InputFile("F:/java/JSP/JSP程序/b/src/b/CleanUp.java");
			try{
				String s;
				int i=1;
				while((s=in.getLine())!=null);//读取文件出现异常
					//System.out.println(s);
			}catch(Exception e){
				System.out.println("Caught Exception in main");
				e.printStackTrace(System.out);
			}finally{
				in.dispose();//读取后使用文件完毕应该关闭文件
			}
		}catch(Exception e){//构造错误时抛出异常
			System.out.println("InputFile Construction failed");
		}
	}
}
