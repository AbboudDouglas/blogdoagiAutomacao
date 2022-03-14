package Blog;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

@DisplayName("Teste Web da Validacao de Pesquisa")
public class ValidarPesquisaTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o Navegador
       // System.setProperty("webdriver.chrome.driver", "blogdoagiAutomacao\chromedrive");
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver98\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizando a tela
        this.navegador.manage().window().maximize();

        //Definindo um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a Home Page
        this.navegador.get("https://www.blogdoagi.com.br");
    }

    @Test
    @DisplayName("Preenchendo o campo de Pesquisa e validando o resultado retornado")
    public void testPesquisaCampo(){


        new HomePage(navegador)
                .clicarNaLupaDePesquisa()
                .validarRetornoDaPesquisa();

    }

    @AfterEach
    public void afterEach(){
        //Fechando o Browser
        //navegador.quit();
    }
}
