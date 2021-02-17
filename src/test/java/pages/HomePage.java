package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);
    }

    public void openArticleById(int id) {
        WebElement titleToClick = baseFunc.findElements(TITLE).get(id);
        String titleToClickText = titleToClick.getText();
        LOGGER.info("Text of title to click: " + titleToClickText);
        baseFunc.click(titleToClick);
    }

    public void secondArticleTitleText() {
        baseFunc.getText(ARTICLE_TITLE);
    }



}
