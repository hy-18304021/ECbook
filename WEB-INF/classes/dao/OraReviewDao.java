package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbReviewBean;

//ebreviewに対するSQL
public class OraReviewDao implements ReviewDao{
    Connection cn=null;
    PreparedStatement st=null;
    ResultSet rs = null;
    public void addReview(EbReviewBean ec){
        String sql= "insert into ebreview values(?,?,?,?,sysdate)";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);

            //バインド変数の設定
            st.setString(1,ec.getBook_isbn());
            st.setString(2,ec.getUser_id());
            st.setString(3,ec.getReview_text());
            st.setInt(4,ec.getReview_star());

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
    // public EbReviewBean getReview(String key){
    //     return null;
    // }
    public List getBookReview(String book_isbn){
        String sql="select * from ebreview where book_isbn = ? order by review_date";

        ArrayList bookreviewdata=new ArrayList();

        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);
            st.setString(1,book_isbn);

            rs=st.executeQuery();
            while(rs.next()){
                EbReviewBean eb=new EbReviewBean();

                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setReview_text(rs.getString("review_text"));
                eb.setReview_star(rs.getInt("review_star"));
                eb.setReview_date(rs.getString("review_date"));

                bookreviewdata.add(eb);
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
                if(rs!=null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return bookreviewdata;
    }
    public void updateReview(EbReviewBean ec){
        String sql="update ebreview set book_isbn=?,review_text=?,review_star=? where user_id=? AND review_date=?";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }
            st=cn.prepareStatement(sql);
            st.setString(1,ec.getBook_isbn());
            st.setString(2,ec.getReview_text());
            st.setInt(3,ec.getReview_star());
            st.setString(4,ec.getUser_id());
            st.setString(5,ec.getReview_date());

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
    public void deleteReview(EbReviewBean ec){
         String sql= "delete from ebreview where user_id=? AND book_isbn=? AND review_text=? AND review_star=?";
        try{
            if(cn==null){
                cn=OracleConnect.getInstance().getConnection();
            }

            st=cn.prepareStatement(sql);

            st.setString(1,ec.getUser_id());
            st.setString(2,ec.getBook_isbn());
            st.setString(3,ec.getReview_text());
            st.setInt(4,ec.getReview_star());


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