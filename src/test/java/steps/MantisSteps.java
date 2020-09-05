package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dados;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import paginas.InicialPage;
import paginas.IssuePage;
import paginas.LoginPage;
import paginas.VisualizaIssue;
import paginas.VisualizaTodasIssues;

public class MantisSteps {
	
	private static WebDriver driver;
	private LoginPage loginPage = new LoginPage(driver);
	private InicialPage inicialPage = new InicialPage(driver);
	private IssuePage issuePage = new IssuePage(driver);
	private VisualizaTodasIssues visualizaTodasIssues = new VisualizaTodasIssues(driver);
	private VisualizaIssue visualizaIssue = new VisualizaIssue(driver);
	
	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiag\\OneDrive\\Documentos\\Driver\\Chrome\\85\\chromedriver_85.0.4183.87.exe");
		driver = new ChromeDriver();
	}
	
	@Dados("que faco o login com {string} e {string}")
	public void que_faco_o_login_com_e(String usuario, String senha) {
	    loginPage.carregarPagina();
	    loginPage.fazerLogin(usuario, senha);
	    assertEquals(inicialPage.verificaAcesso(), usuario);
	}

	@Quando("acesso o {string}")
	public void acesso_o(String projeto) {
	    inicialPage.selecionaProjeto(projeto);
	}

	@Entao("reporto uma issue com {string}, {string}, {string}, {string}, {string}, {string} e {string}. listo todas as issues por id, acessando a ultima issue lancada verifico se foi a lancada.")
	public void reporto_uma_issue_com_e_listo_todas_as_issues_por_id_acessando_a_ultima_issue_lancada_verifico_se_foi_a_lancada(String categoria, String reprodutibilidade, String severidade, String prioridade, String perfil, String resumo, String descricao) {
	    inicialPage.selecionaMenu("Report Issue");
	    issuePage.selecionaCategoria(categoria);
	    issuePage.selecionaReprodutibilidade(reprodutibilidade);
	    issuePage.selecionaSeveridade(severidade);
	    issuePage.selecionaPrioridade(prioridade);
	    issuePage.selecionaPerfil(perfil);
	    issuePage.escreverResumo(resumo);
	    issuePage.escreverDescricao(descricao);
	    issuePage.salvarIssue();
	    visualizaTodasIssues.verificaIssue();
	    assertEquals(visualizaIssue.verifica(), descricao);
	}

	@Entao("na issue lancada adiciona uma {string} e verifico a nota lancada")
	public void na_issue_lancada_adiciona_uma_e_verifico_a_nota_lancada(String nota) {
	    visualizaIssue.escrevendoNota(nota);
	    visualizaIssue.salvaNota();
	    assertEquals(visualizaIssue.verificaNotaLancada(), nota);
	}
	
	@After
	public static void finalizar() {
		driver.quit();
	}
}
