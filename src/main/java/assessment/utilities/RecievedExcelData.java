package assessment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RecievedExcelData {

	public static void main(String[] args) throws IOException {

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		// First Problem
		meanEffortSpentByVariousTeamsOnDifferentProjects(allRecords);

		//
		fiveEmployeesWithTheLowestEfficiency(allRecords);
	}

	private static void fiveEmployeesWithTheLowestEfficiency(List<Data> allRecords) {
		
		Map<String,Double> effi = new TreeMap<>();
		
		for(Data x : allRecords)
		{
			
		}
		
	}

	private static void meanEffortSpentByVariousTeamsOnDifferentProjects(List<Data> allRecords) {

		Map<String, Map<String, Pair>> outerMap = new HashMap<>();

		for (Data x : allRecords) {

			if (outerMap.containsKey(x.getTeam())) {

				Map<String, Pair> innerMap = outerMap.get(x.getTeam());

				if (innerMap.containsKey(x.getProjectName())) {

					Pair temp = innerMap.get(x.getProjectName());

					temp.getEmployeesWorkedOnProject().add(x.getOwner());
					temp.setTotalHoursSpentByTeam(temp.getTotalHoursSpentByTeam() + x.getHours());

					// innerMap.put(x.getProjectName(), innerMap.get(x.getProjectName()) +
					// x.getHours());
				} else {

					Pair temp = new Pair();
					temp.getEmployeesWorkedOnProject().add(x.getOwner());
					temp.setTotalHoursSpentByTeam(temp.getTotalHoursSpentByTeam() + x.getHours());
					innerMap.put(x.getProjectName(), temp);
				}
			} else {

				Pair temp = new Pair();
				temp.getEmployeesWorkedOnProject().add(x.getOwner());
				temp.setTotalHoursSpentByTeam(temp.getTotalHoursSpentByTeam() + x.getHours());

				Map<String, Pair> innerMap = new HashMap<>();
				innerMap.put(x.getProjectName(), temp);
				outerMap.put(x.getTeam(), innerMap);
			}

		}

		for (Map.Entry<String, Map<String, Pair>> entry : outerMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
