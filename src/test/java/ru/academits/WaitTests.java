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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitTests {

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
        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      устанавливаем (manage) для драйвера метод timeouts и в нем есть implicitlyWait -
//        метод для НЕЯВНОГО ожидания. TimeUnit.SECONDS -указываем единицы измерения, 10 - количество
//        секунд в данном случае. Если страница долго грузится - тест будет ждать
    }

    @Test
    public void S7ExplicitTestWait() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10, 500);
//       Создаем отдельный класс WebDriverWait и в нем (наш драйвер, макс время ожидания,
//       время, через которое он пробует загрузить элемент)

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("comments-block-wrapper")));
//        wait.until - ждем пока (ExpectedConditions - ожидаемое условие
//        presenceOfElementLocated - наличие элемента. Нужный элемент указываем ↓
//        локатор по имени класса  By.className("comments-block-wrapper")

        WebElement nameInput = driver.findElement(By.id("author"));
//      Присваиваем имя  nameInput какому то элементу с указанным локатором
        nameInput.sendKeys("name");
//        вводим (sendKeys) значение name в поле элемента nameInput
        Assertions.assertEquals("name", nameInput.getAttribute("value"));
//        ПРоверяем что value стало name


        Thread.sleep(2000);
    }

    @Test
    public void S7WithoutWait() throws InterruptedException {
        WebElement nameInput = driver.findElement(By.id("author"));
        nameInput.sendKeys("name");
        Assertions.assertEquals("name", nameInput.getAttribute("value"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
