import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiTests {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop= 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(DelfiTests.class);

    @Test
    public void firstDelfiTest() {
        LOGGER.info("This test will check accept cookie btn");

        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");// set parameter -  key, path (system (only one) - static object)

        LOGGER.info("Opening browser window");
        WebDriver driver = new ChromeDriver(); // run Chrome (WebDriver - object, which responds to work with browser window)

        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();

        LOGGER.info("Open Delfi page");
        driver.get("http://delfi.lv"); // lead to link (get)

        LOGGER.info("Waiting for accept cookies modal window");
        WebDriverWait wait = new WebDriverWait(driver, 10); // max time wait, after that fail test
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN)); // until button will be visible

        LOGGER.info("Pressing Accept btn");
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();
    }

    @Test
    public void tvnetTest() {
        String articleToOpen = "Seskam Moncas rallijs beidzas drošības barjerās";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(ARTICLE_TITLE); // find all articles

  /*      for (int i = 0; i < articles.size(); i = i + 1) {
            String currentTitle = articles.get(i).getText();
            if (currentTitle.startsWith(articleToOpen)) {
                articles.get(i).click();
                break;
            }
//            System.out.println(i + ". " + articles.get(i).getText()); // need for print out name of all articles
        } */
        //------------------------------------------foreach--------------------------------------------------------
        for (WebElement we : articles) {
            if (we.getText().startsWith(articleToOpen)) {
                we.click();
                break;
            }

            //  System.out.println(we.getText());
        }
    }
}
