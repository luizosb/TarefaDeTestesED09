package cep;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class REQ01MantemLivrosTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void rEQ01CT01CadastroDeLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1382, 744));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Propósito");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    }

    @Test
    public void rEQ01CT02ConsultaLivrosComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3212");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Uncle Bob");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Code");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Lista de Livros")).click();
        assertThat(driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(3)")).getText(), is("Clean Code"));
    }

    @Test
    public void rEQ01CT03EditarLivrosComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3213");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Uncle Bob");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Architecture");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.cssSelector("tr:nth-child(6) .btn-primary")).click();
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Architecture 2");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector(".panel-body")).click();
        assertThat(driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(3)")).getText(), is("Clean Architecture 2"));
    }

    @Test
    public void rEQ01CT04ExluirLivroComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Propósito");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.cssSelector("tr:nth-child(6) .delete")).click();
    }

}
