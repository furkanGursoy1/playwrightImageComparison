package example;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Hooks {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(375, 667)
                .setUserAgent("KoctasHeadlessChrome"));
        page = context.newPage();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (Files.exists(Paths.get("diff.png"))) {
            try {
                byte[] diffImage = Files.readAllBytes(Paths.get("diff.png"));
            scenario.attach(diffImage, "image/png", "Image Difference");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if (browser != null) {
        browser.close();
    }
    if (playwright != null) {
        playwright.close();
    }
}

    @AfterStep
   public void afterStep(Scenario scenario) {
    if (scenario.isFailed()) {
        final byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(true));
        scenario.attach(screenshot, "image/png", "screenshot");
    }
}

    public static Page getPage() {
        return page;
    }
}