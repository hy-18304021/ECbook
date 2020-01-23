package command;

import froc.RequestContext;
import froc.ResponseContext;
import froc.AbstractCommand;

public class ImageShowCommand extends AbstractCommand{
    public ResponseContext execute(ResponseContext resc){
        //isbn�����ɉ摜�̐�΃p�X�����
        //�܂����΃p�X
        RequestContext reqc=getRequestContext();
		
        String isbn = (String)reqc.getParameter("isbn")[0];
        String rel="/img/book/"+isbn+".jpg";

        //����getRealPath().�������Aweb�A�v���P�[�V�������ւ̈ˑ����������
        //���΃p�X�n���Ɛ�΃p�X�Ԃ����\�b�h
        String realPath=reqc.getRealPath(rel);

        //bean���Z�b�g
        resc.setResult(realPath);
        //�摜�̐�΃p�X���g���ꏊ
        resc.setTarget("product");
        
        return resc;
    }
}