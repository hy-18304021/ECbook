package froc;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebResponseContext implements ResponseContext{
    private Object result;
    private String target;

    private HttpServletResponse _response;

    public WebResponseContext(){}

    public void setTarget(String transferInfo){
        target="/WEB-INF/jsp/"+transferInfo+".jsp";
    }
    public void setTarget(String transferInfo, int i){
        target=transferInfo;
    }
    public String getTarget(){
        return target;
    }

    public void setResult(Object bean){
        result=bean;
    }
    public Object getResult(){
        return result;
    }

    public void setResponse(Object obj){
        _response=(HttpServletResponse)obj;
    }
    public Object getResponse(){
        return _response;
    }
    public void write(){
        if(result!=null){
            try{
                _response.setContentType("application/json");
                _response.setCharacterEncoding("UTF-8");
                _response.getWriter().write(result.toString());
                // System.out.println("WebResponseContext: written");
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            // System.out.println("Nothing");
        }
    }
}