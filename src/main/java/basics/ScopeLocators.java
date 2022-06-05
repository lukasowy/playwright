package basics;

import com.microsoft.playwright.*;

public class ScopeLocators {
    private static final String URL_ADDRESS = "https://datatables.net/extensions/select/examples/initialisation/checkbox.html";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);

            Locator row = page.locator("table#example tr");
            row.locator(":scope", new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();

            row.locator(":scope").allInnerTexts().forEach(System.out::println);

            page.close();
            browserContext.close();
        }
    }
}
