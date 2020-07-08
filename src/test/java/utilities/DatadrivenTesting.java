package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatadrivenTesting {
	
	public ArrayList<String> getdata(String testcasename) throws IOException 
	{
		int coulmnno =0;
		int k=0;
		FileInputStream fis = new FileInputStream("C:\\Work\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheetcount = workbook.getNumberOfSheets();
		ArrayList<String> a = new ArrayList<String>();
		
		for(int i=0;i<sheetcount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows =sheet.iterator();
				Row firstrow =rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				
				while(cells.hasNext())
				{
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Test Cases"))
					{
						coulmnno=k;
						
					}
					k++;
				}
				//System.out.println(coulmnno);
				while(rows.hasNext())
				{
				Row r = rows.next();
				if(r.getCell(coulmnno).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> c = r.cellIterator();
					while(c.hasNext())
					{		Cell cv=c.next();
							if(cv.getCellType()==CellType.STRING)
							{
								
								a.add(cv.getStringCellValue());
								//System.out.println(true);
							}
							else
							{
								a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
								//System.out.println(false);
							}
					}
				}
				
				}
				//System.out.println(a);
				
				
				
				
				
			}
			
	        
		}
		
		return a;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		
		
	}

}

//Delete Profile
//Login
//Purchase
