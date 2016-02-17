package es.uniovi.asw.parser.read;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RCensus implements ReadCensus {

	@Override
	public Map<Integer, ArrayList<String>> leerFichero(String nombreFichero) {
		Map<Integer, ArrayList<String>> mapa = new HashMap<Integer, ArrayList<String>>();
		int cont = 0;
			 
		try {
			
			FileInputStream file = new FileInputStream(new File(
					"src/test/resources/" + nombreFichero));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				
				ArrayList<String> arr = new ArrayList<String>();
			
				if (!(row.getRowNum() == 0)) { //Para omitir la primera fila...
					if(row.getCell(0)==null) arr.add("");
					else arr.add(row.getCell(0).toString());// nombre
					
					arr.add(row.getCell(1).toString());// nif
					arr.add(generarEmail(row.getCell(0).toString()
							.replace(" ", "")));
					
					if(row.getCell(2)==null) arr.add("-1");
					else arr.add(row.getCell(2).toString());// codColegio
					arr.add(generarPassword());

					mapa.put(cont++, arr);
				}

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
					
					
					workbook.close();
					
				}
				System.out.println("");
			}
			file.close();
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapa;
		
	}

	private String generarEmail(String nombre) {
		return nombre + "@gmail.com";
	}
	
	private String generarPassword(){
		String [] letras = {"a", "b",  "c",  "d",  "e",  "f",  "g",  "h",  "i",  "j",
			"k",  "l",  "m",  "n",  "o",  "p",  "q",  "r",  "s",  "t",  "u",  "v",  "w",
			"x",  "y",  "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L",
			"M", "N","O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		int num [] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		String [] simbolos = {"!", "·", "$", "%", "&", "/", "(", ")", "=", "?", "¿", "^", "*", "Ç", ":" };
		
		Random  r = new Random();
		int posLetra1 = r.nextInt(letras.length);
		int posLetra2 = r.nextInt(letras.length);
		int posLetra3 = r.nextInt(letras.length);
		int posLetra4 = r.nextInt(letras.length);
		int posLetra5 = r.nextInt(letras.length);
		int posNum1 = r.nextInt(num.length);
		int posNum2 = r.nextInt(num.length);
		int posSim = r.nextInt(simbolos.length);
		
		return letras[posLetra1] + letras[posLetra2] + letras[posLetra3] + letras[posLetra4] + letras[posLetra5] + num[posNum1] + num[posNum2] + simbolos[posSim];
		
	}

}
