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
    private final By HEADLINE_ARTICLE_TITLE = By.xpath(".//h1[@class = 'article-headline']");
    //   private final By COMMENT_COUNT = By.xpath(".//span[@class = 'article-share__item--count']");

    @Test
    public void tvnetTest() throws InterruptedException {
        String articleToOpen = "Tirdzniecības ierobežojumu laikā būs aizliegta arī būvmateriālu mazumtirdzniecība";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        // 1. click on random article and go to comments page

        WebElement articleTitle = driver.findElement(ARTICLE_TITLE);
        String firstArticleText = articleTitle.getText();
        System.out.println(firstArticleText);
        articleTitle.click();

        WebElement secondArticleTitle = driver.findElement(HEADLINE_ARTICLE_TITLE);
        String secondArticleText = secondArticleTitle.getText();
        System.out.println(secondArticleText);

     /*   List<WebElement> commentCounts = driver.findElements(COMMENT_COUNT);
        WebElement commentCount = commentCounts.get(1);
        String commentCountText = commentCount.getText();
        System.out.println(commentCountText);

        String secondArticleTextWithCommentCount = secondArticleText + " (" + commentCountText + ")"; */

        boolean firstIsEqual = firstArticleText.contains(secondArticleText);
        System.out.println(firstIsEqual);

        WebDriverWait waitCommentButton = new WebDriverWait(driver, 10);
        waitCommentButton.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_BTN));

        WebElement commentButton = driver.findElement(COMMENT_BTN);
        commentButton.click();

        Thread.sleep(1000);

        // 2. Click on specific article by count

        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(ARTICLE_TITLE);
        WebElement thirdArticle = articles.get(2);
        String thirdArticleText = thirdArticle.getText();
        System.out.println(thirdArticleText);
        articles.get(2).click();

        WebDriverWait waitHeadlineArticleTitle = new WebDriverWait(driver, 10);
        waitHeadlineArticleTitle.until(ExpectedConditions.visibilityOfElementLocated(HEADLINE_ARTICLE_TITLE));

        WebElement fourthArticleTitle = driver.findElement(HEADLINE_ARTICLE_TITLE);
        String fourthArticleText = fourthArticleTitle.getText();
        System.out.println(fourthArticleText);

        boolean secondIsEqual = thirdArticleText.contains(fourthArticleText);
        System.out.println(secondIsEqual);

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

        WebDriverWait waitHeadlineArticleTitle1 = new WebDriverWait(driver, 10);
        waitHeadlineArticleTitle1.until(ExpectedConditions.visibilityOfElementLocated(HEADLINE_ARTICLE_TITLE));

        WebElement fifthArticleTitle = driver.findElement(HEADLINE_ARTICLE_TITLE);
        String fifthArticleText = fifthArticleTitle.getText();
        System.out.println(articleToOpen);
        System.out.println(fifthArticleText);

        boolean thirdIsEqual = articleToOpen.contains(fifthArticleText);
        System.out.println(thirdIsEqual);

    }

}




