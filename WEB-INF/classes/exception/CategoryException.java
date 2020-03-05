package exception;

public class CategoryException extends SysException{
	public CategoryException(){
		super();
	}
	
	public CategoryException(String message){
		super(message);
	}
	
	public CategoryException(String message,Throwable cause){
		super(message,cause);
	}
}