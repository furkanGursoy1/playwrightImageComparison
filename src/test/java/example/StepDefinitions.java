package example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static example.acceptCookie.acceptCookies;

public class StepDefinitions {

    Page page = Hooks.getPage();
    acceptCookie AcceptCookie = new acceptCookie();

    @Given("I open the Playwright website")
    public void i_open_the_playwright_website() {

        page.navigate("https://playwright.dev/");
        page.navigate("https:www.koctas.com.tr");
        System.out.println(page.url());

    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {

        String title = page.title();
        assert title.equals(expectedTitle);

    }

    @Given("Kullanici koctas websitesine girer")
    public void kullanici_koctas_websitesine_girer() {
        page.navigate("https://www.koctas.com.tr/login");
        System.out.println(page.url());
        acceptCookies(page);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("logintest.png")));
    }

    @Given("Kullanici bilgilerini girer")
    public void kullanici_bilgilerini_girer() {
        page.locator("#j_username").fill("");
        page.locator("#j_password").fill("");
        page.locator("#loginButton").click();

    }

    @Given("Kullanici basarili bir sekilde login olur")
    public void kullanici_basarili_bir_sekilde_login_olur() throws IOException {
        Assertions.assertEquals("https://www.koctas.com.tr/", page.url());
        System.out.println("Page title: " + page.title());
        AcceptCookie.compareImages("logintest.png", "loginreferans.png");
    }
}

