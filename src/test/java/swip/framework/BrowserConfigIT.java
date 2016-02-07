package swip.ch15pageflow.framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import swip.ch15pageflow.framework.Browser;
import swip.ch15pageflow.framework.BrowserRunner;

import javax.inject.Inject;

@RunWith(BrowserRunner.class)
public class BrowserConfigIT {

    @Inject
    private Browser browser;

    @Test
    public void pass() throws Exception {
        browser.get("/");
    }
}