package DBOracle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import bean.UserInfoBean;
public class UserInformation{
    public static List<UserInfoBean> getResList(String dbid,String pass){
		
        List<UserInfoBean> resList = new ArrayList<UserInfoBean>();
        
        Connection cn=OracleController.connect(dbid,pass);
		
		try{
			
			//select文
			String sql="select * from ebuser";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				UserInfoBean res = new UserInfoBean();
                
                //ここから取得
				String id = rs.getString(1);	
				String pas = rs.getString(2);	
				String mail = rs.getString(3);	
				int sex = rs.getInt(4);	
				int birth = rs.getInt(5);	
				res.setId(id);
				res.setPass(pas);
				res.setMail(mail);
				res.setSex(sex);
				res.setBirth(birth);

				resList.add(res);
				
			}

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
}