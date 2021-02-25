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
    private final int ARTICLE_ID = 2;

    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking titles and comment count");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");


        HomePage homePage = new HomePage(baseFunc);

       // CommentPage commentPage = new CommentPage(baseFunc);

        homePage.acceptCookies();

        // Get 3rd article title on Home Page
        String homePageTitle = homePage.getArticleTitleById(ARTICLE_ID);

      //  String articlePageText = homePage.getTextOfArticleById(2);
      //  String stringToCompare = articlePageText.substring(0, articlePageText.length() - 4);
      //  String commentCountOnMainPage = homePage.getCommentCountText(2);
        homePage.openArticleById(ARTICLE_ID);

        // Get article title on Article Page
        ArticlePage articlePage = homePage.openArticleById(ARTICLE_ID);
      //  ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();





        // Compare article titles
      //  Assertions.assertEquals(homePageTitle, articlePageTitle, "Titles are not the same");
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");
      /*  String articleTitleText = articlePage.articleTitleText();
        Assertions.assertEquals(articleTitleText, stringToCompare, "Wrong title opened");
        String commentCountOnArticlePage = articlePage.getCommentCountById(1);
        Assertions.assertEquals(commentCountOnArticlePage, commentCountOnMainPage, "Wrong comment count on article page");
        articlePage.openCommentsById(0);

        String articleTitleOnCommentPageText = commentPage.articleTitleOnCommentPage();
        Assertions.assertEquals(articleTitleOnCommentPageText, stringToCompare, "Comments of wrong title opened");
        String commentCountOnCommentPage = commentPage.getCommentCount();
        Assertions.assertEquals(commentCountOnCommentPage, commentCountOnMainPage, "Wrong comment count on comment page");
        String getCountCommentsText = commentPage.countComments();
        Assertions.assertEquals(getCountCommentsText, commentCountOnMainPage, "Not correctly comments counted");

        baseFunc.openURL("http://tvnet.lv");

        String getTextOfArticle = homePage.openArticleByText();
        String articleTitleOfOpenedPage = articlePage.articleTitleText();
        Assertions.assertEquals(getTextOfArticle, articleTitleOfOpenedPage, "Wrong title opened by text"); */


    }
}
