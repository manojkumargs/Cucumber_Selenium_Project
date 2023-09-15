package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class shoecarnivalpom {
	
	static WebDriver driver;
	JavascriptExecutor js;
	Actions a;
	static WebDriverWait wait;
	ScreenshotHooks screenshotHooks;
	public shoecarnivalpom() {	
	}
	
	By account=By.linkText("Account");
	By email_id=By.xpath("//input[@name='email' and @type='email']");
	By password_id=By.name("password");
	By login=By.className("MuiButton-label");
	By brands=By.linkText("BRANDS");
	By adidas=By.linkText("Adidas");
	By whitecolor=By.xpath("//*[@id=\"sv-category-page\"]/div[4]/div[1]/div/div[4]/div[2]/div/div/div/div/div[1]/div/div[2]/button/span");
	By select_product=By.xpath("//*[@id=\"item-0\"]/div/div[1]/a/div/img");
	By size_product=By.xpath("//*[@id=\"sv-product-page\"]/div/div[1]/div[2]/div/div[5]/div[3]/div[11]/button/span[1]");
	By add_to_bag=By.xpath("//*[@id=\"sv-product-page\"]/div/div[1]/div[2]/div/div[10]/button");
	By view_bag=By.linkText("VIEW CART");
	
	By acc_menu=By.xpath("//*[@id=\"__next\"]/header/div/div[2]/div[1]/div[2]/div/div[2]/div[4]/div[1]/div/div/span/a/span");
	By logout=By.linkText("LOGOUT");
	
	@Given("launch the browser")
	public void launch_the_browser() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  screenshotHooks = new ScreenshotHooks(driver);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@And("Navigate to the URL")
	public void navigate_to_the_url() throws InterruptedException {
		  driver.get("https://www.shoecarnival.com/");
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  Thread.sleep(10000);
		  driver.navigate().refresh();
	}

	@When("the user opens account")
	public void the_user_opens_account() throws InterruptedException {
		Thread.sleep(5000);
		js=(JavascriptExecutor)driver;
		driver.findElement(account).click();
	}

	@And("the user enters the {string} and {string}")
	public void the_user_enters_the_and_(String email, String password) throws InterruptedException {
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(email_id)).sendKeys(email);
		driver.findElement(password_id).sendKeys(password);
	}

	@Then("the user clicks on login button")
	public void the_user_clicks_on_login_button() {
		driver.findElement(login).click();
	}

	@Given("click on brands domain")
	public void click_on_brands_domain() throws InterruptedException {
		Thread.sleep(10000);
		js=(JavascriptExecutor)driver;
		a=new Actions(driver);
		a.moveToElement(driver.findElement(brands)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(brands)).click();
	}

	@And("click on adidas in brands")
	public void click_on_adidas_in_brands() {
		js.executeScript("window.scrollBy(0,300)");
		a.moveToElement(driver.findElement(adidas)).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(adidas)).click();
	}

	@And("now click on color change")
	public void now_click_on_color_change() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(whitecolor)).click();
	}

	@When("user selects one product")
	public void user_selects_one_product() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,0)");
        wait.until(ExpectedConditions.elementToBeClickable(select_product)).click();
        Thread.sleep(3000);
	}

	@And("selects the product size")
	public void selects_the_product_size() {
		js.executeScript("window.scrollBy(0,600)");
		wait.until(ExpectedConditions.elementToBeClickable(size_product)).click();
	}

	@Then("adds to cart")
	public void adds_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.elementToBeClickable(add_to_bag)).click();
	}

	@Given("view product in cart")
	public void view_product_in_cart() {
		wait.until(ExpectedConditions.elementToBeClickable(view_bag)).click();
	}

	@And("click on account menu")
	public void click_on_account_menu() throws InterruptedException {
		Thread.sleep(3000);
		a=new Actions(driver);
		a.moveToElement(driver.findElement(acc_menu)).perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(acc_menu)).click();
	}

	@Then("click on logout there")
	public void click_on_logout_there() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
		Thread.sleep(3000);
	}
	
	@AfterAll
	public static void last() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
