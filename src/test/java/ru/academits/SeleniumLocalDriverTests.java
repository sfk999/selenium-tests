package ru.academits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;

public class SeleniumLocalDriverTests {

    public void openPageChromeTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\a.muzhanovskiy\\Desktop chromedriver.exe ");
        WebDriver driver = new ChromeDriver();






    }

    public void getYear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year);
    }
}
