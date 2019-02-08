package com.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Readexcel {

    public void readfromExcel(String fileName,String sheetName) throws IOException{

   
    	DataFormatter formatter = new DataFormatter(Locale.US);
    
    FileInputStream inputStream = new FileInputStream("E:\\workspace\\Learning\\Test_Input_data\\Testdata.xlsx");

    Workbook guru99Workbook = null;   

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){
    

    //If it is xlsx file then create object of XSSFWorkbook class

    guru99Workbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){
         
        guru99Workbook = new HSSFWorkbook(inputStream);

    }


    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

    //Find number of rows in excel file
   
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    
System.out.println("Row count" +rowCount);
    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {
    	
    	

        Row row = guru99Sheet.getRow(i);
     
        
        //Create a loop to print cell values in a row

        for (int j = 0; j < row.getLastCellNum(); j++) {

        	 System.out.print(formatter.formatCellValue(row.getCell(j)));
           

        }

        System.out.println();
    } 

    }  

    public static void main(String ...strings ) throws IOException{

      	Readexcel objExcelFile = new Readexcel();
    objExcelFile.readfromExcel("Testdata.xlsx","Sheet1");
    
    

    }


}
