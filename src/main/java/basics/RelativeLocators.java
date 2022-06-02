package basics;

import com.microsoft.playwright.*;

public class RelativeLocators {

    private static final String URL_ADDRESS = "https://selectorshub.com/xpath-practice-page/";
    private static Page page;

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            page = browserContext.newPage();

            page.navigate(URL_ADDRESS);
            selectUser("Joe.Root");
            selectUser("Jasmine.Morgan");

            page.locator("td:right-of(:text('Joe.Root'))").first().textContent();

            page.close();
            browserContext.close();
        }
    }

    public static void selectUser(String userName) {
        page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
    }
}
