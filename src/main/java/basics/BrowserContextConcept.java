package basics;

import com.microsoft.playwright.*;

public class BrowserContextConcept {
    private static final String GOOGLE_URL_ADDRESS = "https:/www.google.com";
    private static final String BUTTON_SELECTOR = "#L2AGLb";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext1 = browser.newContext();
            Page page1 = browserContext1.newPage();
            page1.navigate(GOOGLE_URL_ADDRESS);
            page1.click(BUTTON_SELECTOR);

            BrowserContext browserContext2 = browser.newContext();
            Page page2 = browserContext2.newPage();
            page2.navigate(GOOGLE_URL_ADDRESS);
            page2.click(BUTTON_SELECTOR);

            BrowserContext browserContext3 = browser.newContext();
            Page page3 = browserContext3.newPage();
            page3.navigate(GOOGLE_URL_ADDRESS);
            page3.click(BUTTON_SELECTOR);

            page1.close();
            page2.close();
            page3.close();

            browserContext1.close();
            browserContext2.close();
            browserContext3.close();
        }
    }
}
