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

public class REQ02MantemLivrosTest {

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
    public void rEQ02CT01CadastroLivroInvalidoDuplicado() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Propósito");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".text-danger")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Livro ja cadastrado"));
    }

    @Test
    public void rEQ02CT02CadastroLivroInvalidoISBN3Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("321");
        driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Uncle Bob");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Code");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Clean");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("ISBN deve ter 4 caracteres"));
    }

    @Test
    public void rEQ02CT03CadastroLivroInvalidoISBN5Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.cssSelector(".col-md-4")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("32112");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Uncle Bob");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Clean Clean");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("ISBN deve ter 4 caracteres"));
    }

    @Test
    public void rEQ02CT04TituloInvalidoAcimaDe51Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3214");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("BBBB");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("Autor deve ter entre 1 e 50 caracteres"));
    }

    @Test
    public void rEQ02CT05AutorInvalidoAcimaDe51Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3215");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("Titulo deve ter entre 1 e 50 caracteres"));
    }

    @Test
    public void rEQ02CT06TituloInvalidoCom0Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3215");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.cssSelector(".row:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("Titulo deve ter entre 1 e 50 caracteres"));
        driver.close();
    }

    @Test
    public void rEQ02CT07AutorInvalidoCom0Caracteres() {
        driver.get("https://ts-scel.herokuapp.com/sig/livro");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3215");
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Propósito");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(), is("Autor deve ter entre 1 e 50 caracteres"));
    }

}
