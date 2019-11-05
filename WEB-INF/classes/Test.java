import DBOracle.OracleController;
public class Test{
	public static void main(String args[]){
		OracleController.regist("sida","pro");

		int i = OracleController.userCheck("sida","password");
		String result = "";
		if(i == 0 ){
			result = "Wrong pass";
		}else if( i == -1){
			result = "This ID is not exist.";
		}else {
			result = "Login Completed!";
		}
		System.out.println(result);
	}
}