package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// Step 1 : Load the file to file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commndata.Properties.txt");
		//Step 2 : Create object of Properties from Java
		Properties pobj = new Properties();
		//Step 3 : Load the file to properties obj
		pobj.load(fis);
		//step 4 : read data through the key
		String Browser = pobj.getProperty("browser");
		System.out.println(Browser);
		
		String URL = pobj.getProperty("url");
		System.out.println(URL);

	}

}
