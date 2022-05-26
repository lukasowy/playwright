package basics;

import com.microsoft.playwright.*;


public class LocatorConcept {
    private static final String URL_ADDRESS_1 = "https://www.orangehrm.com/";
    private static final String URL_ADDRESS_2 = "https://academy.naveenautomationlabs.com/";

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            //locators
            BrowserContext browserContext1 = browser.newContext();
            Page page1 = browserContext1.newPage();
            page1.navigate(URL_ADDRESS_1);

            Locator contactSales = page1.locator("text = CONTACT SALES");
            contactSales.hover();
            contactSales.click();

            BrowserContext browserContext2 = browser.newContext();
            Page page2 = browserContext2.newPage();
            page2.navigate(URL_ADDRESS_2);

            Locator loginBtn = page2.locator("text = Login");
            int count = loginBtn.count();
            System.out.println(count);

            loginBtn.first().click();
            

            page1.close();
            browserContext1.close();

            page2.close();
            browserContext2.close();


        }
    }
}
