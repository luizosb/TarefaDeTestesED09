// Generated by Selenium IDE
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class REQ03CT03ValidarCadastrarAlunoDeixarNomeBranco<JavascriptExecutor, WebDriver> {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void rEQ03CT03ValidarCadastrarAlunoDeixarNomeBranco() {
    driver.get("https://ts-scel.herokuapp.com/");
    driver.manage().window().setSize(new Dimension(550, 692));
    driver.findElement(By.linkText("Alunos")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1114");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("luiz@fatec.com");
    driver.findElement(By.id("email")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("email")).sendKeys(Keys.TAB);
    driver.findElement(By.id("cep")).sendKeys("03554070");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
  }
}