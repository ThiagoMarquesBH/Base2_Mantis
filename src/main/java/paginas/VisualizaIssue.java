package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisualizaIssue {
	
	private static WebDriver driver;
	private By issueCriada = By.xpath("/html/body/table[3]/tbody/tr[12]/td[2]");
	private By notaCampo   = By.cssSelector("tbody [name=bugnote_text]");
	private By salvarNota  = By.cssSelector("#bugnote_add_open .center .button");
	private By verificaNota = By.cssSelector("#bugnotes_open tbody .bugnote-note-public");
	
	public VisualizaIssue(WebDriver driver) {
		this.driver = driver;
	}
	
	public String verifica() {
		return driver.findElement(issueCriada).getText();
	}
	
	public void escrevendoNota(String nota) {
		driver.findElement(notaCampo).sendKeys(nota);
	}
	
	public void salvaNota() {
		driver.findElement(salvarNota).submit();
	}
	
	public String verificaNotaLancada() {
		return driver.findElement(verificaNota).getText();
	}

}
