package ru.academits;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocalDriverTests {

    @Test
    public void openPageChromeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Psycholiric\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void openTestWithParameters() throws InterruptedException {
        WebDriver driver = null;

        String browser = System.getProperty("browser");
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Psycholiric\\Desktop\\chromedriver.exe");
             driver = new ChromeDriver();
//        } else if (browser.equals("edge")) {
//            запустить Firefox
        }
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.quit();



        }



    }



