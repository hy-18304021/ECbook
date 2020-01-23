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

        try{
            //Mai  C:/Users/SuSu/Desktop/ECBook/WEB-INF/classes/property
            //C:/Users/koyama/Documents/GitHub/ECbook/WEB-INF/classes/property/command.properties
            pro.load(new FileInputStream("C:/Users/SuSu/Desktop/ECBook/WEB-INF/classes/property/command.properties"));

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