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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectTests {

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
        driver.get("http://htmlbook.ru/html/select");
        driver.manage().window().maximize();
    }

    @Test
    public void selectTest() throws InterruptedException {
        WebElement elementDropDown = driver.findElement(By.name("select2"));
        /*
    есть специальный класс Select - чтобы его создать сначала указываем локатор для этого элемента
       с помощью driver.findElement
       Потом передаем его в класс Select и говорим что из него надо сделать класс Select ↓
*/
        Select select = new Select(elementDropDown);

//        Тест  - проверим что по индексу 3 в списке будет отображаться Шапокляк
    select.selectByIndex(3);
//    выбираем третий пункт в списке

//        select.selectByVisibleText("Шапокляк");
//        Можно проверить по VisibleText - видимому тексту



        Assertions.assertEquals("Шапокляк", elementDropDown.getAttribute("value"));
//        ПРоверка равенства - что Шаполкляк соостветствует значению (value) атрибута элемента elementDropDown


        List<WebElement> allOptions = select.getOptions();
//        вытащить из селекта все опции - это getOptions
//        В List<> нужно указать список каких элементов хотим получить , в данном случае веб-элементов
//        WebElement. allOptions - это список со своими методами.

        allOptions.get(2).getText();
//    НУмерация в списках идет от нуля, поэтому берем 2, чтобы получить третье значение

















        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
