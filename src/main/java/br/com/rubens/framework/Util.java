package br.com.rubens.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;


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
	/**
	 * Aguarda por texto de um elemento web e compara para validar se está certo, caso contrario falha o teste
	 * 
	 * @author Rubens Lobo
	 * @param     
	 *            <b>WebDriver</b> - utilizado para reconhecer a estancia de drive utilizado no teste.
	 *            <p>
	 *            <b>textToAppear</b> - String utilizada para passar um texto para comparar com valor do elemento web
	 *            <p>
	 *            <b>element</b> - Elemento Web utilizado para comparar as strings
	 *            <p>
	 *            <b>timeOut</b> - Valor de time-Out para para validação
	 *            <p>
	 * 
	 */
	public void waitForTextToAppear(WebDriver newDriver, String textToAppear, WebElement element,int timeOut, String pathEvidencia) 
	{
		try{
			WebDriverWait wait = new WebDriverWait(newDriver,timeOut);
			wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));}
		catch(Exception e){
			takeScreenshot(newDriver,pathEvidencia);
			Assert.fail();
		}
	}
	/**
	 * Aguarda por um objeto da pagina web, caso não seja apresentado o teste falha.
	 * 
	 * @author Rubens Lobo
	 * @param     
	 *            <b>WebDriver</b> - utilizado para reconhecer a estancia de drive utilizado no teste.
	 *            <p>
	 *            <b>by</b> - objeto que representa um elemento web de uma pagina HTML
	 *            <p>
	 * 			  <b>timeOut</b> - Valor de time-Out para para validação
	 *            <p>
	 */
	public void waitForElement(WebDriver newDriver, By by, int timeOut, String pathEvidencia) 
	{
		try{
			WebDriverWait wait = new WebDriverWait(newDriver,timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
	   catch(Exception e){
		   takeScreenshot(newDriver,pathEvidencia);
			Assert.fail();
	   }
	}
	 /**
     * Método para capturar screenshot
     * @param fileName - Nome do arquivo
     */
    public void takeScreenshot(WebDriver newDriver, String fileName){
    	 File scrFile = ((TakesScreenshot)newDriver).getScreenshotAs(OutputType.FILE);
         Date data = new Date();
         try {
             FileUtils.copyFile(scrFile, new File(fileName+ data.getTime()+".jpg"),false);
         } catch (IOException e) {
             e.printStackTrace();
         } 
    }
	
}
