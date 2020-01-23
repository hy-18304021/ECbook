package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class ImageShowCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        //isbnを元に画像の絶対パスを作る
        //まず相対パス
        RequestContext reqc=getRequestContext();
		
        String isbn = (String)reqc.getParameter("isbn")[0];
        String rel="/img/book/"+isbn+".jpg";

        //次にgetRealPath().ただし、webアプリケーション環境への依存を避けたい
        //相対パス渡すと絶対パス返すメソッド
        String realPath=reqc.getRealPath(rel);

        //beanをセット
        resc.setResult(realPath);
        //画像の絶対パスを使う場所
        resc.setTarget("product");
        
        return resc;
    }
}