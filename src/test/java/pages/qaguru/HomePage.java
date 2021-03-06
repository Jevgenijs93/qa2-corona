package pages.qaguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pages.BaseFunc;

public class HomePage {
    private final By REGISTRATION_BUTTON = By.xpath(".//div[@class = 'cRegistrationBtn']");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("We are on Home Page");
    }

    public RegistrationPage openRegistrationPage() {
        LOGGER.info("Trying to open registration page");

        baseFunc.click(REGISTRATION_BUTTON);
        return new RegistrationPage(baseFunc); // basefunc - open window
    }

}
