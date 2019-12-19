package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbFavotiteBean;

//ebfavotiteに対するSQL
public class OraFavotiteDao implements FavotiteDao{
   public void addFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL文生成
        String sql= "insert into ebfavotite values(?,?)";

        //stのインスタンス取得
        st=cn.prepareStatement(sql);

        //バインド変数の設定
        st.setString(1,ec.getUser_id());
        st.setString(2,ec.getGenre_name());


        st.executeUpdate();
    }catch(SQLException e){
        //ロールバック処理
        OracleConnect.getInstance().rollback();
    }finally{
        //リソース解放
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
   }
   public EbFavotiteBean getFavotite(String key){
    PreparedStatement st=null;
    Connection cn=null;
    ResultSet rs=null;
    EbFavotiteBean eb=new EbFavotiteBean();

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL文生成
        String sql= "select * from ebcerdit where address_id = ?";

        //stのインスタンス取得
        st=cn.prepareStatement(sql);

        st.setString(1,key);
        
        rs=st.executeQuery();
        while(rs.next()){
            eb.setUser_id(rs.getString("user_id"));
            eb.setGenre_name(rs.getString("book_isbn"));
        }
    }catch(SQLException e){
        //ロールバック処理
        OracleConnect.getInstance().rollback();
    }finally{
        //リソース解放
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    return eb;
   }
   public List getAllFavotite(){
    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs=null;

    ArrayList<EbFavotiteBean> favotitedates=new ArrayList<>();

    try{
        cn=OracleConnect.getInstance().getConnection();

        String sql="select * from ebcresit";
        st=cn.prepareStatement(sql);

        rs=st.executeQuery();

        while(rs.next()){
            EbFavotiteBean eb=new EbFavotiteBean();

            eb.setUser_id(rs.getString("user_id"));
            eb.setGenre_name(rs.getString("book_isbn"));

            favotitedates.add(eb);
        }
    }catch(SQLException e){
        //ロールバック処理
        OracleConnect.getInstance().rollback();
    }finally{
        //リソース解放
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    return favotitedates;
   }
   public void upDateFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL文生成
        String sql="update ebfavotite set user_id=?,book_isbn=? where user_id=?";

        st.setString(1,ec.getUser_id());
        st.setString(2,ec.getGenre_name());
        st.setString(3,ec.getUser_id());

        st.executeUpdate();
    }catch(SQLException e){
        //ロールバック処理
        OracleConnect.getInstance().rollback();
    }finally{
        //リソース解放
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
   }
   public void deleteFavotite(EbFavotiteBean ec){
    PreparedStatement st=null;
    Connection cn=null;

    try{
        cn=OracleConnect.getInstance().getConnection();

        //SQL文生成
        String sql= "delete from ebfavotite where user_id=? ";

        //stのインスタンス取得
        st=cn.prepareStatement(sql);

        st.setString(1,ec.getUser_id());

        st.executeUpdate();
    }catch(SQLException e){
        //ロールバック処理
        OracleConnect.getInstance().rollback();   
            }finally{
        //リソース解放
        try{
            if(st!=null){
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
   }
}