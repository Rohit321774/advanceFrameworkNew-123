package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String Key) throws IOException, ParseException {
		FileReader fileR=new FileReader("C:\\Users\\rohit\\git\\repository3\\ComcastCRMGUIFramework\\configAppData\\JsonCommomData.json");
            JSONParser parser=new JSONParser();
                Object ob=parser.parse(fileR);
	
	       JSONObject map=(JSONObject)ob;
	                String Data=(String)map.get(Key);
	                return Data;
	              
		  
		
	}

}
