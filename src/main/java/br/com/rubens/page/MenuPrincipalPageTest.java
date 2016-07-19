/**
 * 
 */
package br.com.rubens.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import br.com.rubens.interfaces.ISeleniumUtils;

/**
 * @author guilherme.cutovoi
 *
 * Esta classe carrega as caracteristicas da pagina Menu Principal
 *
 */
public class MenuPrincipalPageTest implements ISeleniumUtils {
	
	WebDriver driver;
	
	By linkSair=By.xpath(".//*[@id='bemvindo']/a");
	By buttonMenuCadastro=By.className("caret");
	By buttonCadastroCliente=By.xpath(".//*[@id='navbar-1']/ul[1]/li[2]/ul/li[1]/a");
	By tagCadCliente=By.xpath("html/body/div[1]/div/h1");
		
	public void ClicaButtonMenuCadastro()
	{
		driver.findElement(buttonMenuCadastro).click();
	}
	public void ClicaButtonCadastro()
	{
		driver.findElement(buttonCadastroCliente).click();
	}
	public void ValidaAcessoCadastroCliente() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(tagCadCliente).getText().contains("Cadastro"));
	}
	public void NavegarMenuPrincipalCadastroCliente() throws InterruptedException
	{
		ClicaButtonMenuCadastro();
		ClicaButtonCadastro();
		ValidaAcessoCadastroCliente();
	}
	
}
