package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuePage {
	
	private static WebDriver driver;
	private InicialPage inicialPage = new InicialPage(driver);
	
	private By categoriaLista = By.cssSelector("[name=category_id] option");
	private By reprodutibilidadeLista = By.cssSelector("[name=reproducibility] option");
	private By severidadeLista = By.cssSelector("[name=severity] option");
	private By prioridadeLista = By.cssSelector("[name=priority] option");
	private By perfilLista     = By.cssSelector("[name=profile_id] option");
	private By resumoCampo     = By.cssSelector(".row-2 [name=summary]");
	private By descricaoCampo  = By.cssSelector(".row-1 [name=description]");
	private By submitBtn       = By.cssSelector(".center .button");
	
	public IssuePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selecionaCategoria(String categoria) {
		if(inicialPage.transformaLista(categoriaLista).contains(categoria)) {
			for(int i = 0; i<=inicialPage.transformaLista(categoriaLista).size(); i++) {
				if(inicialPage.transformaLista(categoriaLista).get(i).equals(categoria)) {
					driver.findElements(categoriaLista).get(i).click();
					i=inicialPage.transformaLista(categoriaLista).size();
				}
			}
		} else {
			System.out.println("Não foi localizado a categoria: "+categoria);
		}
	}
	
	public void selecionaReprodutibilidade(String reprodutibilidade) {
		if(inicialPage.transformaLista(reprodutibilidadeLista).contains(reprodutibilidade)) {
			for(int i = 0; i<=inicialPage.transformaLista(reprodutibilidadeLista).size(); i++) {
				if(inicialPage.transformaLista(reprodutibilidadeLista).get(i).equals(reprodutibilidade)) {
					driver.findElements(reprodutibilidadeLista).get(i).click();
					i=inicialPage.transformaLista(reprodutibilidadeLista).size();
				}
			}
		} else {
			System.out.println("Não foi localizado a reprodutibilidade: "+reprodutibilidade);
		}
	}
	
	public void selecionaSeveridade(String severidade) {
		if(inicialPage.transformaLista(severidadeLista).contains(severidade)) {
			for(int i = 0; i<=inicialPage.transformaLista(severidadeLista).size(); i++) {
				if(inicialPage.transformaLista(severidadeLista).get(i).equals(severidade)) {
					driver.findElements(severidadeLista).get(i).click();
					i=inicialPage.transformaLista(severidadeLista).size();
				}
			}
		} else {
			System.out.println("Não foi localizado a severidade: "+severidade);
		}
	}
	
	public void selecionaPrioridade(String prioridade) {
		if(inicialPage.transformaLista(prioridadeLista).contains(prioridade)) {
			for(int i = 0; i<=inicialPage.transformaLista(prioridadeLista).size(); i++) {
				if(inicialPage.transformaLista(prioridadeLista).get(i).equals(prioridade)) {
					driver.findElements(prioridadeLista).get(i).click();
					i=inicialPage.transformaLista(prioridadeLista).size();
				}
			}
		} else {
			System.out.println("Não foi localizado a prioridade: "+prioridade);
		}
	}
	
	public void selecionaPerfil(String perfil) {
		if(inicialPage.transformaLista(perfilLista).contains(perfil)) {
			for(int i = 0; i<=inicialPage.transformaLista(perfilLista).size(); i++) {
				if(inicialPage.transformaLista(perfilLista).get(i).equals(perfil)) {
					driver.findElements(perfilLista).get(i).click();
					i=inicialPage.transformaLista(perfilLista).size();
				}
			}
		} else {
			System.out.println("Não foi localizado o perfil: "+perfil);
		}
	}

	public void escreverResumo(String resumo) {
		driver.findElement(resumoCampo).sendKeys(resumo);
	}
	
	public void escreverDescricao(String descricao) {
		driver.findElement(descricaoCampo).sendKeys(descricao);
	}
	
	public VisualizaTodasIssues salvarIssue() {
		driver.findElement(submitBtn).submit();
		return new VisualizaTodasIssues(driver);
	}
}
