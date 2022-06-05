package basics;

import com.microsoft.playwright.*;

public class ScopeLocators {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.close();
            browserContext.close();
        }
    }
}
