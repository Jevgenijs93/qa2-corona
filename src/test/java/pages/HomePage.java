package pages;

import helper.CommentsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final By ADS_CLOSE_BTN = By.xpath(".//div[contains(@style, 'z-index: 61000')]");
    private final By HOMEPAGE_BTN = By.xpath(".//a[contains (@class, 'flex header-logo')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        LOGGER.info("Accepting cookies");
        baseFunc.click(ACCEPT_BTN);
    }

    public String getArticleTitleById(int id) {
        LOGGER.info("Getting article Nr. " + (id + 1) + " title");
        return baseFunc.getText(TITLE, id);
    }

    public ArticlePage openArticleById(int id) {
        LOGGER.info("Open article Nr. " + (id + 1));
        WebElement titleToClick = baseFunc.findElements(TITLE).get(id);
        baseFunc.click(titleToClick);
        return new ArticlePage(baseFunc);
    }

    public int getCommentsCountById(int id) {
        WebElement commentsCount = baseFunc.findElements(COMMENTS_COUNT).get(id);

        CommentsHelper helper = new CommentsHelper();
        return helper.getCommentCount(commentsCount);
    }

    public String openArticleByText() {
        String articleToOpen = "Kompensācija par noslīkušo zēnu: Prokuratūra apgalvo, ka kriminālprocess izbeigts, advokāts norāda uz pretējo";

        List<WebElement> articlesList = baseFunc.findElements(TITLE);

        for (WebElement we : articlesList) {
            if (we.getText().startsWith(articleToOpen)) {
                we.click();
                break;
            }
        }
        LOGGER.info("Text of title to click by text: " + articleToOpen);

        return articleToOpen;
    }

    public String getCommentCountText(int id) {
        WebElement titleToGet = baseFunc.findElements(TITLE).get(id);
        WebElement element = titleToGet.findElement(COMMENTS_COUNT);

        String commentCountText = element.getText();
        commentCountText = commentCountText.substring(1, commentCountText.length() - 1);

        return commentCountText;
    }

    public void closeAds() {
        if (baseFunc.isElementPresents(ADS_CLOSE_BTN)) {
            baseFunc.click(ADS_CLOSE_BTN);
        }
    }

    public void goToHomePage() {
        if (baseFunc.isElementPresents(HOMEPAGE_BTN)) {
            baseFunc.click(HOMEPAGE_BTN);
        }
    }



    public List<WebElement> getTitles() {
        return baseFunc.findElements(TITLE);
    }


    public List<WebElement> getComments() {
        return baseFunc.findElements(COMMENTS_COUNT);
    }

    public HashMap<String, Integer> getAllArticles() {
        List<WebElement> articles = baseFunc.findElements(ARTICLE);

        HashMap<String, Integer> allArticles = new HashMap<String, Integer>();

        for (WebElement we : articles) {
            if (we.findElement(TITLE).getText().length() != 0) {
                String title = we.findElement(TITLE).getText();
                int commentsCount = 0;

                if (!we.findElements(COMMENTS_COUNT).isEmpty()) {
                    String commentsToParse = we.findElement(COMMENTS_COUNT).getText();
                    commentsCount = Integer.parseInt(commentsToParse.substring(1, commentsToParse.length() - 1));
                }
                allArticles.put(title, commentsCount);
            }

        }
        return allArticles;
    }

}

    /*    for (WebElement we : articles) {
            if (we.findElement(TITLE).getText().length() !=0) {
                String title = we.findElement(TITLE).getText();
                Integer commentsCount;

                if (we.findElements(COMMENTS_COUNT).isEmpty()) {
                    commentsCount = 0;
                } else {
                    String commentsToParse = we.findElement(COMMENTS_COUNT).getText();
                    commentsCount = Integer.parseInt(commentsToParse.substring(1, commentsToParse.length() -1));
                }
                allArticles.put(title, commentsCount);
            }
        }
        return allArticles; */




