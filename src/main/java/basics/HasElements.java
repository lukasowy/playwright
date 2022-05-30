package basics;

import com.microsoft.playwright.*;

public class HasElements {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext1 = browser.newContext();
            Page page1 = browserContext1.newPage();


            page1.close();
            browserContext1.close();
        }
    }
}
