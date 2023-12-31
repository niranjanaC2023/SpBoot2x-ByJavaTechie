package com.nt.niranjana.spboot2x.standaloneFileReader;  //working fine

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * commons-collections4-4.1.jar Click Here
poi-3.17.jar Click Here
poi-ooxml-3.17.jar Click Here
poi-ooxml-schemas-3.17.jar Click Here
xmlbeans-2.6.0.jar Click Here
 */
public class Xlsx_fileReader  
{  
public static void main(String args[]) throws IOException  
{  
//obtaining input bytes from a file  
FileInputStream fis=new FileInputStream(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\employee.xlsx"));  
//creating workbook instance that refers to .xls file  
XSSFWorkbook wb=new XSSFWorkbook(fis);   
//creating a Sheet object to retrieve the object  
XSSFSheet sheet = wb.getSheetAt(0);  
//evaluating cell type   
FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();  
for(Row row: sheet)     //iteration over row using for each loop  
{  
for(Cell cell: row)    //iteration over cell using for each loop  
{  
switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
{  
case NUMERIC: //field that represents numeric cell type  
//getting the value of the cell as a number  
System.out.print(cell.getNumericCellValue()+ "\t");   
break;  
case STRING:   //field that represents string cell type  
//getting the value of the cell as a string  
System.out.print(cell.getStringCellValue()+ "\t");  
break;  
}  
}  
System.out.println();  
}  
}  
}  
