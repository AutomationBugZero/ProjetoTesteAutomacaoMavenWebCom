/**
 * 
 */
package br.com.rubens.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rubens.interfaces.ISeleniumUtils;

/**
 * @author guilherme.cutovoi
 *
 *
 * Esta pagina contem a lista dos clientes cadastrados 
 *
 */
public class ListaCadastroClientePageTest implements ISeleniumUtils {

	WebDriver driver;
	
	By buttonAdicionaCliente=By.xpath("html/body/div[1]/div/a/input");
	
	public ListaCadastroClientePageTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void ClicaButtonAdicionarCliente()
	{
		driver.findElement(buttonAdicionaCliente).click();
	}
	
	
}
