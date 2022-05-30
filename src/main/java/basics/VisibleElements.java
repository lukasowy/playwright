package basics;

import com.microsoft.playwright.*;

import java.util.List;

public class VisibleElements {

    private static final String URL_ADDRESS_1 = "http://localhost:5500";
    private static final String URL_ADDRESS_2 = "https://www.amazon.com/";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext1 = browser.newContext();
            Page page1 = browserContext1.newPage();

            //button:visible
            page1.navigate(URL_ADDRESS_1);
            String textContent = page1.locator("button:visible").textContent();
            System.out.println(textContent);

            //button >> visible=true
            textContent = page1.locator("button >> visible=true").textContent();
            System.out.println(textContent);

            BrowserContext browserContext2 = browser.newContext();
            Page page2 = browserContext2.newPage();
            page2.navigate(URL_ADDRESS_2);

            List<String> linksList = page2.locator("a:visible").allInnerTexts();

            linksList.forEach(System.out::println);

            int imagesCount = page2.locator("xpath=//img >> visible=true").count();
            System.out.println(imagesCount);

            page1.close();
            browserContext1.close();

            page2.close();
            browserContext2.close();

        }
    }
}
