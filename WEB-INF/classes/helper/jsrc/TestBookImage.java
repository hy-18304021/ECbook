package helper.jsrc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.InputStream;
import bean.EbBookBean;
import helper.IsbnDataGetter;
import helper.ImgSaver;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.databind.JsonNode;

public class TestBookImage{
    //isbn���͂�����{�̃f�[�^DB��insert������
    public static void main(String[] args){
        //isbn��args����󂯎��
        String isbn=args[0];
        //isbn�g���ăf�[�^bean�ɓ˂�����
        EbBookBean bbb=new EbBookBean();
        bbb.setBook_isbn(isbn);
        bbb.setBook_amount(1);
        bbb.setBook_price(100);
        bbb.setGenre_id(1);
        IsbnDataGetter.getIsbnData(bbb);
        JsonNode node=IsbnDataGetter.getIsbnJson(bbb);
        ImgSaver.imgSave(node,isbn);
    }
    
}