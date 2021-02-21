package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommentPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains (@class,  'article-comments-heading__count')]");
    private final By ARTICLE_COMMENTS_COUNT = By.xpath(".//li[@class = 'article-comment']");
    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String articleTitleOnCommentPage() {
        WebElement titleToGet = baseFunc.findElement(ARTICLE_TITLE);
        String titleToGetText = titleToGet.getText();
        LOGGER.info("Text of title: " + titleToGetText);
        return titleToGetText;
    }

    public String getCommentCount() {
        WebElement getCommentCountElement = baseFunc.findElement(COMMENT_COUNT);
        String getCommentCountText = getCommentCountElement.getText();
        LOGGER.info("Comment count on comment page: " + getCommentCountText);
        return getCommentCountText;
    }

    public String countComments() {
        WebElement getCommentElement = baseFunc.findElements(ARTICLE_COMMENTS_COUNT);
    }


}
