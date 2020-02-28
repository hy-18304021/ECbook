
package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EbBookBean;
import java.io.IOException;
import java.util.Iterator;
public class IsbnDataGetter{
    //json����f�[�^���o����Bean�Ƀf�[�^�����B
    
    public static EbBookBean getIsbnData(EbBookBean eb){
        // try {
            //Bean����isbn���o��
            //isbn�g����json�擾�BopenBD��API�g���Ă�N���X�̃��\�b�h�B
        
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
                 //���ҁBContributorRole��[A01]�̂��̂�I��Ŏ擾�B���̑I�ׂ΃C���X�g���[�^�[�Ƃ���҂Ƃ��Ƃ��B
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


            //�ΏہB����͐��l�w�肩�ۂ����擾�B"AudienceCodeType":"22"�������琬�l�w��B�ׂ������R�~�������"AudienceCodeValue"������
            String audience=null;
            try{
                Iterator<JsonNode> audiences=node.get("onix").get("DescriptiveDetail").get("Audience").iterator();
            
                while(audiences.hasNext()){
                    JsonNode audienceNode=audiences.next();

                    if(audienceNode.get("AudienceCodeType").asText().equals("22")){
                        if(audienceNode.get("AudienceCodeValue").asText().equals("00")){

                        }else{
                            audience="���l����";
                        }
                        
                    }
                }
            }catch(NullPointerException e){

            }finally{
                eb.setAudience(audience);
            }
            
            


            //���[�x��
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
            
            

            //TextType:02�Ȃ痪���BTextType:03�Ȃ�ڐ��B�ڐ���I���������A�T�C�Y�ł���������l����B
            String text_content=null;
            try{
                Iterator<JsonNode> texts=node.get("onix").get("CollateralDetail").get("TextContent").iterator();
            
                while(texts.hasNext()){
                    JsonNode textNode=texts.next();
                    if(textNode.get("TextType").asText().equals("03")){
                        text_content=textNode.get("Text").asText();
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
        //isbn�g����json�擾�BopenBD��API�g���Ă�N���X�̃��\�b�h�B
        JsonNode node = IsbnConverter.IsbnConvert(isbn);
        return node;
    }
}
