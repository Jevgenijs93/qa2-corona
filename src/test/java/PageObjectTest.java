import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.CommentPage;
import pages.HomePage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void tvnetPageObjectTest() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        ArticlePage articlePage = new ArticlePage(baseFunc);
        CommentPage commentPage = new CommentPage(baseFunc);

        homePage.acceptCookies();

        String articlePageText = homePage.getTextOfArticleById(1);
        String stringToCompare = articlePageText.substring(0, articlePageText.length() - 5);
        String commentCountOnMainPage = homePage.getCommentCountText(1);
        homePage.openArticleById(1);

        String articleTitleText = articlePage.articleTitleText();
        Assertions.assertEquals(articleTitleText, stringToCompare, "Wrong title opened");
        String commentCountOnArticlePage = articlePage.getCommentCountById(1);
        Assertions.assertEquals(commentCountOnArticlePage, commentCountOnMainPage, "Wrong comment count on article page");
        articlePage.openCommentsById(0);

        String articleTitleOnCommentPageText = commentPage.articleTitleOnCommentPage();
        Assertions.assertEquals(articleTitleOnCommentPageText, stringToCompare, "Comments of wrong title opened");
        String commentCountOnCommentPage = commentPage.getCommentCount();
        Assertions.assertEquals(commentCountOnCommentPage, commentCountOnMainPage, "Wrong comment count on comment page");
    }
}
