package bean;

import java.io.Serializable;

public class EbAddressBean{
    private int address_id;//�����ID
    private String user_id;//���[�U�[�� 
    private String receiver_name;
    private int postal_code;//�����X�֔ԍ�
    private String address;//�����Z��
    private String tel;//�����d�b�ԍ�

    public EbAddressBean(){}

    public void setAddress_id(int id){
        address_id=id;
    }
    public int getAddress_id(){
        return address_id;
    }

    public void setUser_id(String user){
        user_id=user;
    }
    public String getUser_id(){
        return user_id;
    }

    public void setReceiver_name(String receiver){
        receiver_name=receiver;
    }
    public String getReceiver_name(){
        return receiver_name;
    }

    public void setPostal_code(int code){
        postal_code=code;
    }
    public int getPostal_code(){
        return postal_code;
    }

    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }

    public void setTel(String tel){
        this.tel=tel;
    }
    public String getTel(){
        return tel;
    }

   
}