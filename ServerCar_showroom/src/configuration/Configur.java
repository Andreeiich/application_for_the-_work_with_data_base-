package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configur {

    public static final String DB_URL="db.url";
    public static final String DB_LOGIN="db.login";
    public static final String DB_PASSWORD="db.password";

    private static Properties properties=new Properties();

    public static String getProperties(String str){
        if(properties.isEmpty()){
            try (InputStream in= Configur.class.getClassLoader()
                    .getResourceAsStream("DBAccess.properties"))//используем поток ввода для чтения данных из файла через метод ресурс потока
            {
                properties.load(in);//загружаем все характеристики в виде строк из файла

            }catch (IOException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
            }

        }
        return properties.getProperty(str);//получаем ответ на запрос, при котором вызвали метод и передали его в качестве параметра str
    }

}
