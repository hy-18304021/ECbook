package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbReviewBean;

//ebreview�ɑ΂���SQL
public class OraReviewDao implements ReviewDao{
    public void addReview(EbReviewBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "insert into ebreview values(?,?,?,?,?)";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
            st.setString(1,ec.getBook_isbn());
            st.setString(2,ec.getUser_id());
            st.setString(3,ec.getReview_text());
            st.setInt(4,ec.getReview_star());
            st.setInt(5,ec.getReview_date());


            st.executeUpdate();
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public EbReviewBean getReview(String key){
        return null;
    }
    public List getAllReview(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbReviewBean> reviewdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebcresit";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbReviewBean eb=new EbReviewBean();

                eb.setBook_isbn(rs.getString("book_isbn"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setReview_text(rs.getString("review_text"));
                eb.setReview_star(rs.getInt("review_star"));
                eb.setReview_date(rs.getInt("review_date"));

                reviewdates.add(eb);
            }
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
            try{
                if(st!=null){
                    st.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return reviewdates;
    }
    public void upDateReview(EbReviewBean ec){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql="update ebreview set book_isbn=?,book_isbn=?,review_text=?,review_star=?,review_date=? where book_isbn=?";

            st=cn.prepareStatement(sql);

            st.setString(1,ec.getBook_isbn());
            st.setString(2,ec.getUser_id());
            st.setString(3,ec.getReview_text());
            st.setInt(4,ec.getReview_star());
            st.setInt(5,ec.getReview_date());
            st.setString(6,ec.getBook_isbn());

            st.executeUpdate();
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();
        }finally{
            //���\�[�X���
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
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "delete from ebreview where book_isbn=? AND  user_id=?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            st.setString(1,ec.getBook_isbn());
            st.setString(1,ec.getUser_id());

            st.executeUpdate();
        }catch(SQLException e){
            //���[���o�b�N����
            OracleConnect.getInstance().rollback();   
                }finally{
            //���\�[�X���
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