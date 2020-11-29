import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DelfiTests {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");

    @Test
    public void firstDelfiTest()  {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe"); // set parameter -  key, path (system (only one) - static object)
        WebDriver driver = new ChromeDriver(); // run Chrome (WebDriver - object, which responds to work with browser window)
        driver.manage().window().maximize();
        driver.get("http://delfi.lv"); // lead to link (get)

        WebDriverWait wait = new WebDriverWait(driver, 10); // max time wait, after that fail test
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCEPT_COOKIE_BTN)); // until button will be visible

        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIE_BTN);
        acceptBtn.click();



    }
}
