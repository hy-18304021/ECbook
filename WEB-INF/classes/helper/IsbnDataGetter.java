
package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EBBookBean;
import java.io.IOException;
public class IsbnDataGetter{
    //jsonからデータ取り出してBeanにデータ入れる。
    public static EBBookBean getIsbnData(EBBookBean eb){
        // try {
            //Beanからisbn取り出し
            String isbn=eb.getBook_isbn();
            //isbn使ってjson取得。openBDのAPI使ってるクラスのメソッド。
            JsonNode node = IsbnConverter.IsbnConvert(isbn);


            String name = node.get("onix").get("DescriptiveDetail").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setBook_name(name);
            String publisher=node.get("summary").get("publisher").asText();
            eb.setPublisher(publisher);
            String series=node.get("summary").get("series").asText();
            eb.setSeries(series);
            int volume=node.get("summary").get("volume").asInt();
            eb.setVolume(volume);

            //著者。ContributorRoleが[A01]のものを選んで取得。他の選べばイラストレーターとか訳者とかとれる。
            JsonNode contributors=node.get("onix").get("DescriptiveDetail").get("Contributor");
            String author=null;
            if(contributors.get("ContributorRole").get(0).asText().equals("A01")){
                author=contributors.get("PersonName").get("content").asText();
            }
            eb.setAuthor(author);


            int release_date=node.get("summary").get("pubdate").asInt();
            eb.setRelease_date(release_date);

            //対象。今回は成人指定か否かを取得。"AudienceCodeType":"22"あったら成人指定。細かい理由欲しければ"AudienceCodeValue"も見る
            JsonNode audienceNode=node.get("onix").get("DescriptiveDetail").get("Audience");
            String audience=null;
            if(audienceNode.get("AudienceCodeType").asText().equals("22")){
                audience="成人向け";
            }
            eb.setAudience(audience);

            String label=node.get("onix").get("DescriptiveDetail").get("Collection").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setLabel(label);

            //TextType:02なら略説。TextType:03なら詳説。詳説を選択したが、サイズでかすぎたら考える。
            JsonNode textNode=node.get("onix").get("CollateralDetail").get("TextContent");
            String text_content=null;
            if(textNode.get("TextType").asText().equals("03")){
                text_content=textNode.get("Text").asText();
            }
            eb.setText_content(text_content);



        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return eb;
    }
}
