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
    public void inputFirstNameTest() throws InterruptedException {

        WebElement inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys("John");
        Assertions.assertEquals("John" , inputFirstName.getAttribute("value"));

        WebElement inputLastName = driver.findElement(By.id("lastName"));
        inputLastName.sendKeys("Smith");
        Assertions.assertEquals("Smith" , inputLastName.getAttribute("value"));

        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("input@test.com");
        Assertions.assertEquals("input@test.com" , inputEmail.getAttribute("value"));

        WebElement radioButton = driver.findElement(By.cssSelector("#genterWrapper"));
        radioButton.click();
        Assertions.assertFalse(false , radioButton.getAttribute("checked"));

        WebElement inputUserNumber = driver.findElement(By.id("userNumber"));
        inputUserNumber.sendKeys("8800555353");
        Assertions.assertEquals("8800555353" , inputUserNumber.getAttribute("value"));

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();
        WebElement year = driver.findElement(By.xpath("//*[text()='1944']"));
        year.click();
        WebElement month = driver.findElement(By.xpath("//*[text()='August']"));
        month.click();
        WebElement day = driver.findElement(By.xpath("//*[text()='28']"));
        day.click();
        Assertions.assertEquals("28 Aug 1944" , dateOfBirth.getAttribute("value"));


//        WebElement inputSubjects = driver.findElement(By.id("subjectsContainer"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", inputSubjects);
//        inputSubjects.click();
//        inputSubjects.sendKeys("Subject");
//        inputSubjects.sendKeys(Keys.ENTER);
//        скрипт , ошибка element not interactable





        WebElement checkbox = driver.findElement(By.xpath("//*[text()='Sports']"));
        checkbox.click();
        Assertions.assertTrue(true , checkbox.getAttribute("checked"));

//        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
//        uploadPicture.click();
//        uploadPicture.sendKeys("ru/academits/Снимок экрана 2022-02-20 191113.jpg");
//        uploadPicture


        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Москва");
        Assertions.assertEquals("Москва" , currentAddress.getAttribute("value"));


//        WebElement selectState = driver.findElement(By.id("state"));
//        selectState.click();
//        driver.findElement(By.xpath("//*[text()='Uttar Pradesh']")).click();

//        WebElement selectCity = driver.findElement(By.id("city"));
//        selectCity.click();
//        driver.findElement(By.xpath("//*[text()='Agra']")).click();


        Thread.sleep(5000);




    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
