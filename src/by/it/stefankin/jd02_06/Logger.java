package by.it.stefankin.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    private final String filename="log.txt";
    private static volatile Logger logger;

    private Logger(){

    }

    static Logger getInstance() {
        Logger localLogger=Logger.logger;
        if (localLogger==null) {
            synchronized (Logger.class) {
                localLogger = Logger.logger;
                if (localLogger == null) {
                    logger = localLogger = new Logger();
                }
            }
        }
        return localLogger;
    }


    public void log(String text) {
        String fn = getFileName(Logger.class, this.filename);

        try (PrintWriter writer = new PrintWriter(
                    new FileWriter(fn,true))){
            Date date=new Date();
            String timeToPrint=date.toString();
            writer.println(text+" "+timeToPrint);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }

    }


    private static String getFileName(Class<?> aClass,String simpleName){
        String path =System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path=path+aClass.getName().replace(".",File.separator);
        path=path.replace(aClass.getSimpleName(),"");
        return path+simpleName;
    }


}
