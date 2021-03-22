import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;
import pages.CommentPage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 2;
    private final int COMMENTS_COUNT_ID = 1;

    @Test
    public void tvnetPageObjectTest() {
        LOGGER.info("This test is checking titles and comment count");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("http://tvnet.lv");


        HomePage homePage = new HomePage(baseFunc);

        homePage.acceptCookies();
        homePage.closeAds();

        // Get 2nd article title on Home Page
        String homePageTitle = homePage.getArticleTitleById(ARTICLE_ID);

        String stringToCompare = homePageTitle.substring(0, homePageTitle.length() - 5);
        String commentCountOnMainPage = homePage.getCommentCountText(ARTICLE_ID);
        homePage.openArticleById(ARTICLE_ID);
        homePage.closeAds();

        // Get article title on Article Page
        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();
        System.out.println(homePageTitle);
        System.out.println(articlePageTitle);


        // Compare article titles
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not the same");
        String articleTitleText = articlePage.articleTitleText();
        Assertions.assertEquals(articleTitleText, stringToCompare, "Wrong title opened");
        String commentCountOnArticlePage = articlePage.getCommentCountById(COMMENTS_COUNT_ID);
        Assertions.assertEquals(commentCountOnMainPage, commentCountOnArticlePage, "Wrong comment count on article page");
        articlePage.openCommentsById(0);

        CommentPage commentPage = new CommentPage(baseFunc);

        // Compare comments quantity

        String articleTitleOnCommentPageText = commentPage.articleTitleOnCommentPage();
        Assertions.assertEquals(articleTitleOnCommentPageText, stringToCompare, "Comments of wrong title opened");
        String commentCountOnCommentPage = commentPage.getCommentCount();
        Assertions.assertEquals(commentCountOnCommentPage, commentCountOnMainPage, "Wrong comment count on comment page");
        String getCountCommentsText = commentPage.countComments();
        Assertions.assertEquals(commentCountOnMainPage, getCountCommentsText, "Not correctly comments counted");

        // Check find title by text

        homePage.goToHomePage();
        String getTextOfArticle = homePage.openArticleByText();
        String articleTitleOfOpenedPage = articlePage.articleTitleText();
        Assertions.assertEquals(getTextOfArticle, articleTitleOfOpenedPage, "Wrong title opened by text");
    }
}
