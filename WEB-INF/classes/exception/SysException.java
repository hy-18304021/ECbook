package exception;

import javax.servlet.ServletException;

public class SysException extends ServletException{
	public SysException(){
		super();
	}
	
	public SysException(String message){
		super(message);
	}
	
	public SysException(String message,Throwable cause){
		super(message,cause);
	}
}