package com.jpn.gemstone.texstone.server.worker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jpn.gemstone.texstone.server.model.Article;





public class ExcelReader {
	
	Workbook mWorkbook;
	
	FileInputStream mFileStream; 
	
	public ExcelReader(File uploadedTmpFile, String contentType)throws IOException{
		mFileStream = new FileInputStream(uploadedTmpFile);
		if(contentType.equalsIgnoreCase("application/vnd.ms-excel")){
			mWorkbook = new HSSFWorkbook(mFileStream);
		}
		else {
			mWorkbook = new XSSFWorkbook(mFileStream);
		}
	}

	public List<Article> getArticles(int categoryColumnIndex, int titleColumnIndex, int titleFuriganaColumnIndex, int bodyColumnIndex) {
		
		List<Article> articleList = new ArrayList<Article>();
		
		for (int i = 0 ; i < mWorkbook.getNumberOfSheets() ; i++) {
			Sheet sheet =  mWorkbook.getSheetAt(i);
			Article firstArticle = null;
				for (Row row : sheet) {
					Article article = getArticle(row, categoryColumnIndex, titleColumnIndex, titleFuriganaColumnIndex, bodyColumnIndex);
					if(firstArticle == null){
						// ignore firstArticle as it must be TITLE of rows
						firstArticle = article;
					}
					else if(article != null){
						articleList.add(article);
					}
				}
		}
		
		return articleList;
	}
	
	public void closeReader() throws IOException{
		mFileStream.close();
	}
	
	
	private String getStringCellValue(Cell cell){
		if(cell.getCellType() == Cell.CELL_TYPE_STRING){
			if(cell.getStringCellValue() != null){
				return cell.getStringCellValue();
			}
			else if(cell.getRichStringCellValue() != null)
				return cell.getRichStringCellValue().getString();
			else 
				return null;
		}
		else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			return Double.valueOf(cell.getNumericCellValue()).intValue()+"";
		}
		else {
			return null;
		}
	}
	
	
	private Long getNumericCellValue(Cell cell){
		try {
			if(cell.getCellType() == Cell.CELL_TYPE_STRING){
				return Long.parseLong(getStringCellValue(cell));
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				return (long)cell.getNumericCellValue();
			}
			else {
				return null;
			}
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	
	
	private Article getArticle(Row row, int categoryColumnIndex, int titleColumnIndex, int titleFuriganaColumnIndex, int bodyColumnIndex){
		Article article = null;

		Cell categoryCell = row.getCell(categoryColumnIndex);
		Cell titleCell = row.getCell(titleColumnIndex);
		Cell titleFuriganaCell = row.getCell(titleFuriganaColumnIndex);
		Cell bodyCell = row.getCell(bodyColumnIndex);
		
		if(categoryCell != null && titleCell != null && titleFuriganaCell != null && bodyCell != null){
			
			String categoryNameInputText = getStringCellValue(categoryCell);
			String title = getStringCellValue(titleCell);
			String titleFurigana = getStringCellValue(titleFuriganaCell);
			String body = getStringCellValue(bodyCell);
			
			if(StringUtils.isNotEmpty(categoryNameInputText) && 
				StringUtils.isNotEmpty(title) && 
					StringUtils.isNotEmpty(body)){
						article = new Article();
						article.setCategoryId(getNumericCellValue(categoryCell));
						article.setTitle(title);
						article.setTitleFurigana(titleFurigana);
						article.setBody(body);
			}
		}
		
		return article;
	}
	
	
	
}
