package exception;

public class FormNullException extends CategoryException{
	public FormNullException(){
		super();
	}
	
	public FormNullException(String message){
		super(message);
	}
	
	public FormNullException(String message,Throwable cause){
		super(message,cause);
	}
}