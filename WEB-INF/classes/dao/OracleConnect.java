package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnect{
    private static OracleConnect oracn=null;
    private Connection cn=null;

    private OracleConnect(){}

    //シングルトンパターン
    public static OracleConnect getInstance(){
        if(oracn==null){
            oracn=new OracleConnect();
        }
        return oracn;
    }
    //Connectionを返す
    public Connection getConnection(){
        if(cn==null){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ebtest","ebpass");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return cn;
    }

    //getConnection()を呼ぶ
    public void beginTransaction(){
        if(cn==null){
            getConnection();
        }
        try{
            cn.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Connectionを閉じる
    public void closeConnection(){
        try{
            if(cn!=null){  
                cn.close();
                // cn=null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //コミットする
    public void commit(){
        try{
            cn.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //ロールバックする
    public void rollback(){
        try{
            cn.rollback();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}