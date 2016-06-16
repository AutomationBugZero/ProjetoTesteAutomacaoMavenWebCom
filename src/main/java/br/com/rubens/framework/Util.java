package br.com.rubens.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util {
	
	HSSFWorkbook workBook;
	HSSFSheet sheet;
	
	public void DataTableConfig(String PathXls) throws IOException {
		
		FileInputStream excel = new FileInputStream(new File(PathXls));			
		workBook = new HSSFWorkbook(excel);			
		sheet = workBook.getSheetAt(0);
	}
	
	public String[] GetDataTable(String PathDataTable, int colunas) throws IOException{
		
		String Dados[] = new String[colunas];	
		DataTableConfig(PathDataTable);
		for (int i = 0; i < colunas;i++){
			Dados[i] = sheet.getRow(1).getCell(i).getStringCellValue();
		}	
		return Dados;
	}
	
	public void killProcess(String processo) {  
        try {  
            String line;  
            Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");  
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            while ((line = input.readLine()) != null) {  
                if (!line.trim().equals("")) {  
                    if (line.substring(1, line.indexOf("\"", 1)).equalsIgnoreCase(processo)) {  
                        Runtime.getRuntime().exec("taskkill /F /IM " + line.substring(1, line.indexOf("\"", 1)));   
                    }  
                }  
            }  
            input.close();  
        } catch (Exception err) {  
            err.printStackTrace();  
        }   
    }  
	
}
