package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EbBookBean;
import java.io.IOException;
import java.util.Iterator;
public class IsbnImageGetter{
    //json����f�[�^���o����Bean�Ƀf�[�^�����B
    public static EbBookBean getIsbnImage(EbBookBean eb){
        // try {
        //Bean����isbn���o��
        String isbn=eb.getBook_isbn();
        //isbn�g����json�擾�BopenBD��API�g���Ă�N���X�̃��\�b�h�B
        JsonNode node = IsbnConverter.IsbnConvert(isbn);

        String imgURL=node.get("summary").get("cover").asText();
        
        URL target = new URL(getURL);
        try {
            HttpURLConnection conn = (HttpURLConnection) target.openConnection(); //�����R��
            conn.setRequestMethod("GET");
            conn.connect();


            InputStream in = conn.getInputStream();
            byte[] buf = new byte[4096];
            int readSize;

            OutputStream fos = new FileOutputStream(filename);
            while ( (readSize = in.read(buf)) != -1)
            {
            fos.write(buf, 0, readSize);
            }
            fos.close();

            in.close();
        return eb;
    }
}
