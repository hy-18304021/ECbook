package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbArrivalBean;

//ebarrivalに対するSQL
public class OraArrivalDao implements ArrivalDao{
    public void addArrival(EbArrivalBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "insert into ebarrival values(?,?,?,?)";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setInt(1,ec.getArrival_id());
            st.setInt(2,ec.getArrival_price());
            st.setString(3,ec.getBook_isbn());
            st.setInt(4,ec.getArrival_amount());

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
    public EbArrivalBean getArrival(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbArrivalBean eb=new EbArrivalBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "select * from ebarrival where arrival_id = ?";
            
            //stのインスタンス取得
            st=cn.prepareStatement(sql);
            
            st.setString(1,key);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setArrival_id(rs.getInt("arrival_id"));
                eb.setArrival_price(rs.getInt("arrival_price"));
                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setArrival_amount(rs.getInt("arrival_amount"));
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
    public List getAllArrival(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbArrivalBean> arrivaldates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebcresit";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbArrivalBean eb=new EbArrivalBean();

                eb.setArrival_id(rs.getInt("arrival_id"));
                eb.setArrival_price(rs.getInt("arrival_price"));
                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setArrival_amount(rs.getInt("arrival_amount"));

                arrivaldates.add(eb);
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
        return arrivaldates;
    }
    public void upDateArrival(EbArrivalBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql="update ebarrival set arrival_id=?,arrival_price=?,book_isbn=?,arrival_amount=? where arrival_id=?";

            st.setInt(1,ec.getArrival_id());
            st.setInt(2,ec.getArrival_price());
            st.setString(3,ec.getBook_isbn());
            st.setInt(4,ec.getArrival_amount());
            st.setInt(5,ec.getArrival_id());

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
    public void deleteArrival(EbArrivalBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "delete from ebarrival where arrival_id=? ";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setInt(1,ec.getArrival_id());

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