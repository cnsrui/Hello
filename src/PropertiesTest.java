import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties 属性
 * store()
 * load()
 */
public class PropertiesTest {
    public static void main(String[] args)
            throws Exception {
        Properties props1 = new Properties();
        // 向Properties中增加属性
        props1.setProperty("username", "yeeku");
        props1.setProperty("password", "123456");
        try {
            // 将Properties中的key-value对保存到a.ini文件中
            // 保存和读取配置文件数据的顺序，还不清楚，可能是首字母a-z顺序
            props1.store(new FileOutputStream("resource/a.ini"), "comment line");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        // 新建一个Properties对象
        Properties props2 = new Properties();
        try {
            props2.load(new FileInputStream("resource/a.ini"));
            // 向Properties中增加属性
            props2.setProperty("gender", "male");
            props2.setProperty("address", "China");
            props2.store(new FileOutputStream("resource/a.ini"), "comment line");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(props2);
        System.out.println(props2.get("gender"));
        System.out.println(props2.get("username"));
    }
}
