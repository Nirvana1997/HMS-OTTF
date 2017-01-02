package cfg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 配置文件读取
 *
 * @author qzh
 *         Created by user on 2016/12/18.
 */
public class CfgReader {
    private static CfgReader cfgReader;
    private static Properties properties;

    public static CfgReader getInstance() {
        if (cfgReader == null)
            cfgReader = new CfgReader();
        return cfgReader;
    }

    /**
     * 返回对应属性的值
     * @param name 属性名
     * @return 属性值
     */
    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    private CfgReader() {
        properties = new Properties();
        //获取配置文件路径
        String configFile = System.getProperty("user.dir")+"/config.properties";
        //读取配置文件
        try {
            InputStreamReader inputStream = new InputStreamReader(new FileInputStream(configFile), "utf-8");
            properties.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
