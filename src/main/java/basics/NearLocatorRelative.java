package basics;

import com.microsoft.playwright.*;

public class NearLocatorRelative {

    private static final String URL_ADDRESS = "http://automationpractice.com/index.php";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);
            page.locator("input:near(:text('Newsletter'))").first().fill("maniek@gmail.com");


            page.close();
            browserContext.close();
        }
    }
}
