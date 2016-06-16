package br.com.rubens.interfaces;

import org.openqa.selenium.WebDriver;
import br.com.rubens.framework.SeleniumUtils;


public interface ISeleniumUtils {
	public final boolean isProductionEnvironment = true;
	
	public final int browserNumber = 1;
	public static int WAIT_ELEMENT_LOAD_SECONDS = 10;
	
	public final String email = "qa01@rubens.com.br";
	public final String passWord = "123456";
	
	
	public final String url = new SeleniumUtils().Url(isProductionEnvironment);
	
	public final WebDriver driver = new  SeleniumUtils().setUpDriver(browserNumber, 30, WAIT_ELEMENT_LOAD_SECONDS);
		
}
