package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public  String getDataFromPropertiesFile(String Key) throws IOException {
		FileInputStream fls=new FileInputStream("C:\\Users\\rohit\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\CommonData.properties");
		 Properties pro=new Properties();
		 pro.load(fls);
		 String Data=pro.getProperty(Key);
		 return Data;
		 
	}

}
