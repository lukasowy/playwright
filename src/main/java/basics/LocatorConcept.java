package basics;

import com.microsoft.playwright.*;

import java.util.List;


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

            BrowserContext browserContext3 = browser.newContext();
            Page page3 = browserContext3.newPage();
            page3.navigate(URL_ADDRESS_1);

            Locator bookFreeDemo = page3.locator("text = BOOK A FREE DEMO");
            bookFreeDemo.hover();
            bookFreeDemo.click();

            Locator countryOptions = page3.locator("select#Form_submitForm_Country option");
            int countryCount = countryOptions.count();
            System.out.println(countryCount);
            System.out.println(countryOptions.nth(countryCount / 2).textContent());

            List<String> countries = countryOptions.allTextContents();

            countries.forEach(System.out::println);

            page1.close();
            browserContext1.close();

            page2.close();
            browserContext2.close();

            page3.close();
            browserContext3.close();

        }
    }
}
