package main.java.com.actitime1.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Datadriven from property file and excel file
 * @author Prade
 *
 */
public class FileLib {
public String getPropertyFileData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/Commondata.properties.txt");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
public String getExcelFileData(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/testData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	return value;
	
}
}
