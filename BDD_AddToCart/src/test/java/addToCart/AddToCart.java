package addToCart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class AddToCart {

    WebDriver driver;
    @Given("User navigate to the Amazon application")
    public void userNavigateToTheAmazonApplication() {
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(driver.getTitle());

    }
    @Given("User search product by name")
    public void userSearchProductByName() {
        WebElement searchbar = driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
        searchbar.sendKeys("iphone13");
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();

    }

    @When("User click on the Add to cart button of one item")
    public void userClickOnTheAddToCartButtonOfOneItem() {
        WebElement addToCartBtn = driver.findElement(By.id("a-autoid-1-announce"));
        addToCartBtn.click();
    }

    @Then("Item should be added to the cart successfully")
    public void itemShouldBeAddedToTheCartSuccessfully() {
        WebElement successMsg = driver.findElement(By.xpath("//strong[text()='Item Added']"));
        boolean actualResult = successMsg.isDisplayed();
        Assert.assertTrue(actualResult, "Success message missing when user add item to cart");
        driver.quit();

    }

}
