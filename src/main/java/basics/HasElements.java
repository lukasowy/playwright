package basics;

import com.microsoft.playwright.*;

public class HasElements {
    private static final String URL_ADDRESS_1 = "https://www.orangehrm.com/orangehrm-30-day-trial/";
    private static final String URL_ADDRESS_2 = "https://www.amazon.com/";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate(URL_ADDRESS_1);
            Locator locator = page.locator("select#Form_submitForm_Country:has(option[value='India'])");
            locator.allInnerTexts().forEach(System.out::println);

            BrowserContext context2 = browser.newContext();
            Page page2 = context2.newPage();
            page2.navigate(URL_ADDRESS_2);

            Locator footerLocator = page2.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
            footerLocator.allInnerTexts().forEach(System.out::println);

            page.close();
            context.close();

            page2.close();
            context2.close();
        }
    }
}
