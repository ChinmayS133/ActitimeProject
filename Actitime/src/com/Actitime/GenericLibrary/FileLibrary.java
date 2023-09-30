package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is generic class, designed to read data from property file and Excel file
 * @author Chinmay S.
 */
public class FileLibrary {
	
	/**
	 * This method is a non-static method, created to read data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromProperty(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./TestData/CommonData.property");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
	
	/**
	 * This method is a non-static method, created to read data from Excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcel(String sheet,int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	

}
