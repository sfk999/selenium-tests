package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AcademItTests {

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
        driver.get("https://academ-it-school.ru/payment?course=java_begin");
        driver.manage().window().maximize();
    }

    @Test
    public void radioButtonTEst() throws InterruptedException {
        WebElement testingRadioButton = driver.findElement(By.cssSelector("input[name='CourseType'][value=\"Testing\"]"));
//       Сохраним как переменную элемент-радиобаттон "Тестирование" на странице, найти элемент-радиобаттон по селектору

        WebElement programmingRadioButton = driver.findElement(By.cssSelector("input[name='CourseType'][value=\"Programming\"]"));
//       Сохраним как переменную элемент-радиобаттон "ПРограммирование" на странице, найти элемент-радиобаттон по селектору


        testingRadioButton.click();
//        потом кликнем на  элемент-радиобаттон "Тестирование
        Assertions.assertTrue(true , testingRadioButton.getAttribute("checked"));
//        проверяем true - что аттрибут радиобаттона Тестирование checked нажат (возвращает значение true)

        //        System.out.println("Programming STATUS = " + programmingRadioButton.isSelected());
//        Чтобы узнать значение когда элемент не выбран выведем значение метода isSelected
//        - "выбран данный элемент или нет?" - выводит false ,можем использовать этот
//        false для проверки Assertions.assertFalse

        Assertions.assertFalse(false , programmingRadioButton.getAttribute("checked"));
//        проверяем false - что аттрибут радиобаттона "ПРограммирование" checked НЕ нажат (возвращает значение false)



        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
