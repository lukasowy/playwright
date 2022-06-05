package basics;

import com.microsoft.playwright.*;

public class XpathLocator {
    private static final String URL_ADDRESS_1 = "https://amazon.com";
    private static final String URL_ADDRESS_2 = "https://selectorshub.com/xpath-practice-page/";


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate(URL_ADDRESS_1);

            page.locator("xpath=//input[@id='twotabsearchtextbox']").fill("Android");
            page.locator("//input[@id='twotabsearchtextbox']").fill("Tablet");
            Locator allAmazonLinks = page.locator("//a[contains(text(),'Amazon')]");
            System.out.println(allAmazonLinks.count());

            allAmazonLinks.allInnerTexts().forEach(System.out::println);

            BrowserContext browserContext2 = browser.newContext();
            Page page2 = browserContext2.newPage();
            page2.navigate(URL_ADDRESS_2);

            page2.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
            Locator checkboxes = page2.locator("//table[@id='resultTable']//input[@type='checkbox']");
            checkboxes.elementHandles().forEach(ElementHandle::check);

            page.close();
            browserContext.close();

            page2.close();
            browserContext2.close();
        }
    }
}
