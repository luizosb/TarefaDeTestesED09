package com.fatec.cap09scelweb;

// Generated by Selenium IDE
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class REQ03CT01ValidarTelaCadastrarTodosCamposCorretamentePreenchidos<WebDriver, JavascriptExecutor> {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = (WebDriver) new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    ((org.openqa.selenium.WebDriver) driver).quit();
  }
  @Test
  public void rEQ03CT01ValidarTelaCadastrarTodosCamposCorretamentePreenchidos() {
    ((org.openqa.selenium.WebDriver) driver).get("https://ts-scel.herokuapp.com/");
    ((org.openqa.selenium.WebDriver) driver).manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1115");
    driver.findElement(By.id("nome")).sendKeys("Luiz OTavio");
    driver.findElement(By.id("email")).sendKeys("luiz@fatec.com");
    driver.findElement(By.id("cep")).sendKeys("03554070");
    driver.findElement(By.cssSelector(".row:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    driver.findElement(By.linkText("Alunos")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1113");
    driver.findElement(By.id("nome")).sendKeys("Luiz Otávio");
    driver.findElement(By.id("email")).sendKeys("luiz@fatec.com");
    driver.findElement(By.id("cep")).sendKeys("03554070");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
  }
}
