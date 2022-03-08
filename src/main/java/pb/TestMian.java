package pb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @author pandaqyang
 * @date 2021/7/16 11:03
 */
public class TestMian {

    public static void main(String[] args) {
        Properties pro = new Properties();
        try {
            File file = new File("config/config.properties");
            if (!file.exists()) {
                System.out.println("file don't exist!: ");
            }
            else {
                System.out.println("file exist!: ");
            }
            InputStream is = new FileInputStream("config/config.properties");
            pro.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = null;
        try {
            content = new String(pro.getProperty("content").getBytes("gbk"), "gbk") ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("content is: " + content);
    }
}
