package org.example.basics;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.deque.html.axecore.results.AxeResults;
import com.microsoft.playwright.*;
import com.deque.html.axecore.playwright.*; // 1
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

// Enable video recording
            Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos")) // Directory to save videos
                    .setRecordVideoSize(1280, 720); // Optional: set resolution

            BrowserContext context = browser.newContext(contextOptions);

            Page page = context.newPage();

            page.navigate("https://playwright.dev");

            System.out.println("path of the vide"+page.video().path());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            context.close();
//            page.getByText("Get started").click();
//            page.
//            System.out.println(page.title());

            // Expect a title "to contain" a substring.
   //         assertThat(page).hasTitle(Pattern.compile("Playwrightsdefsef"));

            // create a locator
//            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
//
//            // Expect an attribute "to be strictly equal" to the value.
//            assertThat(getStarted).hasAttribute("href", "/docs/intro");
//
//            // Click the get started link.
//            getStarted.click();
//
//            // Expects page to have a heading with the name of Installation.
//            assertThat(page.getByRole(AriaRole.HEADING,
//               new Page.GetByRoleOptions().setName("Installation"))).isVisible();
        }
    }
}