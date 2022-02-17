package ru.academits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocalDriverTests {

    public void openPageChromeTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\a.muzhanovskiy\\Desktop chromedriver.exe ");
        WebDriver webDriver = new ChromeDriver();
    }
}
