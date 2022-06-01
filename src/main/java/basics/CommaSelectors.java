package basics;

import com.microsoft.playwright.*;

public class CommaSelectors {

    private static final String URL_ADDRESS = "https://academy.naveenautomationlabs.com/";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate(URL_ADDRESS);

            Locator locator = page.locator("span:has-text('SignIn'), " +
                    "span:has-text('LogIn'), " +
                    "span:has-text('Login'), " +
                    "span:has-text(Signin)");


            page.close();
            context.close();
        }
    }
}
