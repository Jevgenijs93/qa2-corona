package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By ACCEPT_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");
    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);
    }

    public String getTextOfArticleById(int id) {
        WebElement titleToGet = baseFunc.findElements(TITLE).get(id);
        String titleToGetText = titleToGet.getText();
        LOGGER.info("Text of title to click: " + titleToGetText);
        return titleToGetText;
    }

    public void openArticleById(int id) {
        WebElement titleToClick = baseFunc.findElements(TITLE).get(id);
        baseFunc.click(titleToClick);
    }

    public String openArticleByText() {
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

        return commentCountText;


    }

}
