package cfg;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * 配置文件读取
 * Created by user on 2016/12/18.
 */
public class CfgReader {
    private static CfgReader cfgReader;
    SAXReader reader = new SAXReader();
    Document document = reader.read("config.xml");

    public static CfgReader getInstance() throws DocumentException {
        if(cfgReader==null)
            cfgReader = new CfgReader();
        return cfgReader;
    }

    private CfgReader() throws DocumentException {
    }
}
