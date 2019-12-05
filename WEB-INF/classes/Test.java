import DBOracle.OracleController;
import java.util.ArrayList;
import bean.*;
import java.io.*;
public class Test{
	public static void main(String[] args){
		try{
			InputStream x = new FileInputStream("C:\\Users\\SuSu\\Desktop\\ECBook\\img\\book\\test5.png");
		int i= OracleController.insertBookImage(x,"test5.png");
		System.out.println(i);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	}
}