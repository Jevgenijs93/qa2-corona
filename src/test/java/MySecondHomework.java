import org.junit.jupiter.api.Assertions;
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
    private final By COMMENT_COUNT_ON_LANDING_PAGE = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By COMMENT_COUNT_ON_ARTICLE_PAGE = By.xpath(".//span[@class = 'article-share__item--count']");
    private final By COMMENT_COUNT_ON_COMMENT_PAGE = By.xpath(".//span[contains (@class,  'article-comments-heading__count')]");
    private final By ARTICLE_COMMENTS_COUNT = By.xpath(".//li[@class = 'article-comment']");

    @Test
    public void tvnetTest() throws InterruptedException {
        String articleToOpen = "Slimnīcās rodas grūtības ar intensīvās terapijas un reanimācijas gultu nodrošināšanu";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();

        // 1. Click on specific article by count

        driver.get("http://tvnet.lv");

        Thread.sleep(1000);

        List<WebElement> articles = driver.findElements(ARTICLE_TITLE);
        WebElement thirdArticle = articles.get(2);
        String thirdArticleText = thirdArticle.getText();
        System.out.println(thirdArticleText);

        // Find comment count on landing page

        int commentsCount = 0;

        if (!thirdArticle.findElements(COMMENT_COUNT_ON_LANDING_PAGE).isEmpty()) {
            WebElement element = thirdArticle.findElement(COMMENT_COUNT_ON_LANDING_PAGE);
            String stringToParse = element.getText();
            stringToParse = stringToParse.substring(1, stringToParse.length() - 1);
            commentsCount = Integer.parseInt(stringToParse);
        }

        articles.get(2).click();

        WebDriverWait waitHeadlineArticleTitle = new WebDriverWait(driver, 10);
        waitHeadlineArticleTitle.until(ExpectedConditions.visibilityOfElementLocated(HEADLINE_ARTICLE_TITLE));

        WebElement fourthArticleTitle = driver.findElement(HEADLINE_ARTICLE_TITLE);
        String fourthArticleText = fourthArticleTitle.getText();
        System.out.println(fourthArticleText);

        boolean secondIsEqual = thirdArticleText.contains(fourthArticleText);
        System.out.println(secondIsEqual);

        WebDriverWait waitCommentButton = new WebDriverWait(driver, 10);
        waitCommentButton.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_BTN));

        //  Thread.sleep(10000);

        WebElement commentButton = driver.findElement(COMMENT_BTN);

        // Find comment count on article page

        List<WebElement> commentCounts = driver.findElements(COMMENT_COUNT_ON_ARTICLE_PAGE);
        WebElement commentCount = commentCounts.get(1);
        String commentCountText = commentCount.getText();
        int commentsCountTextParse = Integer.parseInt(commentCountText);
        Assertions.assertEquals(commentsCount, commentsCountTextParse, "Wrong comment count");

        commentButton.click();

        // Find comment count on comment page

        WebDriverWait waitCommentCountOnCommentPage = new WebDriverWait(driver, 10);
        waitCommentCountOnCommentPage.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_COUNT_ON_COMMENT_PAGE));

        WebElement commentCountOnCommentPage = driver.findElement(COMMENT_COUNT_ON_COMMENT_PAGE);
        String commentCountOnCommentPageText = commentCountOnCommentPage.getText();
        int commentCountOnCommentPageTextParse = Integer.parseInt(commentCountOnCommentPageText);
        Assertions.assertEquals(commentsCount, commentCountOnCommentPageTextParse, "Wrong comment count");

        // Count comments by myself

        List<WebElement> articleCommentCount = driver.findElements(ARTICLE_COMMENTS_COUNT);
        int articleCommentCountSize = articleCommentCount.size();
        Assertions.assertEquals(commentsCount, articleCommentCountSize, "Wrong comment count");

        Thread.sleep(1000);

        // 2. Click on specific article by article name

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




