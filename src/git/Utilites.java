package git;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilites {
	public FileInputStream file;
	public FileOutputStream fio;
	public XSSFWorkbook work;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path = null;

	Utilites(String path) {
		this.path = path;
	}

//=====COUNTING ROWS===========================================
	public int getRows(String sheet1) throws Exception {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		int rows = sheet.getLastRowNum();
		file.close();
		work.close();
		return rows;
	}

	// ======================COUNTING CELLS========================
	public int getCell(String sheet1, int rownum) throws Exception {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		int cell = sheet.getRow(rownum).getLastCellNum();
		return cell;
	}

	// ====================READ THE CELL DATA===========
	public String getCellData(String sheet1, int rownum, int cellnum) throws Exception {

		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		DataFormatter format = new DataFormatter();
		String data;
		try {
			data = format.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		return data;
	}

	// =============SET DATA IN A
	// CELL===============================================================
	public void setCellValue(String sheet1, int rownum, int cellnum, String data) throws Exception {

		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		row = sheet.getRow(rownum);
		row.createCell(cellnum);
		fio = new FileOutputStream("./data/Details.xlsx");
		work.write(fio);
		work.close();
		file.close();
		fio.close();
	}

//================SET GREEN COLORE========================	
	public void fillGreenColor(String sheet1, int rownum, int cellnum) throws Exception {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		style = work.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		work.close();
	}

//=========================SET RED COLORE========================
	public void fillRedColor(String sheet1, int rownum, int cellnum) throws Exception {
		file = new FileInputStream(path);
		work = new XSSFWorkbook(file);
		sheet = work.getSheet(sheet1);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		style = work.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		work.close();
	}

}
