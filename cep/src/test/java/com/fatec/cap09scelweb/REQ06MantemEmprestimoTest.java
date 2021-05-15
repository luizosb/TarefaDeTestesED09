package cep;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import static org.junit.Assert.assertThat;

public class REQ06MantemEmprestimoTest {

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

    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    public void rEQ06CT01ValidarEmprestimoComISBNeRA() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.linkText("Livros")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
        driver.findElement(By.id("autor")).click();
        driver.findElement(By.id("autor")).sendKeys("Sri Prem Baba");
        driver.findElement(By.id("titulo")).click();
        driver.findElement(By.id("titulo")).sendKeys("Propósito");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Alunos")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("4321");
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Juliana");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("juliana@teste.com");
        driver.findElement(By.id("cep")).click();
        driver.findElement(By.id("cep")).sendKeys("03463030");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Voltar")).click();
        driver.findElement(By.linkText("Empréstimo")).click();
        driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3211");
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("4321");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
    }

    @Test
    public void rEQ06CT02RealizarApenasUmEmprestimoPorVez() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.linkText("Empréstimo")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("ra")).click();
        driver.findElement(By.id("ra")).sendKeys("4321");
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3213");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
        driver.findElement(By.cssSelector(".col-md-4")).click();
        driver.findElement(By.cssSelector(".col-md-4")).click();
        driver.findElement(By.id("isbn")).click();
        driver.findElement(By.id("isbn")).sendKeys("3212");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
    }

    @Test
    public void rEQ06CT03DevolverUmDiaComSucesso() {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1366, 728));
        driver.findElement(By.linkText("Empréstimo")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
        vars.put("win9334", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9334").toString());
        driver.findElement(By.cssSelector("tr:nth-child(9) .btn")).click();
        assertThat(driver.findElement(By.cssSelector("tr:nth-child(9) > td:nth-child(6)")).getText(), is("2021/04/26"));
    }

}
