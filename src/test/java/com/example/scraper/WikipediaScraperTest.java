package com.example.scraper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertNotNull;

public class WikipediaScraperTest {
    private WebDriver driver;
    private WikipediaScraper scraper;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Add headless mode
        driver = new ChromeDriver(options);
        scraper = new WikipediaScraper(driver);  // Pass the WebDriver instance to the scraper
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testGetViratKohliDetails() {
        String details = scraper.getViratKohliDetails();
        assertNotNull("Details should not be null", details);
    }
}
