package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHooks {
    static WebDriver driver;

    public ScreenshotHooks() {
    }
   
    public ScreenshotHooks(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void takeScreenshotAfterScenario(Scenario scenario) {
        if (!scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }
}
