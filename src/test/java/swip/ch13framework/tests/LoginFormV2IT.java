package swip.ch13framework.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import swip.ch05pageobjects.LoginForm;
import swip.ch13framework.v6.Browser;
import swip.ch13framework.v6.BrowserRunner;
import swip.ch13framework.v6.Element;

import javax.inject.Inject;

@RunWith(BrowserRunner.class)
public class LoginFormV2IT  {
    @Inject
    private Browser driver;

    @Test
    public void checkLoginForm() throws Exception {
        driver.get("/login.html");

        Element login = driver.untilFound(By.id("login"));

        LoginForm loginForm = new LoginForm(login);
        loginForm.loginAs("foo@bar.com", "secret");

        new WebDriverWait(driver, 1)
            .until(ExpectedConditions.titleIs("You Are Logged In"));
    }
}