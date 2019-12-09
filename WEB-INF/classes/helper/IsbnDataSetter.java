
package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EBBookBean;
public class IsbnDataGetter{
    //json����f�[�^���o����Bean�Ƀf�[�^�����B
    public static EBBookBean getIsbnData(EBBookBean eb){
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Bean����isbn���o��
            String isbn=eb.getBook_isbn();
            //isbn�g����json�擾�BopenBD��API�g���Ă�N���X�̃��\�b�h�B
            JsonNode node = IsbnConverter.IsbnConvert(isbn);


            String name = node.get("onix").get("DescriptiveDetail").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setBook_name(name);
            String publisher=node.get("onix").get("summary").get("publisher").asText();
            eb.setPublisher(publisher);
            String series=node.get("onix").get("summary").get("series").asText();
            eb.setSeries(series);
            int volume=node.get("onix").get("summary").get("volume").asInt();
            eb.setVolume(volume);

            //���ҁBContributorRole��[A01]�̂��̂�I��Ŏ擾�B���̑I�ׂ΃C���X�g���[�^�[�Ƃ���҂Ƃ��Ƃ��B
            JsonNode contributors=node.get("onix").get("DescriptiveDetail").get("Contributor");
            String author=null;
            if(contributors.get("ContributorRole").get(0).asText().equals("A01")){
                author=contributors.get("PersonName").get("content");
            }
            eb.setAuthor(author);


            int release_date=node.get("onix").get("summary").get("pubdate").asInt();
            eb.setRelease_date(release_date);

            //�ΏہB����͐��l�w�肩�ۂ����擾�B"AudienceCodeType":"22"�������琬�l�w��B�ׂ������R�~�������"AudienceCodeValue"������
            JsonNode audienceNode=node.get("onix").get("DescriptiveDetail")get("Audience");
            String audience=null;
            if(audienceNode.get("AudienceCodeType").asText().equals("22")){
                audience="���l����";
            }
            eb.setAudience(audience);

            String label=node.get("onix").get("DescriptiveDetail").get("Collection").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setLabel(label);

            //TextType:02�Ȃ痪���BTextType:03�Ȃ�ڐ��B�ڐ���I���������A�T�C�Y�ł���������l����B
            JsonNode textNode=node.get("onix").get("CollateralDetail").get("TextContent").asText();
            String text_content=null;
            if(textNode.get("TextType").asText().equals("03")){
                text_content=textNode.get("Text").asText();
            }
            eb.setText_content(text_content);



        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
