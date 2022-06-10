package basics;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;

public class FileUploadHandle {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

            page.setInputFiles("input[name='upfile']", new FilePayload("naveen.text",
                    "text/plain",
                    "this is naveen here".getBytes(StandardCharsets.UTF_8)));

            page.click("input[value='Press']");

            page.close();
            browserContext.close();
        }
    }
}
