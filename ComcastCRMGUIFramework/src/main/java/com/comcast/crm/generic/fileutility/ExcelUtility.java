package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rowNum,int celNum) throws   IOException {
		FileInputStream fls=new FileInputStream("C:\\Users\\rohit\\git\\repository3\\ComcastCRMGUIFramework\\testdata\\Book420.xlsx");
		 Workbook wb=WorkbookFactory.create(fls);
		        String Data =wb.getSheet(sheetname).getRow(rowNum).getCell(celNum).getStringCellValue();
		        wb.close();
		        return Data;
		 
		
	}
	
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fls=new FileInputStream("C:\\Users\\rohit\\git\\repository3\\ComcastCRMGUIFramework\\testdata\\Book420.xlsx");
		 Workbook wb=WorkbookFactory.create(fls);
		    int Data=wb.getSheet(sheetName).getLastRowNum();
		    wb.close();
		    return Data;
		
	}
	
	public void writeDataBackToTheExcel(String SheetName,int rowNum,int celNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fls=new FileInputStream("D:\\ComcastCRMGUIFramework\\testdata\\Book420.xlsx");
		 Workbook wb=WorkbookFactory.create(fls);
       wb.getSheet(SheetName).getRow(rowNum).createCell(celNum);//.setCellType(CellType.STRING).setCellValue(String);

       FileOutputStream fos=new FileOutputStream("");
       wb.write(fos);
       wb.close();
    
       
	}
}
