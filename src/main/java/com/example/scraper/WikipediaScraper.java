package com.example.scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WikipediaScraper {
    private WebDriver driver;

    // No-argument constructor
    public WikipediaScraper() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
    }

    // Constructor that accepts a WebDriver instance
    public WikipediaScraper(WebDriver driver) {
        this.driver = driver;
    }

    public String getViratKohliDetails() {
        driver.get("https://en.wikipedia.org/wiki/Virat_Kohli");

        WebElement content = driver.findElement(By.id("bodyContent"));
        List<WebElement> paragraphs = content.findElements(By.tagName("p"));

        StringBuilder details = new StringBuilder();
        for (WebElement paragraph : paragraphs) {
            details.append(paragraph.getText()).append("\n");
        }

        return details.toString();
    }

    public static void main(String[] args) {
        WikipediaScraper scraper = new WikipediaScraper();
        System.out.println(scraper.getViratKohliDetails());

        scraper.driver.quit();
    }
}
