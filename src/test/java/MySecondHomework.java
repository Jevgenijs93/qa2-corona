import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MySecondHomework {
    private final By ACCEPT_COOKIE_BTN = By.xpath("//button[@class = 'notification__button']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");

    @Test
    public void tvnetTest() throws InterruptedException {
        String articleToOpen = "Seskam Moncas rallijs beidzas drošības barjerās";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        // 1. click on random article and go to comments page

        WebElement articleTitle = driver.findElement(ARTICLE_TITLE);
        articleTitle.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_BTN));

        WebElement commentButton = driver.findElement(COMMENT_BTN);
        commentButton.click();

        Thread.sleep(1000);

        // 2. Click on specific article by count

        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(ARTICLE_TITLE);
        articles.get(2).click();

        Thread.sleep(1000);

        // 3. Click on specific article by article name


        driver.get("http://tvnet.lv");

        List<WebElement> articlesList = driver.findElements(ARTICLE_TITLE);

        for (WebElement we : articlesList) {
            if (we.getText().startsWith(articleToOpen)) {
                we.click();
                break;
            }


        }

    }

}

