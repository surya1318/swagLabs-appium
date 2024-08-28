package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private static Properties props = new Properties();
    TestUtils logger = new TestUtils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String fileName = "config.properties";

        if(props.isEmpty()){
            try{
            	logger.log().info("------------loading config properties------------");
                is = getClass().getClassLoader().getResourceAsStream(fileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                logger.log().fatal("------------Failed to load config properties------------" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
}
