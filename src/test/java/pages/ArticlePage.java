package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENT_BTN = By.xpath(".//img[@src = '/v5/img/icons/comment-v2.svg']");
    private final By COMMENT_COUNT = By.xpath(".//span[@class = 'article-share__item--count']");
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String articleTitleText() {
        WebElement titleToGet = baseFunc.findElement(ARTICLE_TITLE);
        String titleToGetText = titleToGet.getText();
        LOGGER.info("Text of title: " + titleToGetText);
        return titleToGetText;
    }

    public void openCommentsById(int id) {
        WebElement commentButtonToClick = baseFunc.findElements(COMMENT_BTN).get(id);
        baseFunc.click(commentButtonToClick);
    }

    public String getCommentCountById(int id) {
        WebElement CommentCountToGet = baseFunc.findElements(COMMENT_COUNT).get(id);
        String CommentCountToGetText = CommentCountToGet.getText();
        LOGGER.info("Comment count on article page: " + CommentCountToGetText);
        return CommentCountToGetText;
    }
}
