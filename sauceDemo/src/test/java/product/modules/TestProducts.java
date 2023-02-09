package product.modules;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;



import java.time.Duration;


@DisplayName("Web Test products")
public class TestProducts {

    private WebDriver browser;

    @BeforeEach
    public void beforeEach(){
        //define your path driver
        System.setProperty("webdriver.chrome.driver", "YOUR CHOMEDRIVER HERE");
        this.browser = new ChromeDriver();
        this.browser.manage().window().maximize();

        //wait
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.browser.get("https://www.saucedemo.com/");

    }

    @Test
    public void login() {
        new LoginPage(browser)
                .sendUser("standard_user")
                .sendPassword("secret_sauce")
                .submit()
                .validateTitle();
    }

    @Test
    public void buyAnewProduct() {
        login();
        new ProductsPage(browser)
                .addAProductInTheCart()
                .finishTheOrder();
    }

    @AfterEach
    public void afterEach(){browser.quit();}

}





