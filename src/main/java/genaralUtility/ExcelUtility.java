package genaralUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	FileOutputStream fos;
	public String readDataFromExcelFile(String sname,int rownum,int cellnum) throws Throwable
	{
		fis=new FileInputStream(".\\src\\test\\resources\\createOrgtestdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return value;
		
	}
	public void setDataFromExcelFile(String sname,int rownum,int cellnum,String newValue) throws Throwable
	{
		fis=new FileInputStream(".\\src\\test\\resources\\createOrgtestdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	 wb.getSheet(sname).createRow(rownum).createCell(cellnum).setCellValue(newValue);
	 fos=new FileOutputStream(".\\src\\test\\resources\\Testdata1.xlsx");
	 wb.write(fos);
	 wb.close();
		
		
	}
}
