package basics;

import com.microsoft.playwright.*;

public class JsPopUpHandle {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.onDialog(dialog -> {
                String message = dialog.message();
                System.out.println(message);
                dialog.accept("Maniek");
            });

            page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

            //Js Alerts, Prompts, Confirmation pop ups
            page.click("//button[text()='Click for JS Alert']");
            page.click("//button[text()='Click for JS Confirm']");
            page.click("//button[text()='Click for JS Prompt']");

            String result = page.textContent("#result");
            System.out.println(result);


            page.close();
            browserContext.close();
        }
    }
}
