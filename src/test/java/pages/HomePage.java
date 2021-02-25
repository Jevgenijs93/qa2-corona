package pages;

import helper.CommentsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        LOGGER.info("Accepting cookies");
        baseFunc.click(ACCEPT_BTN);
    }

 /*   public String getTextOfArticleById(int id) {
        WebElement titleToGet = baseFunc.findElements(TITLE).get(id);
        String titleToGetText = titleToGet.getText();
        LOGGER.info("Text of title to click: " + titleToGetText);
        return titleToGetText;
    } */

    public String getArticleTitleById (int id) {
        LOGGER.info("Getting article Nr. " + (id + 1) + " title");
        return  baseFunc.getText(TITLE, id);
    }

    public ArticlePage openArticleById(int id) {
        LOGGER.info("Open article Nr. " + (id + 1));
        WebElement titleToClick = baseFunc.findElements(TITLE).get(id);
        baseFunc.click(titleToClick);
        return new ArticlePage(baseFunc);
    }

    public int getCommentsCountById(int id) {
        WebElement commentsCount = baseFunc.findElements(COMMENT_COUNT).get(id);

        CommentsHelper helper = new CommentsHelper();
        return helper.getCommentCount(commentsCount);
    }

  /*  public String openArticleByText() {
        String articleToOpen = "Aizvadītajā nedēļā ik dienu poti pret Covid-19 saņēma vidēji 1170 cilvēki";
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
        WebElement element = titleToGet.findElement(COMMENT_COUNT);

        String commentCountText = element.getText();
        commentCountText = commentCountText.substring(1, commentCountText.length() - 1);

        return commentCountText; */


    }


