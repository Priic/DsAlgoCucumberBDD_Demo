
package utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class excelReader3 {

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = WorkbookFactory.create(new File(excelFilePath)).getSheet(sheetName);
		// Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		// the reading will start from the first row where header is present
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			// total number of columns in the header row
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			// iterating through the rows in the sheet
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				/*
				 * method getFirstRowNum will return the number of the first row with data which
				 * will be the header row. So adding currentRow iterator to step through each
				 * row. Could have probably also used an iterator to step through the rows in
				 * the sheet. for each iteration of the loop, the row object will represent the
				 * values of current row
				 */
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				// creating a HashMap with both key and value of type string.
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				// iterating through the total number of columns for each row
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					//
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}

	/*
	 * This function is iterating through the excel rows to identify the first
	 * column which has a cell type of either string, numeric, boolean or error. If
	 * after complete iteration, there isn't one, the method returns -1 implying no
	 * header rows in the sheet
	 */
	private int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == CellType.STRING) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	private Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}

	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;
		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellType() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell.getCellType() == CellType.STRING) {
				
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}

			/*
			 * The logic is same as for String check except that there is a converter to
			 * convert numeric cell value to String
			 */

			else if (cell.getCellType() == CellType.NUMERIC) {

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
			} else if (cell.getCellType() == CellType.BLANK) {

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			} else if (cell.getCellType() == CellType.BOOLEAN) {

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
			} else if (cell.getCellType() == CellType.ERROR) {

				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
			}
		}

		return columnMapdata;
	}
}
