package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void ArticleTitleText() {
        WebElement titleToGet = baseFunc.findElement(ARTICLE_TITLE);
        String titleToGetText = titleToGet.getText();
        LOGGER.info("Text of title: " + titleToGetText);

    }
}