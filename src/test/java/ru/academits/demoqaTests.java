package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class demoqaTests {

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
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Tests() throws InterruptedException {

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("John");
        Assertions.assertEquals("John" , firstNameInput.getAttribute("value"));

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Smith");
        Assertions.assertEquals("Smith" , lastNameInput.getAttribute("value"));

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("input@test.com");
        Assertions.assertEquals("input@test.com" , emailInput.getAttribute("value"));

        WebElement radioButton = driver.findElement(By.cssSelector("#genterWrapper"));
        radioButton.click();
        Assertions.assertFalse(false , radioButton.getAttribute("checked"));

        WebElement userNumberInput = driver.findElement(By.id("userNumber"));
        userNumberInput.sendKeys("8800555353");
        Assertions.assertEquals("8800555353" , userNumberInput.getAttribute("value"));

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();
        WebElement yearOfBirth = driver.findElement(By.xpath("//*[text()='1944']"));
        yearOfBirth.click();
        WebElement monthOfBirth = driver.findElement(By.xpath("//*[text()='August']"));
        monthOfBirth.click();
        WebElement dayOfBirth = driver.findElement(By.xpath("//*[text()='28']"));
        dayOfBirth.click();
        Assertions.assertEquals("28 Aug 1944" , dateOfBirth.getAttribute("value"));


        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subjectsInput);
        subjectsInput.click();
        subjectsInput.sendKeys("h");
        subjectsInput.sendKeys(Keys.ENTER);


        WebElement checkbox = driver.findElement(By.xpath("//*[text()='Sports']"));
        checkbox.click();
        Assertions.assertTrue(true , checkbox.getAttribute("checked"));

        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        uploadPicture.sendKeys("C:/Users/a.muzhanovskiy/IdeaProjects/selenium-tests1/src/test/java/ru/academits/Снимок экрана 2022-02-20 191113.jpg");


//        File file = new File("src/test/java/ru/academits/Снимок экрана 2022-02-20 191113.jpg");
//        System.out.println("path is " + file.getAbsolutePath());
//       C:\Users\a.muzhanovskiy\IdeaProjects\selenium-tests1\src\test\java\ru\academits\Снимок экрана 2022-02-20 191113.jpg


        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Москва, Тверская, 8");
        Assertions.assertEquals("Москва, Тверская, 8" , currentAddress.getAttribute("value"));

        WebElement stateDropdown = driver.findElement(By.id("state"));
        stateDropdown.click();
        driver.switchTo().activeElement().sendKeys("Uttar Pradesh");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        driver.switchTo().activeElement().sendKeys("Merrut");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();



        WebElement EmailAssert = driver.findElement(By.cssSelector("tbody>tr:nth-child(2)>td:nth-child(2)"));
        System.out.println("text " + EmailAssert.getAttribute("value"));
        Assertions.assertEquals("input@test.com" , EmailAssert.getAttribute("value"));















        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
