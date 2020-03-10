package escape;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Escape{
    public static String wholeEscape(String restext){
        restext = htmlEscape(restext);
        System.out.println(restext);
        // restext = dbEscape(restext);
        // System.out.println(restext);
        return restext;
    }
    // public static String wholeEscape(Object nullobj){
    //     return nullobj;
    // }
    public static String htmlEscape(String restext){
        
        restext = restext.replace("&", "&amp;");
        restext = restext.replace("\"", "&quot;");
        restext = restext.replace("<", "&lt;");
        restext = restext.replace(">", "&gt;");
        restext = restext.replace("'", "&#39;");
        //改行コードをHTMLの改行タグ（<br>）に変換
        restext = restext.replaceAll("\r\n", "<br>");
        restext = restext.replaceAll("\n", "<br>");
        return restext;
    }
    // public static String htmlEscape(Object nullobj){
    //     return nullobj;
    // }
    public static String dbEscape(String restext){
        Pattern p=Pattern.compile("[,\\ * + . ? { } ( ) [ ] ^ $ - |]");
        Matcher m = p.matcher(restext);
        restext = m.replaceAll("\\"+m.group());
        // restext = myReplaceAll("ABOUT","{ABOUT}",restext);
        // restext = myReplaceAll("ACCUM","{ACCUM}",restext);
        // restext = myReplaceAll("AND","{AND}",restext);
        // restext = myReplaceAll("BT","{BT}",restext);
        // restext = myReplaceAll("BROADER","{BROADER}",restext);
        // restext = myReplaceAll("EQUIV","{EQUIV}",restext);
        // restext = myReplaceAll("FUZZY","{FUZZY}",restext);
        // restext = myReplaceAll("HASPATH","{HASPATH}",restext);
        // restext = myReplaceAll("INPATH","{INPATH}",restext);
        // restext = myReplaceAll("MINUS","{MINUS}",restext);
        // restext = myReplaceAll("NEAR","{NEAR}",restext);
        // restext = myReplaceAll("NOT","{NOT}",restext);
        // restext = myReplaceAll("NT","{NT}",restext);
        // restext = myReplaceAll("NARROWER","{NARROWER}",restext);
        // restext = myReplaceAll("OR","{OR}",restext);
        // restext = myReplaceAll("PT","{PT}",restext);
        // restext = myReplaceAll("RT","{RT}",restext);
        // restext = myReplaceAll("TERM","{TERM}",restext);
        // restext = myReplaceAll("STEM","{STEM}",restext);
        // restext = myReplaceAll("SOUNDEX","{SOUNDEX}",restext);
        // restext = myReplaceAll("SQE","{SQE}",restext);
        // restext = myReplaceAll("SYN","{SYN}",restext);
        // restext = myReplaceAll("THRESHOULD","{THRESHOULD}",restext);
        // restext = myReplaceAll("TR","{TR}",restext);
        // restext = myReplaceAll("TT","{TT}",restext);
        // restext = myReplaceAll("WITHIN","{WITHIN}",restext);
        //なんかうまくいかんかったのでとりあえずコメントアウト
        return restext;
    }
    // public static String dbEscape(Object nullobj){
    //     return nullobj;
    // }
    public static String myReplaceAll(String regex ,String reql,String text){
	    String retStr = "";
		retStr = Pattern.compile(regex,Pattern.CASE_INSENSITIVE).matcher(text).replaceAll(reql);
		return retStr;
	}
}