package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.google.common.collect.Table.Cell;

public class readFromExcel {

	/*
	 * step1 -give path of file step2- Read/open the file in inputstream mode using
	 * FileInputStream Class and add throw declarations step3- get the
	 * workbook->sheet->row->columns(cell in apache po) step3a- get workwook- using
	 * xssfworkbook class we create instance of that class and access its method (we
	 * get location of file and refer it using FileinputStream in read mode and then
	 * we get the workbook of file step3b-> getsheet and then access row and column
	 * using for loop or Java iterator and advanced loop
	 */

	public void readExceldata() throws IOException {

		String excelFilePath = "C:\\Users\\tusha\\eclipse-workspace\\JuiceShopSelenium\\src\\test\\resources\\TestData\\CountriesPop.xlsx"; // String
																																			// excelFilePath="C:\\Users\\tusha\\eclipse-workspace\\JuiceShopSelenium\\src\\test\\resources\\TestData\\CountriesPop.xlsx";
		FileInputStream inputStreamFile = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStreamFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// using for loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		System.out.println(+rows);
		System.out.println(+cols);
		/*
		 * for (int r = 0; r <= rows; r++) { // row iteration
		 * 
		 * XSSFRow row = sheet.getRow(r);
		 * 
		 * for (int c = 0; c < cols; c++) // inside that row column iterations {
		 * XSSFCell colCell = row.getCell(c);
		 * 
		 * switch (colCell.getCellType()) {
		 * 
		 * case STRING: System.out.print(colCell.getStringCellValue()); break; case
		 * NUMERIC: System.out.print(colCell.getNumericCellValue()); break; case
		 * BOOLEAN: System.out.print(colCell.getBooleanCellValue()); break;
		 * 
		 * } System.out.print(" | ");
		 * 
		 * } System.out.println(); }
		 */
		// same operation using iterator method (Java util function) advanced for loop
		// row element
		Iterator iterator = sheet.iterator(); // have all row value

		while (iterator.hasNext()) {

			XSSFRow row = (XSSFRow) iterator.next(); // this will have individual row value
			Iterator cellIterator = row.cellIterator(); // cell iterator have all cell value

			while (cellIterator.hasNext()) {

				XSSFCell colCell = (XSSFCell) cellIterator.next();

				switch (colCell.getCellType()) {
				case STRING:
					System.out.print(colCell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(colCell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(colCell.getBooleanCellValue());
					break;

				}
				System.out.print(" | ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws IOException {

		readFromExcel rdata = new readFromExcel();
		rdata.readExceldata();
	}
}
