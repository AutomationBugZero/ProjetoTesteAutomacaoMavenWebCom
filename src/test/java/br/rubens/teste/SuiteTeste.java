package br.rubens.teste;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import br.com.rubens.interfaces.ISeleniumUtils;

public class SuiteTeste implements ISeleniumUtils{

	public WebDriver webDriver = driver;
	
	@BeforeSuite(groups="domain")
	public void setUp(){
		this.webDriver = driver;
	}
	
	@AfterSuite(groups="domain")
	public void TearDow(){
		this.webDriver.quit();	
	}
}