package b;
//254

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExcepetion {
	private static Logger logger=Logger.getLogger("LoggingException");
	static void logException(Exception e){//���ܸ���������˱�д���쳣
		StringWriter trace=new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	public static void main(String[] args){
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			logException(e);
		}
	}
}
