package basics;

import com.microsoft.playwright.*;

public class XpathLocator {
    private static final String URL_ADDRESS = "https://amazon.com";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);

            page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Android");
            page.locator("//input[@id='twotabsearchtextbox']").fill("Tablet");

            page.close();
            browserContext.close();
        }
    }
}
