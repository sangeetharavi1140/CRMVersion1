package genaralUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
	public Object[][] readMultipleDateFromExcel(String path,String SheetName) throws Throwable, IOException
	{
		fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int row = wb.getSheet(SheetName).getLastRowNum();
		int column=wb.getSheet(SheetName).getRow(0).getLastCellNum();
		Object[][] data=new Object[row][column];
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<column;j++)
			{
				Cell cell=wb.getSheet(SheetName).getRow(i).getCell(j);
				data[i-1][j]=formatter.formatCellValue(cell);
			}
		}
		return data;
		
	}

}
