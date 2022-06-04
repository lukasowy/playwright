package basics;

import com.microsoft.playwright.*;

public class NthElementSelector {

    private static final String URL_ADDRESS = "http://automationpractice.com/index.php";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS);

            Locator firstElement = page.locator("div.footer-links li a >> nth=0");
            String firstElementText = firstElement.textContent();
            System.out.println(firstElementText);

            Locator lastElement = page.locator("div.footer-links li a >> nth=-1");
            String lastElementText = lastElement.textContent();
            System.out.println(lastElementText);

            page.close();
            browserContext.close();
        }
    }
}
