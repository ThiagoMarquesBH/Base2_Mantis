package paginas;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InicialPage {

	private static WebDriver driver;

	private By usuarioLogado = By.cssSelector(".login-info-left .italic");
	private By projetosManti = By.cssSelector(".login-info-right .small option");
	private By menuInicial   = By.cssSelector("tbody .menu a");
	List<WebElement> recebeWeb = new ArrayList();

	public InicialPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verificaAcesso() {
		return driver.findElement(usuarioLogado).getText();
	}

	public List<String> transformaLista(By lista) {
		recebeWeb = driver.findElements(lista);
		List<String> listaString = new ArrayList();
		for (WebElement elem : recebeWeb) {
			listaString.add(elem.getText());
		}
		
		return listaString;
	}
	
	public void selecionaProjeto(String projeto) {
		if(this.transformaLista(projetosManti).contains(projeto)) {
			for(int i = 0; i<=this.transformaLista(projetosManti).size(); i++) {
				if(this.transformaLista(projetosManti).get(i).equals(projeto)) {
					driver.findElements(projetosManti).get(i).click();
					i=this.transformaLista(projetosManti).size();
				}
			}
		} else {
			System.out.println("Não foi localizado o projeto: "+projeto);
		}
	}
	
	public IssuePage selecionaMenu(String menu) {
		if(this.transformaLista(menuInicial).contains(menu)) {
			for(int i = 0; i<=this.transformaLista(menuInicial).size(); i++) {
				if(this.transformaLista(menuInicial).get(i).equals(menu)) {
					driver.findElements(menuInicial).get(i).click();
					i=this.transformaLista(menuInicial).size();
				}
			}
		} else {
			System.out.println("Não foi localizado o menu: "+menu);
		}
		return new IssuePage(driver);
	}
}
