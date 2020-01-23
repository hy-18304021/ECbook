package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbCreditBean;

//ebcreditに対するSQL
public class OraCreditDao implements CreditDao{
    public void addCredit(EbCreditBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "insert into ebcredit values(?,?,?,?,?)";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setString(1,ec.getUser_id());
            st.setString(2,ec.getCard_name());
            st.setString(3,ec.getCard_number());
            st.setString(4,ec.getSecurity_number());
            st.setString(5,ec.getCard_expiration());


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
    public EbCreditBean getCredit(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbCreditBean eb=new EbCreditBean();

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
                eb.setCard_name(rs.getString("card_name"));
                eb.setCard_number(rs.getString("card_number"));
                eb.setSecurity_number(rs.getString("security_number"));
                eb.setCard_expiration(rs.getString("card_expiration"));
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
    public List getAllCredit(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbCreditBean> creditdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebcresit";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbCreditBean eb=new EbCreditBean();

                eb.setUser_id(rs.getString("user_id"));
                eb.setCard_name(rs.getString("card_name"));
                eb.setCard_number(rs.getString("card_number"));
                eb.setSecurity_number(rs.getString("security_number"));
                eb.setCard_expiration(rs.getString("card_expiration"));

                creditdates.add(eb);
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
        return creditdates;
    }
    public void upDateCredit(EbCreditBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql="update ebcredit set user_id=?,card_name=?,card_number=?,security_number=?,card_expiration=? where card_number=?";

            st=cn.prepareStatement(sql);

            st.setString(1,ec.getUser_id());
            st.setString(2,ec.getCard_name());
            st.setString(3,ec.getCard_number());
            st.setString(4,ec.getSecurity_number());
            st.setString(5,ec.getCard_expiration());
            st.setString(6,ec.getCard_number());

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
    public void deleteCredit(EbCreditBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL文生成
            String sql= "delete from ebcredit where card_number=? ";

            //stのインスタンス取得
            st=cn.prepareStatement(sql);

            st.setString(1,ec.getCard_number());

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