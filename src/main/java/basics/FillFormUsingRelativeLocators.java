package basics;

import com.microsoft.playwright.*;

public class FillFormUsingRelativeLocators {

    private static final String URL_ADDRESS = "https://www.orangehrm.com/orangehrm-30-day-trial/";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);
            page.locator("input:below(label:text('Full Name'))").first().fill("Maniek");
            page.locator("input:below(label:text('Email'))").first().fill("Maniek@gmail.com");
            page.locator("input:below(label:text('Phone Number'))").first().fill("007");


            page.close();
            browserContext.close();
        }
    }
}
