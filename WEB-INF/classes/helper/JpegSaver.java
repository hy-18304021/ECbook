package helper;
import java.io.File;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import java.net.URL;
import java.awt.image.BufferedImage;

public class JpegSaver {

    //jpg�t�@�C����url�󂯎����img�t�H���_��jpg�Ƃ��ĕۑ�����
    //filePath:���摜
    //imageFilename:�ۑ���
	public static void jpegSave(String imageUrl,String imageFilename) {
        
		SSLSocketFactory factory = null;
		try {
			//�w�肳�ꂽ�Z�L���A�\�P�b�g�v���g�R������������ SSLContext �I�u�W�F�N�g��Ԃ��܂��B
            SSLContext ctx = SSLContext.getInstance("TLS");
            //�������B�F�؂����M������ݒ�
            ctx.init(null, new NonAuthentication[] { new NonAuthentication() },null);
			factory = ctx.getSocketFactory();
			
			URL url = new URL(imageUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setSSLSocketFactory(factory);
        	BufferedImage readImage = ImageIO.read(conn.getInputStream());
			ImageIO.write(readImage,"jpg", new File(imageFilename));
		}catch(Exception e) {
			e.printStackTrace();
		}
		// try{
        //     //�w�肳�ꂽ�Z�L���A�\�P�b�g�v���g�R������������ SSLContext �I�u�W�F�N�g��Ԃ��܂��B
        //     SSLContext ctx = SSLContext.getInstance("TLS");
        //     //�������B�F�؂����M������ݒ�
        //     ctx.init(null, new NonAuthentication[] { new NonAuthentication() },null);
        //     factory = ctx.getSocketFactory();
        
        //     URL url=new URL("https://api.openbd.jp/v1/get?isbn=" + isbn);
        
        //     HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        //     con.setSSLSocketFactory(factory);
            
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
        //     //OpenBD����UTF-8�̃f�[�^�����炤
        //     String body=null;
        //     while ((body = reader.readLine()) != null) {
                
        //         json+=body;
        //     }

        //     reader.close();
        //     con.disconnect();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }
	}
}
