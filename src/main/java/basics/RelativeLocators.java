package basics;

import com.microsoft.playwright.*;

public class RelativeLocators {

    private static final String URL_ADDRESS = "https://selectorshub.com/xpath-practice-page/";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate(URL_ADDRESS);
            page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();

            page.close();
            browserContext.close();
        }
    }
}
