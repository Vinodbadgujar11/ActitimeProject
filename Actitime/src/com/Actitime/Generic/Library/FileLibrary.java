package com.Actitime.Generic.Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	//String path="./TestData/Commondata.property";
 public String readDataFromPropertyFile(String key) throws IOException {
	 FileInputStream fis=new FileInputStream("./TestData/Commondata.property");
	 Properties p=new Properties();
	 p.load(fis);
	 String value = p.getProperty(key);
	return value;
	 
 }
  public String readDataFromExelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	  FileInputStream fis=new FileInputStream("./TestData/TestData1.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	
	  return value;
  }
 }
