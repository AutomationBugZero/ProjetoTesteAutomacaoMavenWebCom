package br.com.rubens.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CadastroClientePageTest {
	
	WebDriver driver;
	
	By TextBoxNome =By.id("nome");
	By TextBoxCPF =By.id("cpf");
	By TextBoxRG =By.id("rg");
	By TextBoxEndereco = By.id("endereco");
	By TextBoxBairro = By.id("bairro");
	By TextBoxCidade = By.id("cidade");
	By TextBoxEstado = By.id("estado");
	By TextBoxTelefone = By.id("telefone");
	By TextBoxEmail = By.id("email");
	By TextBoxObservacao = By.id("observacao");
	By ButtonSalvar = By.xpath(".//*[@id='cliente']/input");
	
	public CadastroClientePageTest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void TypeNome(String Nome)
	{
		driver.findElement(TextBoxNome).sendKeys(Nome);
	}
	public void TypeCpf(String Cpf)
	{
		driver.findElement(TextBoxCPF).clear();
		driver.findElement(TextBoxCPF).sendKeys(Cpf);
		driver.findElement(TextBoxCPF).sendKeys(Keys.TAB);
	
	}
	public void TypeRg(String Rg)
	{
		driver.findElement(TextBoxRG).clear();
		driver.findElement(TextBoxRG).sendKeys(Rg);
	}
	public void TypeEndereco(String Endereco)
	{
		driver.findElement(TextBoxEndereco).sendKeys(Endereco);
	}
	public void TypeBairro(String Bairro)
	{
		driver.findElement(TextBoxBairro).sendKeys(Bairro);
	}
	public void TypeCidade(String Cidade)
	{
		driver.findElement(TextBoxCidade).sendKeys(Cidade);
	}
	public void TypeTelefone(String Telefone)
	{
		driver.findElement(TextBoxTelefone).clear();
		driver.findElement(TextBoxTelefone).sendKeys(Telefone);
	}
	public void TypeEstado(String Estado)
	{
		driver.findElement(TextBoxEstado).sendKeys(Estado);
	}
	public void TypeEmail(String Email)
	{
		driver.findElement(TextBoxEmail).sendKeys(Email);
	}
	public void TypeObservacao(String Observacao)
	{
		driver.findElement(TextBoxObservacao).sendKeys(Observacao);
	}
	public void ClickButtonSalvar()
	{
		driver.findElement(ButtonSalvar).click();
	}
	public void EfetuarCadastroCliente(String Nome, String Cpf, String Rg, String Endereco, String Bairro, String Cidade, String Estado, String Telefone, String Email, String Observacao) throws InterruptedException
	{
		
		MenuPrincipalPageTest MenuPrincipal=new MenuPrincipalPageTest(driver);
		
		TypeNome(Nome);
		Thread.sleep(1000);
		TypeCpf(Cpf);
		Thread.sleep(1000);
		TypeRg(Rg);
		Thread.sleep(1000);
		TypeEndereco(Endereco);
		Thread.sleep(1000);
		TypeBairro(Bairro);
		Thread.sleep(1000);
		TypeCidade(Cidade);
		Thread.sleep(1000);
		TypeEstado(Estado);
		Thread.sleep(1000);
		TypeTelefone(Telefone);
		Thread.sleep(2000);
		TypeEmail(Email);
		Thread.sleep(1000);
		TypeObservacao(Observacao);
		Thread.sleep(1000);
		ClickButtonSalvar();
		
		MenuPrincipal.ValidaAcessoCadastroCliente();
	}
}
