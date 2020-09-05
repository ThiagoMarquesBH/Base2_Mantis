package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private static WebDriver driver;
	
	private By usuarioCampo = By.name("username");
	private By senhaCampo   = By.name("password");
	private By loginBtn     = By.cssSelector(".center .button");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void carregarPagina() {
		driver.manage().window().maximize();
		driver.get("https://mantis-prova.base2.com.br/");
	}

	public InicialPage fazerLogin(String usuario, String senha) {
		driver.findElement(usuarioCampo).sendKeys(usuario);
		driver.findElement(senhaCampo).sendKeys(senha);
		driver.findElement(loginBtn).click();
		return new InicialPage(driver);
	}
}
