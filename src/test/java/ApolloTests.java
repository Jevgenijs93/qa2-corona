import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApolloTests {
    private final String HOME_PAGE_URL = "www.apollo.lv/";
    @Test
    public void articlesCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL(HOME_PAGE_URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.closeAds();

   /*     List<WebElement> titles = homePage.getTitles();
        List<WebElement> comments = homePage.getComments();

        for (int i = 0; i < titles.size(); i++) {
            if (comments.size() > i) {
                System.out.println(titles.get(i).getText() + "::" + comments.get(i).getText());
            } else {
                System.out.println(titles.get(i).getText() + ":: ------------");
            }
        } */

    //   HashMap<String, Integer> articles = homePage.getAllArticles();

        for (Map.Entry<String, Integer> article : homePage.getAllArticles().entrySet()) {
            System.out.println(article.getKey() + " :: " + article.getValue());
        }
    }
}
