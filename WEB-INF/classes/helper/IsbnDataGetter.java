
package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EbBookBean;
import java.io.IOException;
import java.util.Iterator;
import escape.Escape;
public class IsbnDataGetter{
    //jsonからデータ取り出してBeanにデータ入れる。
    
    public static EbBookBean getIsbnData(EbBookBean eb){
        // try {
            //Beanからisbn取り出し
            //isbn使ってjson取得。openBDのAPI使ってるクラスのメソッド。
        
            JsonNode node = getIsbnJson(eb);
            System.out.println(node.toString());
        if(!node.toString().equals("null")){

            String name = node.get("onix").get("DescriptiveDetail").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setBook_name(name);
            String publisher=node.get("summary").get("publisher").asText();
            eb.setPublisher(publisher);
            String series=node.get("summary").get("series").asText();
            eb.setSeries(series);
            int volume=node.get("summary").get("volume").asInt();
            eb.setVolume(volume);
            
            String author=null;
            try{
                 //著者。ContributorRoleが[A01]のものを選んで取得。他の選べばイラストレーターとか訳者とかとれる。
                Iterator<JsonNode> contributors=node.get("onix").get("DescriptiveDetail").get("Contributor").iterator();
                
                while(contributors.hasNext()){
                    JsonNode contributor=contributors.next();
                    if(contributor.get("ContributorRole").get(0).asText().equals("A01")){
                        author=contributor.get("PersonName").get("content").asText();
                    }
                }
                
            }catch(NullPointerException e){

            }finally{
                eb.setAuthor(author);
            }

            String release_date=node.get("summary").get("pubdate").asText();
            eb.setRelease_date(release_date);


            //対象。今回は成人指定か否かを取得。"AudienceCodeType":"22"あったら成人指定。細かい理由欲しければ"AudienceCodeValue"も見る
            String audience=null;
            try{
                Iterator<JsonNode> audiences=node.get("onix").get("DescriptiveDetail").get("Audience").iterator();
            
                while(audiences.hasNext()){
                    JsonNode audienceNode=audiences.next();

                    if(audienceNode.get("AudienceCodeType").asText().equals("22")){
                        if(audienceNode.get("AudienceCodeValue").asText().equals("00")){

                        }else{
                            audience="成人向け";
                        }
                        
                    }
                }
            }catch(NullPointerException e){

            }finally{
                eb.setAudience(audience);
            }
            
            


            //レーベル
            String label=null;
            try{
                
                Iterator<JsonNode> titles=node.get("onix").get("DescriptiveDetail").get("Collection").get("TitleDetail").get("TitleElement").iterator();
                while(titles.hasNext()){
                    JsonNode titleNode=titles.next();
                    if(titleNode.get("TitleElementLevel").asText().equals("02")){
                        label=titleNode.get("TitleText").get("content").asText();
                        System.out.println(label);
                    }
                }
            }catch(NullPointerException e){

            }finally{
                eb.setLabel(label);
            }
            
            

            //TextType:02なら略説。TextType:03なら詳説。詳説を選択したが、サイズでかすぎたら考える。
            String text_content=null;
            try{
                Iterator<JsonNode> texts=node.get("onix").get("CollateralDetail").get("TextContent").iterator();
            
                while(texts.hasNext()){
                    JsonNode textNode=texts.next();
                    if(textNode.get("TextType").asText().equals("03")){
                        //wholeEscapeの中で改行を<br>に変換している
                        text_content=Escape.wholeEscape(textNode.get("Text").asText());

                        System.out.println(text_content);
                    }
                }
            }catch(NullPointerException e){
                
            }finally{
                eb.setText_content(text_content);
            }
        }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return eb;
    }

    public static JsonNode getIsbnJson(EbBookBean eb){
        String isbn=eb.getBook_isbn();
        //isbn使ってjson取得。openBDのAPI使ってるクラスのメソッド。
        JsonNode node = IsbnConverter.IsbnConvert(isbn);
        return node;
    }
}
