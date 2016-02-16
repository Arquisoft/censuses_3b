package es.uniovi.asw;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {
	
	private static Map<Integer, ArrayList<String>> mapa2;

	public static void main(String... args) throws SQLException {
//		LoadUsers runner = new LoadUsers();
//		runner.run(args);
		
		Map<Integer, ArrayList<String>> mapa = new HashMap<Integer, ArrayList<String>>();
		int cont = 0;
		Connection c = Jdbc.getConnection();
		
		 
		try {
			FileInputStream file = new FileInputStream(new File(
					"src/test/resources/test.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				ArrayList<String> arr = new ArrayList<String>();
			
				arr.add(row.getCell(0).toString());
				arr.add(row.getCell(1).toString());
				arr.add(row.getCell(2).toString());
				arr.add(row.getCell(3).toString());
				
				
				mapa.put(cont++, arr);

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
					
					
				}
				System.out.println("");
			}
			file.close();
			PreparedStatement ps = null;
			for (Map.Entry<Integer, ArrayList<String>> entry : mapa.entrySet())
			{
			    System.out.println(entry.getKey() + " ");
				for(String s: entry.getValue()){
					System.out.println(s);
				}
				System.out.println("\n");
				
				ps = c.prepareStatement("INSERT INTO CENSOS VALUES(?, ?, ?, ?, ?)");
				ps.setString(1, entry.getValue().get(0));
				ps.setString(2, entry.getValue().get(1));
				ps.setString(3, entry.getValue().get(2));
				ps.setString(4, entry.getValue().get(3));
				ps.setString(5, "");
				ps.execute();
			}
			ps.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		    
	}

	

	// TODO
	void run(String... args) {
		System.out.println("TODO");
	}
}
