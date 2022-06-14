package basics;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ScreenshotConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://naveenautomationlabs.com/opencart/");

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("screenshotpage.png"))
                    .setFullPage(true));

            page.close();
            browserContext.close();
        }
    }
}
