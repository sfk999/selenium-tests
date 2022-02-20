package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HerokuTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
        }
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void checkCurrentUrl() throws InterruptedException {
        Assertions.assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Test
    public void checkTitle() throws InterruptedException {
        Assertions.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void autenticationTest() throws InterruptedException {

        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("radius")).click();

        WebElement successfulLoginMessageLabel = driver.findElement(By.id("flash"));
        String successLoginMessage = successfulLoginMessageLabel.getText();


        Thread.sleep(2000);
        Assertions.assertTrue(successfulLoginMessageLabel.isDisplayed());
        //        используем true т.к. driver.findElement(By.id("flash")).isDisplayed(); спрашивает виден или нет элемент
//        возвращает boolean
//        проверяет что элемент с id = flash виден на странице


        Assertions.assertTrue(successLoginMessage.contains("You logged into a secure area!"));

        System.out.println("Location x = " + successfulLoginMessageLabel.getLocation().getX());
        System.out.println("Location y = " + successfulLoginMessageLabel.getLocation().getY());
//        выведем в консоль нахождение центральных точек X u Y элемента successfulLoginMessageLabel

        driver.findElement(By.id("username")).sendKeys(Keys.ESCAPE);
//      имитируем нажатие какой либо кнопки в элементе с id "username" с помощью .sendKeys(Keys.ESCAPE),
//      в данном случае Esc. Удобно закрывать открытый dropdown


        driver.findElement(By.cssSelector(".example")).findElement(By.cssSelector("h2"));
//      переход к вложенному элементу .example h2
//        можно сохранить весь запрос в переменную с помощью WebElement, как например
//        WebElement successfulLoginMessageLabel = driver.findElement(By.id("flash"));
//        и дальше искать уже путь от переменной


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
