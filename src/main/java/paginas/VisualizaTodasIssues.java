package paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class VisualizaTodasIssues {
	
	private static WebDriver driver;
	
	private By ordenarPorId = By.cssSelector("tbody .row-category td:nth-child(4)");
	private By primeiroLista = By.cssSelector("#buglist tbody tr:nth-child(4) td:nth-child(4) a");
	
	public VisualizaTodasIssues(WebDriver driver) {
		this.driver = driver;
	}
	
	public VisualizaIssue verificaIssue() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ordenarPorId));
		
		driver.findElement(ordenarPorId).click();
		driver.findElement(primeiroLista).click();
		
		return new VisualizaIssue(driver);
	}

}
