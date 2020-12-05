import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiTests {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICAL_TITLE = By.xpath(".//span[@itemprop= 'headline name']");

    @Test
    public void firstDelfiTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe"); // set parameter -  key, path (system (only one) - static object)
        WebDriver driver = new ChromeDriver(); // run Chrome (WebDriver - object, which responds to work with browser window)
        driver.manage().window().maximize();
        driver.get("http://delfi.lv"); // lead to link (get)

        WebDriverWait wait = new WebDriverWait(driver, 10); // max time wait, after that fail test
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN)); // until button will be visible

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();
    }

    @Test
    public void tvnetTest() {
        String articleToOpen = "Seskam Moncas rallijs beidzas drošības barjerās";

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://tvnet.lv");

        List<WebElement> articles = driver.findElements(ARTICAL_TITLE); // find all articles

  /*      for (int i = 0; i < articles.size(); i = i + 1) {
            String currentTitle = articles.get(i).getText();
            if (currentTitle.startsWith(articleToOpen)) {
                articles.get(i).click();
                break;
            }
//            System.out.println(i + ". " + articles.get(i).getText()); // need for print out name of all articles
        } */
        //------------------------------------------foreach--------------------------------------------------------
        for (WebElement we : articles) {
            if (we.getText().startsWith(articleToOpen)) {
                we.click();
                break;
            }

            //  System.out.println(we.getText());
        }
    }
}
