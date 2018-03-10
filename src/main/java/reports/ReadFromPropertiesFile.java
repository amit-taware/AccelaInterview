package reports;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

    private String fileName;
    private final String resourcesFolderPath = "src/test/resources/";
    private final String fileExt = ".properties";

    public ReadFromPropertiesFile(String environment) {
        this.fileName = environment;
    }

    public String readPropertiesFile(String keyName) {
        String keyValue;
        Properties propertiesObject = new Properties();
        try {
            propertiesObject.load(new FileInputStream(resourcesFolderPath
                    + fileName + fileExt));

        } catch (IOException e) {
            e.printStackTrace();
        }
        keyValue = propertiesObject.getProperty(keyName);
        return keyValue;
    }

}
