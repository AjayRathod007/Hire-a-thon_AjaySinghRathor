package assessment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class Main {

	public static void main(String[] args) throws IOException {

		List<Data> allRecords = ReceiveExcelData.receiveExcelData();

		// First Problem
		System.out.println("first Problem Solution");
		System.out.println("*---------------*-------------*");
		meanEffortSpentByVariousTeamsOnDifferentProjects(allRecords);

		System.out.println("*---------------*-------------*");
		System.out.println("Second Problem Solution");
		// Second Problem
		fiveEmployeesWithTheLowestEfficiency(allRecords);
	}

	private static void fiveEmployeesWithTheLowestEfficiency(List<Data> allRecords) {

		List<EfficiencyPair> records = new ArrayList<>();
		Map<String, Double> effi = new TreeMap<>();

		for (Data x : allRecords) {
			if (effi.containsKey(x.getOwner())) {
				effi.put(x.getOwner(), effi.get(x.getOwner()) + x.getHours());
			} else {
				effi.put(x.getOwner(), x.getHours());
			}
		}

		for (Map.Entry<String, Double> entry : effi.entrySet()) {

			EfficiencyPair t = new EfficiencyPair(entry.getValue(), entry.getKey());
			records.add(t);
			// System.out.println(entry.getKey() + " : " + entry.getValue());

		}

		Collections.sort(records, new EfficiencyPair());

		for (int i = 0; i < 5; i++) {
			System.out.println(records.get(i));
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
