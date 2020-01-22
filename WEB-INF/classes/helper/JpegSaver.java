package helper;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;

public class JpegSaver {

    //jpg�t�@�C����url�󂯎����img�t�H���_��jpg�Ƃ��ĕۑ�����
    //filePath:���摜
    //imageFilename:�ۑ���
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
