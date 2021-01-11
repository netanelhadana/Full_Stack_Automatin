package Extensions;

import Utilities.commonOps;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelActions extends commonOps
{
    public static int getRowCount()
    {
        int rowCount = 0;
        try
        {
            workbook = new XSSFWorkbook(getData("sheetPath"));
            sheet = workbook.getSheet(getData("sheetName"));
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("Number of rows: " + rowCount);
        }catch (Exception e)
        {
//            System.out.println("Exception: " + e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getColumnCount()
    {
        int colCount = 0;
        try
        {
            workbook = new XSSFWorkbook(getData("sheetPath"));
            sheet = workbook.getSheet(getData("sheetName"));
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("Number of columns: " + colCount);
        }catch (Exception e)
        {
//            System.out.println("Exception: " + e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return colCount;
    }

    public static String getCellDataString(int rowNum, int columnNum)
    {
        String cellData = null;
        try
        {
            workbook = new XSSFWorkbook(getData("sheetPath"));
            sheet = workbook.getSheet(getData("sheetName"));
            cellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
//            System.out.println(cellData);
        }
        catch (Exception e)
        {
//            System.out.println("Exception: " + e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;
    }

    public static void getCellDataNumber(int rowNum, int columnNum)
    {
        try
        {
            workbook = new XSSFWorkbook(getData("sheetPath"));
            sheet = workbook.getSheet(getData("sheetName"));
            double cellData = sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
            System.out.println(cellData);
        }
        catch (Exception e)
        {
//            System.out.println("Exception: " + e);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
