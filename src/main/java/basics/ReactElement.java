package basics;

import com.microsoft.playwright.*;

import java.util.List;

public class ReactElement {
    private static final String URL_ADDRESS = "https://www.netflix.com/pl-en/";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);

            Locator email = page.locator("_react=p[name='email'] >> input").first();
            email.fill("maniek@gmail.com");

            page.locator("_react=UISelect[data-uia='language-picker']").click();

            Locator footer = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
            List<String> footerList = footer.allInnerTexts();

            footerList.forEach(System.out::println);

            page.close();
            browserContext.close();
        }
    }
}
