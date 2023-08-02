package org.mln.stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import org.mln.driver.Driver;
import org.mln.enums.ConfigProperties;
import org.mln.utils.PropertyUtil;
import org.mln.utils.ScreenShotUtil;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        Driver.initDriver(PropertyUtil.getValue(ConfigProperties.BROWSER),"Version");
    }
    /**
     * It closes the browser after each test.
     */
    @After
    public void tearDown() {
        Driver.quitDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        scenario.embed(ScreenShotUtil.getByteImage(),"image/png");

    }
}
