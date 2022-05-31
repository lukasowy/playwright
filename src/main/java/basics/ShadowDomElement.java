package basics;

import com.microsoft.playwright.*;

public class ShadowDomElement {
    private static final String URL_ADDRESS_1 = "http://books-pwakit.appspot.com/";
    private static final String URL_ADDRESS_2 = "https://selectorshub.com/xpath-practice-page/";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            //Page -- DOM --> Shadow DOM --> elements
            //Page -- DOM --> iFrame --> Shadow DOM --> elements

            BrowserContext browserContext1 = browser.newContext();
            Page page1 = browserContext1.newPage();

            page1.navigate(URL_ADDRESS_1);
            page1.locator("book-app[apptitle='BOOKS'] #input").fill("Maniek");
            String textContent = page1.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
            System.out.println(textContent);

            BrowserContext browserContext2 = browser.newContext();
            Page page2 = browserContext2.newPage();

            page2.navigate(URL_ADDRESS_2);
            page2.frameLocator("#pact").locator("div#snacktime #tea").fill("Elo Elo");

            page1.close();
            browserContext1.close();

            page2.close();
            browserContext2.close();
        }
    }
}
