package pages;

import org.openqa.selenium.By;

public class ArticlePage {

    private final By ARTICLE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void secondArticleTitleText() {
        baseFunc.getText(ARTICLE_TITLE);
    }
}