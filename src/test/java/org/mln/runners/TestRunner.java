package org.mln.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features ="src/test/resources/features",
        glue={"org.mln.stepDef"},
        monochrome= true,
        plugin=
                {
                        "pretty"
                        //,"html:target/HtmlReports/index.html"
                        ,"json:target/JsonReports/index.json"
                        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                      //  ,"junit:target/XmlReports/index.xml"
                        ,"timeline:test-output-thread/"
                        ,"rerun:target/failedrerun.txt"
                }
        ,tags = "@functional"

)

public class TestRunner extends AbstractTestNGCucumberTests {

}

