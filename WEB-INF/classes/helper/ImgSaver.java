package helper;
import com.fasterxml.jackson.databind.JsonNode;
public class ImgSaver{
    //json����f�[�^���o����img�t�H���_��jpg�Ƃ��ĕۑ�����
    public static void imgSave(JsonNode node,String isbn){
    // String imgURL=node.get("summary").get("cover").asText();
    String imgURL="https://cover.openbd.jp/9784088820743.jpg";
    // String imgURL="https:\/\/cover.openbd.jp\/9784040640075.jpg";
    String imageFilename="C:/Users/koyama/Documents/ECbook/img/book/"+isbn+".jpg";

    JpegSaver.jpegSave(imgURL,imageFilename);
    }
}
