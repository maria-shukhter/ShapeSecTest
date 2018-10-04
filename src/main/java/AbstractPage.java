import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage (){
        System.setProperty("webdriver.gecko.driver", "/Users/maria_shukhter/Desktop/selenium");
        System.setProperty("webdriver.chrome.driver", "/Users/maria_shukhter/Desktop/selenium/chromedriver");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
