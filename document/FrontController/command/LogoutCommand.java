import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import func.*;

public class LogoutCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		RequestContext req=getRequestContext();

        HttpSession session=((HttpServletRequest) req).getSession();
        session.removeAttribute("flag");

        //�z�[����
		resc.setTarget("index");
        return resc;
	}
}