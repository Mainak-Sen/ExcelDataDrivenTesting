package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class get_Excel_Data {
@DataProvider
public Object[] get_excel_Data(){
	
	XSSFWorkbook wb = null;
	try {
		wb = new XSSFWorkbook("./APITestData.xlsx");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Exception occured");
	}
	DataFormatter dft=new DataFormatter();
	XSSFSheet req_sheet = null;
	int sheet_Count=wb.getNumberOfSheets();
	for(int i=0;i<sheet_Count;i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("ADD_BOOK"))
		{
			req_sheet=wb.getSheetAt(i);
			break;
		}
	}
	int row_count=req_sheet.getLastRowNum()-req_sheet.getFirstRowNum();
	int col_count=req_sheet.getRow(0).getLastCellNum()-req_sheet.getRow(0).getFirstCellNum();
	Object[] obj_array=new Object[row_count];
	ArrayList<String> a=new ArrayList<String>();
	for(int k=0;k<col_count;k++)
	{
		a.add(dft.formatCellValue(req_sheet.getRow(0).getCell(k)));
	}
	
	for(int i=1;i<=row_count;i++)
	{   
		HashMap<String,Object> hm=new LinkedHashMap<String,Object>();
		for(int j=0;j<col_count;j++)	
		{
			String cell_value=dft.formatCellValue(req_sheet.getRow(i).getCell(j));
			hm.put(a.get(j),cell_value);
			//obj_array[i-1][j]=cell_value;
		}
		//System.out.println(hm);
	    obj_array[i-1]=hm;
	}
	return obj_array;
}

}

