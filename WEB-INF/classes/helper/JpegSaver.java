package helper;
import java.io.File;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import java.net.URL;
import java.awt.image.BufferedImage;

public class JpegSaver {

    //jpgファイルのurl受け取ってimgフォルダにjpgとして保存する
    //filePath:元画像
    //imageFilename:保存先
	public static void jpegSave(String imageUrl,String imageFilename) {
        
		SSLSocketFactory factory = null;
		try {
			//指定されたセキュアソケットプロトコルを実装する SSLContext オブジェクトを返します。
            SSLContext ctx = SSLContext.getInstance("TLS");
            //初期化。認証せず信頼する設定
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
        //     //指定されたセキュアソケットプロトコルを実装する SSLContext オブジェクトを返します。
        //     SSLContext ctx = SSLContext.getInstance("TLS");
        //     //初期化。認証せず信頼する設定
        //     ctx.init(null, new NonAuthentication[] { new NonAuthentication() },null);
        //     factory = ctx.getSocketFactory();
        
        //     URL url=new URL("https://api.openbd.jp/v1/get?isbn=" + isbn);
        
        //     HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        //     con.setSSLSocketFactory(factory);
            
        //     BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
        //     //OpenBDからUTF-8のデータをもらう
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
