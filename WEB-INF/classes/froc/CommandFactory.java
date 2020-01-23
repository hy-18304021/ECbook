package froc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class CommandFactory{
    public static AbstractCommand getCommand(RequestContext reqc){
        AbstractCommand command=null;
        Properties pro=new Properties();
        String realPath=reqc.getRealPath("/WEB-INF/classes/property/command.properties");
        try{
            pro.load(new FileInputStream(realPath));

            String name=pro.getProperty(reqc.getCommandPath());

            Class c=Class.forName(name);

            command=(AbstractCommand)c.newInstance();
        }catch(FileNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(InstantiationException e){
            throw new RuntimeException(e.getMessage(),e);
        }catch(IllegalAccessException e){
            throw new RuntimeException(e.getMessage(),e);
        }

        return command;
    }
}