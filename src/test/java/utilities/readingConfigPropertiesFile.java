package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readingConfigPropertiesFile {

	private Properties propFile;

	public Properties init_prop() {

		propFile = new Properties();

		try {
			FileInputStream flReader = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Config files\\config.properties");
			try {
				propFile.load(flReader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propFile;
	}
}