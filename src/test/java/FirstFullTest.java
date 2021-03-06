import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstFullTest {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    @Test
    public void titleAndCommentsCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        // Find 3rd article
        WebElement currentArticle = driver.findElements(ARTICLE).get(2);

        // Find and save title
        String titleToCompare = currentArticle.findElement(TITLE).getText();

        // Find and save comments count
        int commentsCount = 0;

        if (!currentArticle.findElements(COMMENT_COUNT).isEmpty()) {
            WebElement element = currentArticle.findElement(COMMENT_COUNT);
            String stringToParse = element.getText(); // -> (36)
            stringToParse = stringToParse.substring(1, stringToParse.length() - 1); // (36) -> 36
            commentsCount = Integer.parseInt(stringToParse);
        }

        // !true = false
        // !false = true

        // Open 3rd article
        currentArticle.findElement(TITLE).click();

        // Find and check title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assertions.assertEquals(titleToCompare, articlePageTitle, "Wrong title on article page");

        // Find and check comments count

        // Open comments page

        // Find and check title

        // Find and check comments count
    }
}
