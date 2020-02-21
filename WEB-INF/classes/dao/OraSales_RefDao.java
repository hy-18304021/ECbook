package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbSales_RefBean;

//ebsales_refに対するSQL
public class OraSales_RefDao implements Sales_RefDao{
    public void addSales_Ref(EbSales_RefBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "insert into ebsales_ref values(SALES_ID_SEQ.CURRVAL,?,?)";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setString(1,ec.getBook_isbn());
            st.setInt(2,ec.getSales_amount());

            st.executeUpdate();
        }catch(SQLException e){
            //ロールバック処理
            e.printStackTrace();
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
    public EbSales_RefBean getSales_Ref(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbSales_RefBean eb=new EbSales_RefBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "select * from ebsales_ref where sales_id = ?";
            
            //stのインスタンス取得
            st=cn.prepareStatement(sql);
            
            st.setString(1,key);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setSales_id(rs.getInt("sales_id"));
                eb.setSales_amount(rs.getInt("sales_amount"));
                eb.setBook_isbn(rs.getString("book_isbn"));
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
    public List getAllSales_Ref(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbSales_RefBean> sales_refdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebsales_ref";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbSales_RefBean eb=new EbSales_RefBean();

                eb.setSales_id(rs.getInt("sales_id"));
                eb.setSales_amount(rs.getInt("sales_amount"));
                eb.setBook_isbn(rs.getString("book_isbn"));

                sales_refdates.add(eb);
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
        return sales_refdates;
    }
    public void upDateSales_Ref(EbSales_RefBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql="update ebsales_ref set sales_id=?,sales_amount=?,book_isbn=? where sales_id=?";

            st=cn.prepareStatement(sql);

            st.setInt(1,ec.getSales_id());
            st.setInt(2,ec.getSales_amount());
            st.setString(3,ec.getBook_isbn());
            st.setInt(4,ec.getSales_id());

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
    public void deleteSales_Ref(EbSales_RefBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "delete from ebsales_ref where sales_id=? ";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setInt(1,ec.getSales_id());

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