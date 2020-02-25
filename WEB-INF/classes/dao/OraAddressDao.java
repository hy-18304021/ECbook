package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EbAddressBean;

//ebaddress�ɑ΂���SQL
public class OraAddressDao implements AddressDao{
    public void addAddress(EbAddressBean ea){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "insert into ebaddress values(DEFAULT,?,?,?,?,?)";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            //�o�C���h�ϐ��̐ݒ�
            st.setString(1,ea.getUser_id());
            st.setString(2,ea.getReceiver_name());
            st.setInt(3,ea.getPostal_code());
            st.setString(4,ea.getAddress());
            st.setString(5,ea.getTel());

            st.executeUpdate();
        }catch(SQLException e){
            //���[���o�b�N����
            e.printStackTrace();
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
    public EbAddressBean getAddress(String key){
        PreparedStatement st=null;
        Connection cn=null;
        ResultSet rs=null;
        EbAddressBean eb=new EbAddressBean();

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "select * from ebaddress where user_id = ?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);
            
            st.setString(1,key);

            rs=st.executeQuery();
            while(rs.next()){
                eb.setAddress_id(rs.getInt("address_id"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setReceiver_name(rs.getString("receiver_name"));
                eb.setPostal_code(rs.getInt("postal_code"));
                eb.setAddress(rs.getString("address"));
                eb.setTel(rs.getString("tel"));
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
        return eb;
    }
    public List getAllAddress(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbAddressBean> addressdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();

            String sql="select * from ebaddress";
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                EbAddressBean eb=new EbAddressBean();

                eb.setAddress_id(rs.getInt("address_id"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setReceiver_name(rs.getString("receiver_name"));
                eb.setPostal_code(rs.getInt("postal_code"));
                eb.setAddress(rs.getString("address"));
                eb.setTel(rs.getString("tel"));

                addressdates.add(eb);
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
        return addressdates;
    }

    public List getUserAddress(String user){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList<EbAddressBean> addressdates=new ArrayList<>();

        try{
            cn=OracleConnect.getInstance().getConnection();
            //SQL������
            String sql= "select * from ebaddress where user_id = ?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);
            
            st.setString(1,user);

            rs=st.executeQuery();

            while(rs.next()){
                EbAddressBean eb=new EbAddressBean();

                eb.setAddress_id(rs.getInt("address_id"));
                eb.setUser_id(rs.getString("user_id"));
                eb.setReceiver_name(rs.getString("receiver_name"));
                eb.setPostal_code(rs.getInt("postal_code"));
                eb.setAddress(rs.getString("address"));
                eb.setTel(rs.getString("tel"));

                addressdates.add(eb);
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
        return addressdates;
    }

    public void upDateAddress(EbAddressBean ea){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql="update ebaddress set Address_id=?,User_id=?,Receiver_name=?,Postal_code=?,Address=?,Tel=? where Address_id=?";

            st=cn.prepareStatement(sql);

            st.setInt(1,ea.getAddress_id());
            st.setString(2,ea.getUser_id());
            st.setString(3,ea.getReceiver_name());
            st.setInt(4,ea.getPostal_code());
            st.setString(5,ea.getAddress());
            st.setString(6,ea.getTel());
            st.setInt(7,ea.getAddress_id());

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
    public void deleteAddress(EbAddressBean ea){
        PreparedStatement st=null;
        Connection cn=null;

        try{
            cn=OracleConnect.getInstance().getConnection();

            //SQL������
            String sql= "delete from ebuser where address_id=?";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sql);

            st.setInt(1,ea.getAddress_id());

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
    public EbAddressBean getLastAddress_id(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        EbAddressBean eb=new EbAddressBean();

        try{
            cn=OracleConnect.getInstance().getConnection();
            //SQL������
            String sql= "select * from ebaddress where address_id = ?";
            String sqls= "select ADDRESS_ID_SEQ.CURRVAL from dual";

            //st�̃C���X�^���X�擾
            st=cn.prepareStatement(sqls);
            rs=st.executeQuery();
            rs.next();
            int adid=rs.getInt("CURRVAL");            

            PreparedStatement sts=cn.prepareStatement(sql);
            sts.setInt(1,adid);
            rs=sts.executeQuery();            

            rs.next();
            eb.setAddress_id(rs.getInt("address_id"));
            eb.setUser_id(rs.getString("user_id"));
            eb.setReceiver_name(rs.getString("receiver_name"));
            eb.setPostal_code(rs.getInt("postal_code"));
            eb.setAddress(rs.getString("address"));
            eb.setTel(rs.getString("tel"));
            
        }catch(SQLException e){
            //���[���o�b�N����
            e.printStackTrace();
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
        return eb;
    }
}