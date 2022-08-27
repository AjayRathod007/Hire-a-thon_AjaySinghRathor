package assessment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReceiveExcelData {

	public static List<Data> receiveExcelData()
	{
		
		List<Data> allRecords = new ArrayList<>();
		
	try {
		File file = new File("C:\\Users\\DELL\\Downloads\\Hackathon _Timesheet.xlsx"); // creating a new file
																						// instance
		FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
		// creating Workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
		Iterator<Row> itr = sheet.iterator(); // iterating over excel file

		Row row = itr.next();

		while (itr.hasNext()) {
			row = itr.next();

			List<Object> rowData = new ArrayList<>();

			Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					// System.out.print(cell.getStringCellValue() + "\t\t\t");
					rowData.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					// System.out.print(cell.getNumericCellValue() + "\t\t\t");
					rowData.add(cell.getNumericCellValue());
					break;
				default:
				}
			}

			if (rowData.size() > 0) {
				Data d = new Data(rowData.get(0), rowData.get(1), rowData.get(2), rowData.get(3), rowData.get(4),
						rowData.get(5));
				allRecords.add(d);
				System.out.println(d);
				rowData.clear();
			}	
		}
		wb.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return allRecords;
	}

}
