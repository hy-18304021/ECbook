package helper;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import java.io.UnsupportedEncodingException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
class IsbnConverter{
    //isbn������ƁAJson���Ԃ��Ă���
    public static JsonNode IsbnConvert(String isbn){
        String json=null;
        SSLSocketFactory factory = null;
        //
        try{
            //�w�肳�ꂽ�Z�L���A�\�P�b�g�v���g�R������������ SSLContext �I�u�W�F�N�g��Ԃ��܂��B
            SSLContext ctx = SSLContext.getInstance("TLS");
            //�������B�F�؂����M������ݒ�
            ctx.init(null, new NonAuthentication[] { new NonAuthentication() },null);
            factory = ctx.getSocketFactory();
        
            URL url=new URL("https://api.openbd.jp/v1/get?isbn=" + isbn);
        
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setSSLSocketFactory(factory);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            //OpenBD����UTF-8�̃f�[�^�����炤
            String body=null;
            while ((body = reader.readLine()) != null) {
                
                json+=body;
            }

            reader.close();
            con.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }

        json=json.substring(5);
        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        String name=null;
        JsonNode node = null;
        try {
            node = mapper.readTree(json);
 
            // name = node.get("onix").get("DescriptiveDetail").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            // // name=node.get("onix").asText();
            // System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return name;
        return node;
 
    }
}