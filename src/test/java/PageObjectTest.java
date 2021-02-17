import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void tvnetPageObjectTest() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        ArticlePage articlePage = new ArticlePage(baseFunc);
        homePage.acceptCookies();
        homePage.getTextOfArticleById(3);
        homePage.openArticleById(3);
        articlePage.secondArticleTitleText();
    }
}
