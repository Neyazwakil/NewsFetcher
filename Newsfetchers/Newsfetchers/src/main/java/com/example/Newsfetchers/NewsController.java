package com.example.Newsfetchers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/search")
    public List<Map<String, String>> getNewsUrls(@RequestParam String query) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://news.google.com");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frameId")));


        WebElement searchBox = driver.findElement(By.id("elementInsideFrame"));
        searchBox.click();


        driver.switchTo().defaultContent();



        searchBox.sendKeys(query);
        searchBox.submit();


        List<WebElement> articles = driver.findElements(By.cssSelector("a[href^='https']"));
        List<Map<String, String>> articleUrls = new ArrayList<>();

        for (WebElement article : articles) {
            String url = article.getAttribute("href");
            if (!url.contains("google.com")) {
                Map<String, String> articleData = new HashMap<>();
                articleData.put("url", url);
                articleUrls.add(articleData);
            }
        }

        driver.quit();


        return articleUrls;
    }
}
