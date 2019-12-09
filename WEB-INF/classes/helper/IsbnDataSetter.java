
package helper;
import com.fasterxml.jackson.databind.JsonNode;
import bean.EBBookBean;
public class IsbnDataGetter{

    public static EBBookBean execute(EBBookBean eb){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);

            String name = node.get("onix").get("DescriptiveDetail").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setBook_name(name);
            String publisher=node.get("onix").get("summary").get("publisher").asText();
            eb.setPublisher(publisher);
            String series=;
            eb.setSeries(series);
            int volume;
            eb.setVolume(volume);
            String author=;
            eb.setAuthor(author);
            int release_date;
            eb.setRelease_date(release_date);
            String audience=;
            eb.setAudience(audience);
            String label;
            eb.setLabel(label);
            String text_content;
            eb.setText_content(text_content);



        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}