package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EbBookBean;
import java.io.IOException;
import java.util.Iterator;
public class IsbnImageGetter{
    //jsonからデータ取り出してBeanにデータ入れる。
    public static EbBookBean getIsbnImage(EbBookBean eb){
        // try {
        //Beanからisbn取り出し
        String isbn=eb.getBook_isbn();
        //isbn使ってjson取得。openBDのAPI使ってるクラスのメソッド。
        JsonNode node = IsbnConverter.IsbnConvert(isbn);

        String imgURL=node.get("summary").get("cover").asText();
        
        URL target = new URL(getURL);
        try {
            HttpURLConnection conn = (HttpURLConnection) target.openConnection(); //ここ３つ
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
