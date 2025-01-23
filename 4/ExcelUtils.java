import java.io.FileInputStream;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtils 
{ 
	// Use the below declarations
    public static XSSFSheet worksheet;
    public static XSSFWorkbook workbook;
    public static FileInputStream work_file;
    public static String file_path;
    public static String[] input=new String[5];

    public static String[] readExcelData(String sheetName) throws Exception
    {

		//Get the excel file path
		File file=new File("userdetails.xlsx");
		file_path=file.getAbsolutePath();
		work_file=new FileInputStream(file_path);
		workbook=new XSSFWorkbook(work_file);
		worksheet=workbook.getSheet(sheetName);
		
		XSSFRow row=worksheet.getRow(0);
		
        //Using the sheet name passed to this method, read the data and store it in a string array
        for(int i=0;i<row.getLastCellNum();i++)
        {
                input[i]=row.getCell(i).toString();
                System.out.println("%%%%%%%%%%%%%"+input[i]);
            
        }
	    //create a string array to store the excel values
		
		return input;
        //use switch case to read multiple datatypes
    }
}