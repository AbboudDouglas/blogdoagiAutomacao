package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver navegador;

    public HomePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public HomePage clicarNaLupaDePesquisa(){
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/form/label/input")).click();
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/form/label/input")).sendKeys("Douglas Abboud");
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/form/input")).click();

        return this;
    }

    public HomePage validarRetornoDaPesquisa(){
        String mensagemId = navegador.findElement(By.xpath("//*[@id=\"primary\"]/section/div")).getText();
        Assertions.assertEquals("Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes."  , mensagemId);

        return this;
    }

}
