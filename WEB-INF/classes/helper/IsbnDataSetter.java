
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
            String series=node.get("onix").get("summary").get("series").asText();
            eb.setSeries(series);
            int volume=node.get("onix").get("summary").get("volume");
            eb.setVolume(volume);
            String author=.get("Contributor").get("ContributorRole":["A01"],"PersonName").get("content").asText();
            eb.setAuthor(author);
            int release_date=.get("onix").get("summary").get("pubdate");
            eb.setRelease_date(release_date);
            String audience=.get("Audience");
            eb.setAudience(audience);
            String label=.get("onix").get("DescriptiveDetail").get("Collection").get("TitleDetail").get("TitleElement").get("TitleText").get("content").asText();
            eb.setLabel(label);
            String text_content=.get("CollateralDetail").get("TextContent").asText();
            eb.setText_content(text_content);



        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
