package helper;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;

public class JpegSaver {

    //jpgファイルのurl受け取ってimgフォルダにjpgとして保存する
    //filePath:元画像
    //imageFilename:保存先
	public static void jpegSave(String imageUrl,String imageFilename) {
        

		try {
			URL url = new URL(imageUrl);
			// HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        	BufferedImage readImage = ImageIO.read(url);
			ImageIO.write(readImage,"jpg", new File(imageFilename));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
