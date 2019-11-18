import DBOracle.OracleController;
import java.util.ArrayList;
import bean.EBBookBean;
public class Test{
	public static void main(String[] args){
		int i = OracleController.deleteBook("hhhhh");
		System.out.println(i);
	}
}